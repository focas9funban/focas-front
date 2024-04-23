package com.api.dto;

public class QueryResultDto extends ResultDto {
	private String merchantID;
	private String lidm;
	private String lastPan4;
	private String authCode;
	private String authAmt;
	private String xid;
	private String cardBrand;
	private String authRespTime;
	private String downPayments;
	private String installmentPayments;
	private String bonusActionCode;
	private String bonusDesc;
	private String bonusRespCode;
	private String bonusSign;
	private String bonusBalance;
	private String bonusDeduct;
	private String bonusDeductAmt;
	private String keyExpiryDate;
	private String txstate;

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public String getLidm() {
		return lidm;
	}

	public void setLidm(String lidm) {
		this.lidm = lidm;
	}

	public String getLastPan4() {
		return lastPan4;
	}

	public void setLastPan4(String lastPan4) {
		this.lastPan4 = lastPan4;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthAmt() {
		return authAmt;
	}

	public void setAuthAmt(String authAmt) {
		this.authAmt = authAmt;
	}

	public String getXid() {
		return xid;
	}

	public void setXid(String xid) {
		this.xid = xid;
	}

	public String getCardBrand() {
		return cardBrand;
	}

	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}

	public String getAuthRespTime() {
		return authRespTime;
	}

	public void setAuthRespTime(String authRespTime) {
		this.authRespTime = authRespTime;
	}

	public String getDownPayments() {
		return downPayments;
	}

	public void setDownPayments(String downPayments) {
		this.downPayments = downPayments;
	}

	public String getInstallmentPayments() {
		return installmentPayments;
	}

	public void setInstallmentPayments(String installmentPayments) {
		this.installmentPayments = installmentPayments;
	}

	public String getBonusActionCode() {
		return bonusActionCode;
	}

	public void setBonusActionCode(String bonusActionCode) {
		this.bonusActionCode = bonusActionCode;
	}

	public String getBonusDesc() {
		return bonusDesc;
	}

	public void setBonusDesc(String bonusDesc) {
		this.bonusDesc = bonusDesc;
	}

	public String getBonusRespCode() {
		return bonusRespCode;
	}

	public void setBonusRespCode(String bonusRespCode) {
		this.bonusRespCode = bonusRespCode;
	}

	public String getBonusSign() {
		return bonusSign;
	}

	public void setBonusSign(String bonusSign) {
		this.bonusSign = bonusSign;
	}

	public String getBonusBalance() {
		return bonusBalance;
	}

	public void setBonusBalance(String bonusBalance) {
		this.bonusBalance = bonusBalance;
	}

	public String getBonusDeduct() {
		return bonusDeduct;
	}

	public void setBonusDeduct(String bonusDeduct) {
		this.bonusDeduct = bonusDeduct;
	}

	public String getBonusDeductAmt() {
		return bonusDeductAmt;
	}

	public void setBonusDeductAmt(String bonusDeductAmt) {
		this.bonusDeductAmt = bonusDeductAmt;
	}

	public String getKeyExpiryDate() {
		return keyExpiryDate;
	}

	public void setKeyExpiryDate(String keyExpiryDate) {
		this.keyExpiryDate = keyExpiryDate;
	}

	public String getTxstate() {
		return txstate;
	}

	public void setTxstate(String txstate) {
		this.txstate = txstate;
	}

	@Override
	public String toString() {
		return "QueryResultDto [merchantID=" + merchantID + ", lidm=" + lidm + ", lastPan4=" + lastPan4 + ", authCode="
				+ authCode + ", authAmt=" + authAmt + ", xid=" + xid + ", cardBrand=" + cardBrand + ", authRespTime="
				+ authRespTime + ", downPayments=" + downPayments + ", installmentPayments=" + installmentPayments
				+ ", bonusActionCode=" + bonusActionCode + ", bonusDesc=" + bonusDesc + ", bonusRespCode="
				+ bonusRespCode + ", bonusSign=" + bonusSign + ", bonusBalance=" + bonusBalance + ", bonusDeduct="
				+ bonusDeduct + ", bonusDeductAmt=" + bonusDeductAmt + ", keyExpiryDate=" + keyExpiryDate + ", txstate="
				+ txstate + "]";
	}

}
