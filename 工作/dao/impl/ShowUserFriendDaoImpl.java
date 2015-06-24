/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ShowUserFriendDaoImpl.java
 *作者:	      李宛恒
 *日期:	    May 18, 2015
 *文件描述: 对数据库的showuserfriend表进行增删改查的实现
 *修改历史:
            日期1 18/5/2015  李宛恒  创建
            日期2 26/5/2015  李宛恒  修改
 */
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.IShowUserFriendDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.vo.ShowUserFriend;

public class ShowUserFriendDaoImpl implements IShowUserFriendDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public ShowUserFriendDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
	
		this.dbUtils = new DBUtils();
	}

	/** 
	* 函数名称:   selectByUser 
	* 函数描述 :  根据用户id查询数据库中showuserfriend表中数据
	* @param：       uccid 用户id
	* @return     List<ShowUserFriend> 返回用户朋友列表
	* @Author:       李宛恒
	* @Create Date: 18/5/2015
	 */ 
	@Override
	public List<ShowUserFriend> selectByUser(String uccid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		List<ShowUserFriend> lstFri = new  ArrayList<>();
	   String strSQL = "select * from showuserfriend where uccid=?";
	   Object[] params = { uccid};
	   ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	   try {
		while(resultSet.next()){
			     ShowUserFriend showUserFriend = new ShowUserFriend();
			     showUserFriend.setUccid(uccid);
			     showUserFriend.setFccid(resultSet.getString(2));
			     showUserFriend.setFname(resultSet.getString(3));
			     showUserFriend.setFgender(resultSet.getString(4));
			     showUserFriend.setFphoto(resultSet.getString(5));
			    lstFri.add(showUserFriend);
		   }
		  return lstFri;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally {
		this.connectionManager.closeConnection(conn);
	}
	 
	}
	
	/** 
	* 函数名称:   selectByKey 
	* 函数描述 :  根据用户id、及关键字模糊查询数据库中表showuserfriend中数据
	* @param：       uccid 用户id， keyword 关键字
	* @return     List<ShowUserFriend> 返回用户朋友列表
	* @Author:      李宛恒 
	* @Create Date: 18/5/2015
	 */ 
	@Override
	public List<ShowUserFriend> selectByKey(String uccid,String keyword) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		List<ShowUserFriend> lstFri = new  ArrayList<>();
	   String strSQL = "select * from showuserfriend where fname like ?  and uccid = ?";
	   String keyword2="%"+keyword+"%";
	   Object[] params = { keyword2 ,uccid};
	   ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	   try {
		while(resultSet.next()){
			     ShowUserFriend showUserFriend = new ShowUserFriend();
			     showUserFriend.setUccid(resultSet.getString(1));
			     showUserFriend.setFccid(resultSet.getString(2));
			     showUserFriend.setFname(resultSet.getString(3));
			     showUserFriend.setFgender(resultSet.getString(4));
			     showUserFriend.setFphoto(resultSet.getString(5));
			    lstFri.add(showUserFriend);
		   }
		  return lstFri;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally {
		this.connectionManager.closeConnection(conn);
	}
	 
	}


}
