package com.creditsuisse.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.creditsuisse.entity.Logger;
import com.google.gson.Gson;

public class LogUtil {

	private static final String fileName="logger.txt";
	public static String[] readFile(String path) throws IOException
	{
		ArrayList<String> result=new ArrayList<String>(); 
		String line="";
		BufferedReader br = new BufferedReader(new FileReader(path+fileName));
		int lines=0;
		while((line=br.readLine())!=null) {
			result.add(line);
			lines++;
		}
		br.close();
		String resultArray[]=new String[lines];
		result.toArray(resultArray);
		return resultArray;
	}
	
	public static Logger[] stringToEntity(String logs[]) {
		Logger[] logsArray=new Logger[logs.length];
		for(int i=0;i<logs.length;i++) {
			logsArray[i]=new Gson().fromJson(logs[i], Logger.class);
		}
		return logsArray;
	}
	
	public static Map<String,Logger> loggerArrayToMap(Logger logger[]){
		Map<String,Logger> loggerMap=new LinkedHashMap<String, Logger>();
		for(Logger l:logger)
			loggerMap.put(l.getId(), l);
		return loggerMap;
		
	}
	
	public static Logger[] mapToLoggerArray(Map<String,Logger> loggerMap) {
		Logger[] loggerArray=new Logger[loggerMap.size()];
		int i=0;
		for(Map.Entry<String, Logger> entry:loggerMap.entrySet()) {
			loggerArray[i++]=entry.getValue();
		}
		return loggerArray;
	}
}
