package com.api.dto;

public class ParamsDto {
	private String merchantId;

	private String lidm;

	private String purchAmt;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getLidm() {
		return lidm;
	}

	public void setLidm(String lidm) {
		this.lidm = lidm;
	}

	public String getPurchAmt() {
		return purchAmt;
	}

	public void setPurchAmt(String purchAmt) {
		this.purchAmt = purchAmt;
	}

	@Override
	public String toString() {
		return "ParamsDto [merchantId=" + merchantId + ", lidm=" + lidm + ", purchAmt=" + purchAmt + "]";
	}

}
