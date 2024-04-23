package com.api.dto;

public class ResultDto {
	private String status;

	private String errCode;

	private String errDesc;

	private String merKeyVersion;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrDesc() {
		return errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}

	public String getMerKeyVersion() {
		return merKeyVersion;
	}

	public void setMerKeyVersion(String merKeyVersion) {
		this.merKeyVersion = merKeyVersion;
	}

	@Override
	public String toString() {
		return "ResultDto [status=" + status + ", errCode=" + errCode + ", errDesc=" + errDesc + ", merKeyVersion="
				+ merKeyVersion + "]";
	}

}
