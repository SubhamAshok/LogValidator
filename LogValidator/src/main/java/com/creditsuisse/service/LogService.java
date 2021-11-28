package com.creditsuisse.service;

import java.sql.SQLException;
import java.util.Map;

import com.creditsuisse.dao.LogDAO;
import com.creditsuisse.entity.Logger;
import com.creditsuisse.util.LogUtil;

public class LogService {

	private static Logger[] validateLogs(Logger[] inputLogs)
	{
		Map<String, Logger> tempLogs=LogUtil.loggerArrayToMap(inputLogs);
		
		for(Logger log:inputLogs) {
			Logger initialLog=tempLogs.get(log.getId());
			if(tempLogs.containsKey(log.getId()) && initialLog.getState().equalsIgnoreCase("STARTED"))
			{
				long duration=log.getTimestamp()-initialLog.getTimestamp();
				log.setTimestamp(duration);
				if(duration>4)
					log.setAlert("true");
				else
					log.setAlert("false");
				tempLogs.put(log.getId(), log);
			}
			else {
				tempLogs.put(log.getId(),log);
			}
		}
		return LogUtil.mapToLoggerArray(tempLogs);
	}
	
	public static int insertLogsToDB(Logger[] inputLogs){
		try {
			LogDAO.createTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Logger[] logArray=validateLogs(inputLogs);
		int count=0;
		for(Logger log: logArray) {
			try {
				count+=LogDAO.insertRecord(log);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
}
