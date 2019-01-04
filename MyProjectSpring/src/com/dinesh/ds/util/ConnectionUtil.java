package com.dinesh.ds.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static final String url="jdbc:mysql://192.168.225.33:3309/dineshdb";
	private static final String userName="root";
	private static final String password="supra";
	private static final String driverName="com.mysql.cj.jdbc.Driver";
	
	
	private static ConnectionUtil connectionUtil;
	private ConnectionUtil() {
		super();
	}
	
	public static ConnectionUtil getConnection() {
		if(connectionUtil==null) {
			synchronized (ConnectionUtil.class) {
				if(connectionUtil==null) {
					connectionUtil=new ConnectionUtil();
				}
				
			}
		}
		return connectionUtil;
	}
	
	public  Connection getDBConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driverName);
		Connection con=DriverManager.getConnection(url, userName, password);
		if(con==null) {
			System.out.println("Connection failed..");
			return null;
		}else {
			return con;
		}
	}
	
	
}
