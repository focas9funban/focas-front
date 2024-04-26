package com.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.api.data.TransType;
import com.api.dto.ParamsDto;
import com.api.dto.QueryResultDto;
import com.api.dto.ResultDto;
import com.fisc.b2ctoolkit.action.FOCASPayRequest;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class PayService {

	private static final Logger log = LoggerFactory.getLogger(PayService.class);

	public ResultDto cancel(ParamsDto params) {
		log.info("cancel start...");
		log.info(params.toString());

		ResultDto result = new ResultDto();
		try {
			if (StringUtils.isBlank(params.getLidm())) {
				throw new Exception("cancel can not find lidm");
			}

			FOCASPayRequest apiClient = new FOCASPayRequest();
			apiClient.setAPITransType(TransType.CANCEL);
			apiClient.setMerchantID(params.getMerchantId());
			apiClient.setLidm(params.getLidm());
			apiClient.transaction();

			log.info("cancel status: " + apiClient.getStatus());

			result.setStatus(apiClient.getStatus());
			result.setErrCode(apiClient.getErrCode());
			result.setErrDesc(apiClient.getErrDesc());

		} catch (Exception ex) {
			log.error("cancel error: " + ex.getMessage(), ex);
			result.setStatus("-1");
			result.setErrCode("-999");
			result.setErrDesc(ex.getMessage());
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
