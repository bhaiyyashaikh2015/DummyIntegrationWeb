package com.ex.utils;

import java.util.Map;

public class DummyIntegrationUtil {
	
	public static String getDetailsForMethodName(String integrationName, Map<String, String> map) {
		
		return "{\"accountFound\":true,\"numberOfAccounts\":1,\"matches\":[{\"caseNumber\":\"23281083\",\"companyNumber\":\"01\"}],\"additionalInfo\":[{\"firstName\":\"\",\"lastName\":\"\",\"guardianDOB\":\"\",\"guardianSSN\":\"\",\"fill\":\"\"}]}\r\n"
				+ "";
	}
	
}
