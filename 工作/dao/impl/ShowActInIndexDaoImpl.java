/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowActInIndexDao.java
 *作者:	   李东池
 *日期:	   14/05/2015
 *文件描述: 对数据库的showactinindex表进行增删改查的实现
 *修改历史:
           日期1 14/05/2015    李东池	   创建
           日期2 15/05/2015  李宛恒        修改
 */
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.IShowActInIndexDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.vo.ShowActInIndex;


public class ShowActInIndexDaoImpl implements IShowActInIndexDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public ShowActInIndexDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		
		this.dbUtils = new DBUtils();
	}

	/** 
	* 函数名称:   selectById 
	* 函数描述 :  根据用户id查询数据库中showactinindex表中数据
	* @param：       uccid 资源信息
	* @return     List<ShowActInIndex> 返回showactinindex列表
	* @Author:   李东池
	* @Create Date: 14/05/2015 
	 */ 
	@Override
	public List<ShowActInIndex> selectById(String uccid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		List<ShowActInIndex> lstAct = new  ArrayList<>();
	   String strSQL = "select * from showactinindex where uccid=?";
	   Object[] params = { uccid};
	   ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	   try {
		while(resultSet.next()){
			     ShowActInIndex showActInIndex = new ShowActInIndex();
			     showActInIndex.setUccid(uccid);
			     showActInIndex.setUname(resultSet.getString(2));
			     showActInIndex.setUphoto(resultSet.getString(3));
			     showActInIndex.setAid(resultSet.getInt(4));
			     showActInIndex.setOwner_id(resultSet.getString(5));
			     showActInIndex.setAname(resultSet.getString(6));
			     showActInIndex.setAtopic(resultSet.getString(7));
			     showActInIndex.setPdate(resultSet.getTimestamp(8));
			     showActInIndex.setPtype(resultSet.getInt(9));
			     showActInIndex.setAcontent(resultSet.getString(10));
			     showActInIndex.setAdate(resultSet.getTimestamp(11));
			     showActInIndex.setAdeadline(resultSet.getTimestamp(12));
			    // System.out.println(resultSet.getDate(8));
			      lstAct.add(showActInIndex);
		   }
		  return lstAct;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally {
		this.connectionManager.closeConnection(conn);
	}
	 
	}

	/** 
	* 函数名称:   selectByAId 
	* 函数描述 :  根据活动id查询数据库中showactinindex表中数据
	* @param：       uccid 资源信息
	* @return     List<ShowActInIndex> 返回showactinindex列表
	* @Author:   李东池
	* @Create Date: 14/05/2015 
	 */ 
	@Override
	public List<ShowActInIndex> selectByAId(int aid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		List<ShowActInIndex> lstAct = new  ArrayList<>();
	   String strSQL = "select * from showactinindex where aid=?";
	   Object[] params = { aid};
	   ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	   try {
		while(resultSet.next()){
			     ShowActInIndex showActInIndex = new ShowActInIndex();
			     showActInIndex.setUccid(resultSet.getString(1));
			     showActInIndex.setUname(resultSet.getString(2));
			     showActInIndex.setUphoto(resultSet.getString(3));
			     showActInIndex.setAid(resultSet.getInt(4));
			     showActInIndex.setOwner_id(resultSet.getString(5));
			     showActInIndex.setAname(resultSet.getString(6));
			     showActInIndex.setAtopic(resultSet.getString(7));
			     showActInIndex.setPdate(resultSet.getTimestamp(8));
			     showActInIndex.setPtype(resultSet.getInt(9));
			     showActInIndex.setAcontent(resultSet.getString(10));
			     showActInIndex.setAdate(resultSet.getTimestamp(11));
			     showActInIndex.setAdeadline(resultSet.getTimestamp(12));
			    // System.out.println(resultSet.getDate(8));
			      lstAct.add(showActInIndex);
		   }
		  return lstAct;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally {
		this.connectionManager.closeConnection(conn);
	}
	}

}
