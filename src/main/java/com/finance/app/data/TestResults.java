package com.finance.app.data;

import java.util.ArrayList;
import java.util.List;

public class TestResults {
	private static List<String> results = new ArrayList<String>();
	
	public static String check(boolean isPass) {
		if (isPass) {
			return "Passed";
		} else {
			return "Failed";
		}
	}
	
	
	public static void addResult(String result) {
		results.add(result);
	}
	
	public static void clearResults() {
		results.clear();
	}
	
	public static void finalResults() {
		System.out.println("-----------------------------");
		System.out.println("RESULTS:");
		for (String string : results) {
			System.out.println(string);
		}
	}
}
