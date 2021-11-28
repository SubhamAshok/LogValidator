package com.creditsuisse.LogValidator;

import java.io.IOException;

import com.creditsuisse.entity.Logger;
import com.creditsuisse.service.LogService;
import com.creditsuisse.util.LogUtil;

public class App 
{
	private static String userDir=System.getProperty("user.dir");
    public static void main( String[] args )
    {
    	String[] logString = null;
		try {
			logString = LogUtil.readFile(userDir+"\\resources\\");
		} catch (IOException e) {
			e.printStackTrace();
		}
        Logger[] l=LogUtil.stringToEntity(logString);
        int logsInserted = LogService.insertLogsToDB(l);
        System.out.println(logsInserted+" logs inserted");
    }
}
