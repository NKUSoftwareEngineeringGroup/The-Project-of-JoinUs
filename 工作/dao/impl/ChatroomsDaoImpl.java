/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ChatroomsDaoImpl.java
 *作者:	          金悦
 *日期:	   2015-05-14
 *文件描述:   对数据库的 Chatrooms表进行增删改查
 *修改历史:
         日期1 2015-05-14     金悦	   创建.

 ************************************************/
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.newdesign.joinus.dao.IChatroomsDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.db.TransactionManager;
import edu.newdesign.joinus.po.Chatrooms;

public class ChatroomsDaoImpl implements IChatroomsDao{
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public ChatroomsDaoImpl(){
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}
	/** 
	 * 函数名称:       insert
	 * 函数描述 :       根据聊天室对象进行数据库插入
	 * @param：                    chatrooms 根据对象的属性在数据库中插入一条新纪录
	 * @return       int：数据库操作影响的行数
	 * @Author:     金悦 
	 * @Create Date: 2015-05-14
	 */ 
	@Override
	public int insert(Chatrooms chatrooms) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();				
		int rid = chatrooms.getRid();
		String rname = chatrooms.getRname();
		Date rdate = chatrooms.getRdate();
		int rtype = chatrooms.getRtype();
		String strSQL = "insert into chatrooms values(null,?,?,?)";
		Object[] params = new Object[]{rid, rname, rdate,rtype};
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if(affectedRows > 0){
			TransactionManager.commit();
		}else{
			TransactionManager.rollback();
		}
		return affectedRows;
	}
	/** 
	 * 函数名称:       selectAll
	 * 函数描述 :       返回数据库中所有聊天室记录
	 * @return       List<Chatrooms>：调用函数时数据库中所有的聊天室
	 * @Author:     金悦 
	 * @Create Date: 2015-05-14
	 */ 
	@Override
	public List<Chatrooms> selectAll() {
		// TODO Auto-generated method stub
		List<Chatrooms> lstChatrooms = new ArrayList<Chatrooms>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from chatrooms order by rid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		try {
			while(resultSet.next()){
				Chatrooms chatrooms = new Chatrooms();
				chatrooms.setRid(resultSet.getInt(1));
				chatrooms.setRname(resultSet.getString(2));
				chatrooms.setRdate(resultSet.getDate(3));
				chatrooms.setRtype(resultSet.getInt(4));
				lstChatrooms.add(chatrooms);				
			}
			return lstChatrooms;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
	/** 
	 * 函数名称:       deleteById
	 * 函数描述 :       根据聊天室编号进行数据库删除 
	 * @param：                    rid 要删除的聊天室编号
	 * @return       int：数据库操作影响的行数
	 * @Author:     金悦 
	 * @Create Date: 2015-05-14
	 */ 
	@Override
	public int deleteById(int rid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from chatrooms where rid=?";
		Object[] params = new Object[] { rid };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}
	/** 
	 * 函数名称:       selectById
	 * 函数描述 :       根据聊天室编号选择聊天室
	 * @param：                    rid 要选择的聊天室的编号
	 * @return       Chatrooms：聊天室对象
	 * @Author:     金悦 
	 * @Create Date: 2015-05-14
	 */ 
	@Override
	public Chatrooms selectById(int rid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from chatrooms where rid=?";
		Object[] params = new Object[] { rid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Chatrooms chatrooms = new Chatrooms();
				chatrooms.setRid(resultSet.getInt(1));
				chatrooms.setRname(resultSet.getString(2));
				chatrooms.setRdate(resultSet.getDate(3));	
				chatrooms.setRtype(resultSet.getInt(4));
				return chatrooms;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
	/** 
	 * 函数名称:       update
	 * 函数描述 :       根据聊天室对象进行数据库更新
	 * @param：                    chatrooms 要进行更新的对象
	 * @return       int：数据库操作影响的行数
	 * @Author:     金悦 
	 * @Create Date: 2015-05-14
	 */ 
	@Override
	public int update(Chatrooms chatrooms) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "update chatrooms set rname=?, rdate=?, rtype=? where rid=?";
		Object[] params = new Object[] { chatrooms.getRid(), chatrooms.getRname(), chatrooms.getRdate(),chatrooms.getRtype() };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	
	}

}
