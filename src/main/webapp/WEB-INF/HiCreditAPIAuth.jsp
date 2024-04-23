<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "com.fisc.b2ctoolkit.action.FOCASPayRequest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	FOCASPayRequest apiClient = new FOCASPayRequest();

	int trxType = 0;
	String type = (String)request.getParameter("Type");
	if(type!=null && type.equals("Auth")){
		trxType = apiClient.HiCreditAPIAuth;
	}else if(type!=null && type.equals("Period")){
		trxType = apiClient.HiCreditAPIAuthPeriod;
	}else if(type!=null && type.equals("Bonus")){
		trxType = apiClient.HiCreditAPIAuthBonus;
	}
	
	apiClient.setAPITransType(trxType);
	apiClient.setMerchantID((String)request.getParameter("MerchantID"));
	apiClient.setMerchantName((String)request.getParameter("MerchantName"));
	apiClient.setLidm((String)request.getParameter("lidm"));
	apiClient.setPurchAmt((String)request.getParameter("purchAmt"));
	apiClient.setPan((String)request.getParameter("pan"));
	apiClient.setExpiry((String)request.getParameter("expiry"));
	apiClient.setCvv((String)request.getParameter("cvv"));
	apiClient.setPeriodNum((String)request.getParameter("periodNum"));
	apiClient.transaction();
	
	if(!apiClient.getErrCode().equals("0000")){
		out.print("Status="+apiClient.getStatus());
		out.print("<BR/>");
		out.print("Errcode="+apiClient.getErrCode());
		out.print("<BR/>");
		out.print("ErrDesc="+apiClient.getErrDesc());
	}else{
	
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Java API直接授權</title>
		<style type="text/css">
			html, body {
			margin: 0;
			text-align: center;
			}
			#d1 {
			position: relative;
			margin: 0 auto;
			width: 760px;
			text-align: center;
			}
		</style>
	</head>
	<body >
		<div id='d1' align="center">
			<table BORDER='1' align="center">
				<TR>                                                          
			        <TD><b>授權結果狀態</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getStatus()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>授權錯誤代碼</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getErrCode()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>授權失敗原因</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getErrDesc()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>MerchantID</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getMerchantID()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>MerchantName</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getMerchantName()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>訂單編號</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getLidm()%></FONT></TD>  
				</TR>
				<TR>    
			        <TD><b>分期期數</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getPeriodNum()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>卡號前六後四</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getPan()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>卡號末四碼</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getLastPan4()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>交易授權碼</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getAuthCode()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>授權金額</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getAuthAmt()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>授權之交易序號</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getXid()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>信用卡卡別</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getCardBrand()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>交易時間</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getAuthRespTime()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>首期分期金額</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getDownPayments()%></FONT></TD>  
				</TR>
				<TR>                                                          
			        <TD><b>其他每期金額</b></TD>                                 
			        <TD><FONT COLOR=RED><%=apiClient.getInstallmentPayments()%></FONT></TD>  
				</TR>
			</table>
		</div>
	</body>
</html>
<%
	}
%>