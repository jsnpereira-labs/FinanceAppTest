package com.finance.app.data;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataUtis {
	private static String PATTERN_PASSWORD = "abcdefghijklmnopqrstuvwxvzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static String PATTERN_CURRENCY = "#.##";
	
	public static String getGenerateString(String username){
		return username.concat(generateNumberRandom(6));
	}
	
	
	private static String generateNumberRandom(int left){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i <=left; i++){
			sb.append(getRandom().nextInt(10));
		}
		return sb.toString();
	}
	
	public static String generateMoneyCurrency() {
		Double currency = ThreadLocalRandom.current().nextDouble(00.99, 1000.00);
		return getFormatCurrency(currency);
	}
	
	public static LocalDate generateDate(int days) {
		LocalDate date = LocalDate.now();
		return date.plusDays(getRandom().nextInt(days));
	}
	
	public static String getFormatCurrency(double currency) {
		DecimalFormat df = new DecimalFormat(PATTERN_CURRENCY);
		return df.format(currency);
	}
	
	public static String generatePassword() {
		StringBuffer password = new StringBuffer();
		for (int i = 0; i < 7; i++) {
			int random = getRandom().nextInt(PATTERN_PASSWORD.length());
			password.append(PATTERN_PASSWORD.substring(random, random+ 1));
		}
		return password.toString();
	}
	
	private static Random getRandom() {
		return new Random();
	}
	
	

}
