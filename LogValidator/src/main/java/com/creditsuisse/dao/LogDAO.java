package com.creditsuisse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.creditsuisse.entity.Logger;

public class LogDAO {

	public static int createTable() throws SQLException{
		Connection con = null;
	      Statement stmt = null;
	      int result = 0;
	      
	      try {
	         Class.forName("org.hsqldb.jdbc.JDBCDriver");
	         con = DriverManager.getConnection( "jdbc:hsqldb:file:db/mydb;hsqldb.sqllog=3;", "admin", "admin");
	         stmt = con.createStatement();
	         
	         result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS LogTable ("
	         		+ "id VARCHAR(20) NOT NULL, "
	         		+ "state VARCHAR(50) NOT NULL,"
	         		+ "timestamp VARCHAR(20) NOT NULL,"
	         		+ "type VARCHAR(20),"
	         		+ "host VARCHAR(20),"
	         		+ "alert VARCHAR(5),"
	         		+ "PRIMARY KEY (id));"
	         		+ "");
	         con.commit();
				
	      }  catch (Exception e) {
	         e.printStackTrace(System.out);
	      }
	      finally {
			con.close();
		}
	      System.out.println("Table created successfully");
		return result;
	}
	
	public static int insertRecord(Logger log) throws SQLException {
//		int tableCount=createTable();
		Connection con = null; 
	      PreparedStatement stmt = null; 
	      int result = 0; 
	      try { 
	         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
	         con = DriverManager.getConnection( "jdbc:hsqldb:file:db/mydb", "admin", "admin"); 
	         String sql= "INSERT INTO LogTable VALUES (?,?,?,?,?,?)";
	         stmt = con.prepareStatement(sql); 
	         System.out.println(log);
	         stmt.setString(1,log.getId());
	         stmt.setString(2,log.getState());
	         stmt.setString(3,Long.toString(log.getTimestamp()));
	         stmt.setString(4,log.getType());
	         stmt.setString(5,log.getHost());
	         stmt.setString(6, log.getAlert());
	         
	         result = stmt.executeUpdate(); 
	         con.commit(); 
	      }catch (SQLException e) { 
	         e.printStackTrace(System.out); 
	      } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	    	  con.close();
	      }
	      System.out.println(result+" rows effected"); 
	      System.out.println("Rows inserted successfully");
	      return result;
	}
	
	
}
