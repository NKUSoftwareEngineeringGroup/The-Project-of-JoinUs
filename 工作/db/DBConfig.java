/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    Attend.java
 *作者:	  Pu Meng
 *日期:	   24/5/2015
 *文件描述:   从db.cfg.properties文件读出对数据库的设置
 *修改历史:
           日期1 24/5/2015 Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.db;

import java.io.IOException;
import java.util.Properties;

public class DBConfig {

	private static final Properties props = new Properties();
	static{
		try {
			props.load(DBConfig.class.getResourceAsStream("db.cfg.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static final String IP = props.getProperty("IP");
	public static final String PORT = props.getProperty("PORT");
	public static final String DBNAME = props.getProperty("DBNAME");
	public static final String ACCOUNT = props.getProperty("ACCOUNT");
	public static final String PASSWORD = props.getProperty("PASSWORD");
}
