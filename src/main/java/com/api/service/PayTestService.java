package com.api.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.api.data.TransType;
import com.api.dto.ParamsDto;
import com.api.dto.QueryResultDto;
import com.api.dto.ResultDto;
import com.fisc.b2ctoolkit.action.FOCASPayRequest;
import com.google.gson.Gson;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class PayTestService {

	private static final Logger log = LoggerFactory.getLogger(PayTestService.class);

	public ResultDto cancel(ParamsDto params) {
		log.info("cancel test start...");
		log.info(params.toString());

		ResultDto result = new ResultDto();
		try {
			URL url = new URL("http://localhost:8086/focas/payment/cancel");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			connection.setDoOutput(true);

			String jsonParams = new Gson().toJson(params);

			try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
				outputStream.write(jsonParams.getBytes());
				outputStream.flush();
			}

			int responseCode = connection.getResponseCode();
			log.info("Response Code: " + responseCode);

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            
            Gson gson = new Gson();
            result = gson.fromJson(response.toString(), ResultDto.class);
            
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("cancel end...");

		return result;
	}

	public QueryResultDto query(ParamsDto params) {
		log.info("query start...");
		log.info(params.toString());

		QueryResultDto result = new QueryResultDto();
		try {
			if (StringUtils.isBlank(params.getLidm())) {
				throw new Exception("query can not find lidm");
			}

			FOCASPayRequest apiClient = new FOCASPayRequest();
			apiClient.setAPITransType(TransType.QUERY);
			apiClient.setMerchantID(params.getMerchantId());
			apiClient.setLidm(params.getLidm());
			apiClient.transaction();

			log.info("query status: " + apiClient.getStatus());

			result.setStatus(apiClient.getStatus());
			result.setErrCode(apiClient.getErrCode());
			result.setErrDesc(apiClient.getErrDesc());
			result.setMerchantID(apiClient.getMerchantID());
			result.setLidm(apiClient.getLidm());
			result.setLastPan4(apiClient.getLastPan4());
			result.setAuthCode(apiClient.getAuthCode());
			result.setAuthAmt(apiClient.getAuthAmt());
			result.setXid(apiClient.getXid());
			result.setCardBrand(apiClient.getCardBrand());
			result.setAuthRespTime(apiClient.getAuthRespTime());
			result.setDownPayments(apiClient.getDownPayments());
			result.setInstallmentPayments(apiClient.getInstallmentPayments());
			result.setBonusActionCode(apiClient.getBonusActionCode());
			result.setBonusDesc(apiClient.getBonusDesc());
			result.setBonusRespCode(apiClient.getBonusRespCode());
			result.setBonusSign(apiClient.getBonusSign());
			result.setBonusBalance(apiClient.getBonusBalance());
			result.setBonusDeduct(apiClient.getBonusDeduct());
			result.setBonusDeductAmt(apiClient.getBonusDeductAmt());
			result.setKeyExpiryDate(apiClient.getKeyExpiryDate());
			result.setTxstate(apiClient.getTxstate());

		} catch (Exception ex) {
			log.error("query error: " + ex.getMessage(), ex);
			result.setStatus("-1");
			result.setErrCode("-999");
			result.setErrDesc(ex.getMessage());
		}

		log.info("query end...");

		return result;
	}

	public ResultDto refund(ParamsDto params) {
		log.info("refund start...");
		log.info(params.toString());

		ResultDto result = new ResultDto();
		try {
			if (StringUtils.isBlank(params.getLidm())) {
				throw new Exception("refund can not find lidm");
			}

			FOCASPayRequest apiClient = new FOCASPayRequest();
			apiClient.setAPITransType(TransType.REFUND);
			apiClient.setMerchantID(params.getMerchantId());
			apiClient.setLidm(params.getLidm());
			apiClient.setPurchAmt(params.getPurchAmt());
			apiClient.transaction();

			log.info("refund status: " + apiClient.getStatus());

			result.setStatus(apiClient.getStatus());
			result.setErrCode(apiClient.getErrCode());
			result.setErrDesc(apiClient.getErrDesc());

		} catch (Exception ex) {
			log.error("refund error: " + ex.getMessage(), ex);
			result.setStatus("-1");
			result.setErrCode("-999");
			result.setErrDesc(ex.getMessage());
		}

		log.info("refund end...");

		return result;
	}

}
