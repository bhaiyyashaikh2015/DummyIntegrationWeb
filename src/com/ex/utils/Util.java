package com.ex.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class Util {
	
	public static Map<String, String> splitQuery(String queryParams) {

		Map<String, String> query_pairs = new LinkedHashMap<String, String>();

		try {
			String[] pairs = queryParams.split("&");
			for (String pair : pairs) {
				int idx = pair.indexOf("=");
				query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
						URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return query_pairs;
	}
	
	public static void printMap(Map<String, String> map) {
		for (String key : map.keySet()) {
			System.out.println(key + " = " + map.get(key));
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Inside DummyIntegrationUtil class...");
		System.out.println("==============================");
		
		String integrationName = "searchAccount";
		
		String url = "beginningClientAccountNumber=5002656925100000&endingClientAccountNumber=5002656925199999&matchType=C1&dateOfBirth=08/06/1974&zipCode=24104&srcSystem=RMEX&accessMethod=IVR";
		
		Map<String, String> paramsMap = splitQuery(url);
		
		printMap(paramsMap);
		
		System.out.println("=======================================");
		
		String accountDetails = DummyIntegrationUtil.getDetailsForMethodName(integrationName, paramsMap);
		System.out.println("accountDetails ==> "+accountDetails);
	}


}
