package com.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.api.dto.ParamsDto;
import com.api.dto.QueryResultDto;
import com.api.dto.ResultDto;
import com.api.util.ToolUtil;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class PayProdService {

	private static final Logger log = LoggerFactory.getLogger(PayProdService.class);

	@Autowired
	private ToolUtil toolUtil;

	@Value("${focas.domain.prod}")
	private String domain;

	public QueryResultDto query(ParamsDto params) {
		log.info("focas prod query start...");
		log.info("focas prod query lidm:" + params.getLidm());

		QueryResultDto result = new QueryResultDto();
		try {
			if (StringUtils.isBlank(params.getLidm())) {
				throw new Exception("focas prod query can not find lidm");
			}

			result = (QueryResultDto) toolUtil.post(domain + ToolUtil.QUERY, params);

		} catch (Exception ex) {
			log.error("focas prod query error: " + ex.getMessage(), ex);
			result.setStatus("-1");
			result.setErrCode("-999");
			result.setErrDesc(ex.getMessage());
		}

		log.info("focas prod query end...");

		return result;
	}
	
	public ResultDto cancel(ParamsDto params) {
		log.info("focas prod cancel start...");
		log.info("focas prod cancel lidm:" + params.getLidm());

		ResultDto result = new ResultDto();
		try {
			if (StringUtils.isBlank(params.getLidm())) {
				throw new Exception("focas prod cancel can not find lidm");
			}

			result = (ResultDto) toolUtil.post(domain + ToolUtil.CANCEL, params);

		} catch (Exception ex) {
			log.error("focas prod cancel error: " + ex.getMessage(), ex);
			result.setStatus("-1");
			result.setErrCode("-999");
			result.setErrDesc(ex.getMessage());
		}

		log.info("focas prod cancel end...");

		return result;
	}

	public ResultDto refund(ParamsDto params) {
		log.info("focas prod refund start...");
		log.info("focas prod refund lidm:" + params.getLidm());

		ResultDto result = new ResultDto();
		try {
			if (StringUtils.isBlank(params.getLidm())) {
				throw new Exception("focas prod refund can not find lidm");
			}

			result = (ResultDto) toolUtil.post(domain + ToolUtil.REFUND, params);

		} catch (Exception ex) {
			log.error("focas prod refund error: " + ex.getMessage(), ex);
			result.setStatus("-1");
			result.setErrCode("-999");
			result.setErrDesc(ex.getMessage());
		}

		log.info("focas prod refund end...");

		return result;
	}

}
