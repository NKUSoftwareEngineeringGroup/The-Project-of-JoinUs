/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    TransactionManager.java
 *作者:	   Pu Meng
 *日期:	   24/5/2015
 *文件描述:   管理事务的提交与回滚
 *修改历史:
           日期1 24/5/2015  Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class TransactionManager {

	public static Connection conn = null;
	private static ConnectionManager connectionManager = new ConnectionManager();
	
	public static void beginTransaction(){
		System.out.println("[TracsactionManager]：启动设置事务为人工手动模式……"+new Date());
		try {
			conn.setAutoCommit(false);
			System.out.println("[TracsactionManager]：设置事务为人工手动模式成功……"+new Date());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[TracsactionManager]：设置事务为人工手动模式失败……"+new Date());
		}
	}
	
	public static void commit(){
		try {
			System.out.println("[TracsactionManager]：启动事务提交操作……"+new Date());
			conn.commit();
			System.out.println("[TracsactionManager]：事务提交操作成功……"+new Date());
			connectionManager.closeConnection(conn);  // 关闭数据库连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[TracsactionManager]：事务提交操作失败……"+new Date());
		}
	}
	
	public static void rollback(){
		try {
			System.out.println("[TracsactionManager]：启动事务回滚操作……"+new Date());
			conn.rollback();
			System.out.println("[TracsactionManager]：事务回滚操作成功……"+new Date());
			connectionManager.closeConnection(conn);  // 关闭数据库连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[TracsactionManager]：事务回滚操作失败……"+new Date());
		}
	}
}
