package com.api.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.api.dto.ParamsDto;
import com.google.gson.Gson;

@Service
public class ToolUtil {

	private static final Logger log = LoggerFactory.getLogger(ToolUtil.class);

	public static final String CANCEL = "/focas/payment/cancel";
	
	public static final String QUERY = "/focas/payment/query";
	
	public static final String REFUND = "/focas/payment/refund";
	
	public Object post(String path, ParamsDto params) {
		Object result = null;

		try {
			log.info("POST path: " + path);
			URL url = new URL(path);

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
			log.info("POST Response Code: " + responseCode);

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}

			Gson gson = new Gson();
			result = gson.fromJson(response.toString(), Object.class);

			connection.disconnect();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return result;
	}

}
