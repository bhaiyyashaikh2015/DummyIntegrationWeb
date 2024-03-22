package com.ex.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.utils.Util;

@WebServlet("/demoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside demoServlet...");
		
		String methodName = request.getParameter("methodName");
		String integrationName = "Integration."+methodName;
		System.out.println("integrationName ==> " + integrationName);
		
//		String queryString = request.getQueryString();
//		System.out.println("queryString  ==> "+queryString);

		Properties prop = new Properties();
		FileInputStream input = null;

		try {
			input = new FileInputStream("C:\\Users\\Bhaiyya Shaikh\\Downloads\\DummyIntegration.properties");
			prop.load(input);
			String value = prop.getProperty(integrationName);
			System.out.println("Value ==> " + value);

			if (value != null && value != "") {
				
				PrintWriter pw=response.getWriter();
				response.setContentType("text/html");
				pw.println(value);
				
				String url = "beginningClientAccountNumber=5002656925100000&endingClientAccountNumber=5002656925199999&matchType=C1&dateOfBirth=08/06/1974&zipCode=24104&srcSystem=RMEX&accessMethod=IVR";
				
				Map<String, String> paramsMap = Util.splitQuery(url);
				
				Util.printMap(paramsMap);
//				String accountDetails = DummyIntegrationUtil.getDetailsForMethodName(integrationName, paramsMap);
//
//				System.out.println("Status from dummyIntegrationUtil() is ==> " + accountDetails);
			}
			else {
				System.out.println("Key/Value is not present for provided string ==> " + integrationName);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
