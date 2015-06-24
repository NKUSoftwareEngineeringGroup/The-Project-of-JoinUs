/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ShowUsersActDaoImpl.java
 *作者:	   李东池
 *日期:	   15/05/2015
 *文件描述: 对数据库的showusersact表进行增删改查的实现
 *修改历史:
           日期1 15/05/2015    李东池	   创建
           日期2 15/05/2015  金悦  修改
 */
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.IShowUsersActDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.vo.ShowUsersAct;

public class ShowUsersActDaoImpl implements IShowUsersActDao {
	
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public ShowUsersActDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	/** 
	* 函数名称:   selectByUccid 
	* 函数描述 :  根据用户id查询数据库中showusersact表中数据
	* @param：       uccid 用户id
	* @return     List<ShowUsersAct> 返回用户活动列表
	* @Author:   李东池
	* @Create Date: 15/05/2015 
	 */ 
	@Override
	public List<ShowUsersAct> selectByUccid(String uccid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showusersact where uccid=? ";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{uccid});
		List<ShowUsersAct> lstShowUsersAct = new ArrayList<ShowUsersAct>();
		try {
			while(resultSet.next()){
				ShowUsersAct showUsersAct = new ShowUsersAct();
				showUsersAct.setUccid(resultSet.getString(1));
				showUsersAct.setUname(resultSet.getString(2));
				showUsersAct.setAname(resultSet.getString(3));
				showUsersAct.setPtype(resultSet.getInt(4));
				showUsersAct.setPdate(resultSet.getDate(5));
				lstShowUsersAct.add(showUsersAct);
			}
			return lstShowUsersAct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

	/** 
	* 函数名称:   selectByAid
	* 函数描述 :  根据用户id查询数据库中showusersact表中数据
	* @param：       aid 活动id
	* @return     List<ShowUsersAct> 返回用户活动列表
	* @Author:   李东池
	* @Create Date: 15/05/2015 
	 */ 
	@Override
	public List<ShowUsersAct> selectByAid(int aid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showusersact where aid=?";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{aid});
		List<ShowUsersAct> lstShowUsersAct = new ArrayList<ShowUsersAct>();
		try {
			while(resultSet.next()){
				ShowUsersAct showUsersAct = new ShowUsersAct();
				showUsersAct.setUccid(resultSet.getString(1));
				showUsersAct.setUname(resultSet.getString(2));
				showUsersAct.setAname(resultSet.getString(3));
				showUsersAct.setPtype(resultSet.getInt(4));
				showUsersAct.setPdate(resultSet.getDate(5));
				lstShowUsersAct.add(showUsersAct);
			}
			return lstShowUsersAct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

}
