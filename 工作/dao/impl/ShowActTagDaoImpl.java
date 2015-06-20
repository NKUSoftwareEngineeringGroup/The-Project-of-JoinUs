/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ShowActTagDaoImpl.java
 *作者:	   李东池
 *日期:	   15/05/2015
 *文件描述: 对数据库的showacttag表进行增删改查的实现
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

import edu.newdesign.joinus.dao.IShowActTagDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.vo.ShowActTag;

public class ShowActTagDaoImpl implements IShowActTagDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public ShowActTagDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	
	/** 
	* 函数名称:   selectById 
	* 函数描述 :  根据活动id查询数据库中ShowActTag表中数据
	* @param：       aid 活动id
	* @return     List<ShowActTag> 返回showacttag列表
	* @Author:   李东池
	* @Create Date: 15/05/2015 
	 */ 
	@Override
	public List<ShowActTag> selectById(int aid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showacttag where aid=?";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{aid});
		List<ShowActTag> lstShowActTag = new ArrayList<ShowActTag>();
		try {
			while(resultSet.next()){
				ShowActTag showActTag = new ShowActTag();
				showActTag.setOwner_id(resultSet.getString(1));
				showActTag.setUname(resultSet.getString(2));
				showActTag.setUphoto(resultSet.getString(3));
				showActTag.setAid(resultSet.getInt(4));
				showActTag.setAname(resultSet.getString(5));
				showActTag.setAdate(resultSet.getDate(6));
				showActTag.setAaddress(resultSet.getString(7));
				showActTag.setTid(resultSet.getInt(8));
				showActTag.setTname(resultSet.getString(9));
				showActTag.setAcontent(resultSet.getString(10));
				showActTag.setAtopic(resultSet.getString(11));
				lstShowActTag.add(showActTag);
			}
			return lstShowActTag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
	
	/** 
	* 函数名称:   selectByTname 
	* 函数描述 :  根据标签名称查询数据库中ShowActTag表中数据
	* @param：       tname 标签名称
	* @return     List<ShowActTag> 返回showacttag列表
	* @Author:   李东池
	* @Create Date: 15/05/2015 
	 */ 
	@Override
	public List<ShowActTag> selectByTname(int tname) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showacttag where tname=? order by aid";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{tname});
		List<ShowActTag> lstShowActTag = new ArrayList<ShowActTag>();
		try {
			while(resultSet.next()){
				ShowActTag showActTag = new ShowActTag();
				showActTag.setAid(resultSet.getInt(1));
				showActTag.setAname(resultSet.getString(2));
				showActTag.setTname(resultSet.getString(9));
				lstShowActTag.add(showActTag);
			}
			return lstShowActTag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
	
	/** 
	* 函数名称:   selectAll 
	* 函数描述 :  查询数据库中ShowActTag表中所有数据
	* @return     List<ShowActTag> 返回showacttag列表
	* @Author:   李东池
	* @Create Date: 15/05/2015 
	 */ 
	@Override
	public List<ShowActTag> selectAll() {
		// TODO Auto-generated method stub
		String strSQL = "select * from showacttag  order by aid";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		List<ShowActTag> lstShowActTag = new ArrayList<ShowActTag>();
		try {
			while(resultSet.next()){
				ShowActTag showActTag = new ShowActTag();
				showActTag.setAid(resultSet.getInt(1));
				showActTag.setAname(resultSet.getString(2));
				showActTag.setTname(resultSet.getString(9));
				lstShowActTag.add(showActTag);
			}
			return lstShowActTag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
	
	/** 
	* 函数名称:   selectAll 
	* 函数描述 :  根据资标签id查询数据库中ShowActTag表中数据
	* @param：       tid 标签id
	* @return     List<ShowActTag> 返回showacttag列表
	* @Author:   李东池
	* @Create Date: 15/05/2015 
	 */ 
	@Override
	public List<ShowActTag> selectByTag(int tid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showacttag where tid=? order by aid";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{tid});
		List<ShowActTag> lstShowActTag = new ArrayList<ShowActTag>();
		try {
			while(resultSet.next()){
				ShowActTag showActTag = new ShowActTag();
				showActTag.setOwner_id(resultSet.getString(1));
				showActTag.setUname(resultSet.getString(2));
				showActTag.setUphoto(resultSet.getString(3));
				showActTag.setAid(resultSet.getInt(4));
				showActTag.setAname(resultSet.getString(5));
				showActTag.setAdate(resultSet.getDate(6));
				showActTag.setAaddress(resultSet.getString(7));
				showActTag.setTid(resultSet.getInt(8));
				showActTag.setTname(resultSet.getString(9));
				showActTag.setAcontent(resultSet.getString(10));
				showActTag.setAtopic(resultSet.getString(11));
				lstShowActTag.add(showActTag);
			}
			return lstShowActTag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
	
	

}
