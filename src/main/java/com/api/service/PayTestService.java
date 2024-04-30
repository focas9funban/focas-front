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
import com.google.gson.Gson;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class PayTestService {

	private static final Logger log = LoggerFactory.getLogger(PayTestService.class);

	@Autowired
	private ToolUtil toolUtil;

	@Value("${focas.domain.test}")
	private String domain;

	public QueryResultDto query(ParamsDto params) {
		log.info("focas test query start...");
		log.info("focas test query lidm:" + params.getLidm());

		QueryResultDto result = new QueryResultDto();
		try {
			if (StringUtils.isBlank(params.getLidm())) {
				throw new Exception("focas test query can not find lidm");
			}

			result = new Gson().fromJson(toolUtil.post(domain + ToolUtil.QUERY, params), QueryResultDto.class);
			
		} catch (Exception ex) {
			log.error("focas test query error: " + ex.getMessage(), ex);
			result.setStatus("-1");
			result.setErrCode("-999");
			result.setErrDesc(ex.getMessage());
		}

		log.info("focas test query end...");

		return result;
	}

	public ResultDto cancel(ParamsDto params) {
		log.info("focas test cancel start...");
		log.info("focas test cancel lidm:" + params.getLidm());

		ResultDto result = new ResultDto();
		try {
			if (StringUtils.isBlank(params.getLidm())) {
				throw new Exception("focas test cancel can not find lidm");
			}

			result = new Gson().fromJson(toolUtil.post(domain + ToolUtil.CANCEL, params), ResultDto.class);
			
		} catch (Exception ex) {
			log.error("focas test cancel error: " + ex.getMessage(), ex);
			result.setStatus("-1");
			result.setErrCode("-999");
			result.setErrDesc(ex.getMessage());
		}

		log.info("focas test cancel end...");

		return result;
	}
	
	public ResultDto refund(ParamsDto params) {
		log.info("focas test refund start...");
		log.info("focas test refund lidm:" + params.getLidm());

		ResultDto result = new ResultDto();
		try {
			if (StringUtils.isBlank(params.getLidm())) {
				throw new Exception("focas test refund can not find lidm");
			}

			result = new Gson().fromJson(toolUtil.post(domain + ToolUtil.REFUND, params), ResultDto.class);
			
		} catch (Exception ex) {
			log.error("focas test refund error: " + ex.getMessage(), ex);
			result.setStatus("-1");
			result.setErrCode("-999");
			result.setErrDesc(ex.getMessage());
		}

		log.info("focas test refund end...");

		return result;
	}

}
