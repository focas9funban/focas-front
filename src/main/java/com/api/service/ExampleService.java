package com.api.service;

import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;

public class ExampleService {
	public static String decrypt(String key, String initVector, String encryptedData) {
		try {
			byte[] keyBytes = key.getBytes("UTF-8");
			byte[] ivBytes = initVector.getBytes("UTF-8");

			// 確保 key 長度是 32 字節 (256 位)
			keyBytes = MessageDigest.getInstance("SHA-256").digest(keyBytes);

			SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(ivBytes));

			// 將 Base64 編碼的數據解碼並進行解密
			byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
			byte[] decryptedBytes = cipher.doFinal(decodedBytes);

			return new String(decryptedBytes, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String encryptAES(String plainText, String key, String iv) {
		try {
			byte[] keyBytes = key.getBytes("UTF-8");
			byte[] ivBytes = iv.getBytes("UTF-8");
			keyBytes = MessageDigest.getInstance("SHA-256").digest(keyBytes);
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
			IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

			byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
			return Base64.getEncoder().encodeToString(encryptedBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		String key = "";
		String iv = "QWq2vaaB@juvTYNh";
		String inPut = "V9kkswop4x0rEDnIgHV7TjPfXy+5qwFMg8SKx/WNZEBMZT/wm3bFP/g/YaXS82BPCMyWVw7Ll0sDXfZQCOuFxtg+I7zqRFHyRPTwVHaQtJ1UYM+BUCNbGWeDDA0TmfAgVMYStsVhRG9A5Svwjc9C7M5arw2LN91o2HCDga/sbjlJ8nFD36Kbrg4nxpasqh3N1DTaDkYkVRPTvozGAKDYZjc+swOoq3W3MftthF24vYJpSVtUxWAMYJyUCgHHijZo7gwXcCJUzgegVEeIpc6mdWysQKXoasrLvVEA68RpJ54r6beTl3MZj6GIENBvtA6RN2DKdfTVZRn3XBhCTjEFSIUrGQkfKzolgeLguE2UWw2Ezih5lwcLmIaQ6yINHE5ZUC3CZgq5uth0UI4r3673Gg52LTJx3GOdl5hcUAXWMlzrsyumGzbm8z6NGDmXq9NjCHG412XetWXMM8A1BZzlXZwpFKyQjF4dfge/aY3oy4Tuhtb/ZOXP3DS4AoT23WcztsoGo3b6lVytM+54RbNhDg==";

		// 解密數據
		String decryptedData = decrypt(key, iv, inPut);

		System.out.println("Decrypted Data: " + decryptedData);

		JSONObject obj = new JSONObject();
		obj.put("RespondType", "JSON");
		obj.put("TimeStamp", 1706164644);
		obj.put("Version", "1.5");
		obj.put("LangType", "zh-tw");
		obj.put("Mid", "807426550588001");
		obj.put("Tid", "80019423");
		obj.put("Oid", "301PJM5");
		obj.put("MemberId", "ocardtest123");
		obj.put("Pan", "5433760231869806");
		obj.put("ExpireDate", "3310");
		obj.put("Cvv2", "000");
		obj.put("TransAmt", 120);
		obj.put("SecurityId", "cd933a4c414d44de970a0c936199f479");
		obj.put("FrontendUrl", "https://api-order-test.ocard.co/Newebpay/redirect?token=0YXOJ3G");
		obj.put("ApproveCode", "ST7044");
		
//		System.out.println(obj.toString());
		System.out.println(encryptAES(obj.toString(), key, iv));
	}
}
