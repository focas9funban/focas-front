FOCAS_ROOT=/usr/AP
FOCAS_PATH=${FOCAS_ROOT}/focas-front
FOCAS_LOG_PATH=${FOCAS_PATH}/logs

PID=$(ps -ef | grep java | grep focas-front | awk '{print $2}')

echo rebooting please wait...

kill -15 $PID

git --work-tree=${FOCAS_PATH} pull

cd ${FOCAS_PATH} 

touch nohup.out

source /etc/profile

mvn clean install

mkdir -p ${FOCAS_LOG_PATH}
sudo touch ${FOCAS_LOG_PATH}/info.log

cd ${FOCAS_PATH}/target

sudo nohup java \
	 -jar focas-front.jar \
	 > /dev/null 2>&1 &
	 
tail -f ${FOCAS_LOG_PATH}/info.log