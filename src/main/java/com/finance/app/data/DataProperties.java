package com.finance.app.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;
import com.google.common.io.Resources;

import net.bytebuddy.asm.Advice.This;

public class DataProperties {
	private static String[] attributes = {"username","password","category"};
	private static String RESOURCE_ADDRESS = "/src/main/resources/";
	public static Properties getProperties(String address){
		Properties props = new Properties();
		InputStream is = null;
		File f;
		try {
			f = getFile(address);
			is = new FileInputStream(f);
			if(is != null){
				props.load(is);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return props;
	}
	
	public static void saveProperties(String address, Properties props){
		Properties data = getProperties(address);
		
		for (int i = 0; i < attributes.length; i++) {
			
			if (!props.containsKey(attributes[i])) {
				props.setProperty(attributes[i], data.getProperty(attributes[i]));
			}			
	    }
		
		File f;
		try { 
			f = getFile(address);
			props.store(new FileOutputStream(f), "The properties was stored");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
	
	private static File getFile(String file) throws URISyntaxException{
		
		String baseAddress = System.getProperty("user.dir") + RESOURCE_ADDRESS;
		return new File(baseAddress+file);
	
//		ClassLoader classLoader = This.class.getClassLoader();
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println("File: "+ classLoader.getResource(address).getFile());
//		return new File(classLoader.getResource(address).getFile());
//		System.out.println("Resource address: "+Resources.getResource(address).toURI());
//		return new File(Resources.getResource(address).toURI());
	}

}
