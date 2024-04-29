package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.ParamsDto;
import com.api.dto.QueryResultDto;
import com.api.dto.ResultDto;
import com.api.service.PayTestService;

@RestController
@RequestMapping("/focas/payment/test")
public class PayTestController {
	
	@Autowired
	PayTestService payService;
	
	@PostMapping("/cancel")
	public ResponseEntity<ResultDto> cancel(@RequestBody ParamsDto params) {
		return ResponseEntity.ok(payService.cancel(params));
	}
	
	@PostMapping("/query")
	public ResponseEntity<QueryResultDto> query(@RequestBody ParamsDto params) {
		return ResponseEntity.ok(payService.query(params));
	}
	
	@PostMapping("/refund")
	public ResponseEntity<ResultDto> refund(@RequestBody ParamsDto params) {
		return ResponseEntity.ok(payService.refund(params));
	}
	
}
