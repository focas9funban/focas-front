#IP=$(ip addr |grep inet|grep -v 127.0.0.1|grep -v inet6|awk '{print $2}'|grep -v 172| cut -d'/' -f 1)
FOCAS_ROOT=/usr/AP
FOCAS_PATH=${FOCAS_ROOT}/focas
FOCAS_LOG_PATH=${FOCAS_PATH}/logs
#ENV=prod

PID=$(ps -ef | grep java | grep api | awk '{print $2}')

#[ $IP = "10.0.2.29" ] && ENV="dev"

#echo this environment is [${ENV}]

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
	 -jar api.jar --spring.profiles.active=dev \
	 > /dev/null 2>&1 &
	 
tail -f ${FOCAS_LOG_PATH}/info.log