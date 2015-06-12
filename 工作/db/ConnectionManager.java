/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ConnectionManager.java
 *作者:	   Pu Meng
 *日期:	  24/5/2015
 *文件描述:   用来打开和关闭数据库连接
 *修改历史:
           日期1 24/5/2015  Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class ConnectionManager {

	public Connection openConnection() {
		try {
			System.out.println("[ConnectionManager]：打开数据库连接对象……" + new Date());
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection("jdbc:mysql://" + DBConfig.IP
					+ ":" + DBConfig.PORT + "/" + DBConfig.DBNAME,
					DBConfig.ACCOUNT, DBConfig.PASSWORD);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[ConnectionManager]：打开数据库连接对象失败……" + new Date());
			return null;
		}
	}

	public void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				System.out.println("[ConnectionManager]：关闭数据库连接对象……"
						+ new Date());
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[ConnectionManager]：关闭数据库连接对象失败……"
						+ new Date());
			}
		}
	}
}
