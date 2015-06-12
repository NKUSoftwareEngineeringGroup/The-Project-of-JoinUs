/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  TagsDaoImpl.java
 *作者:	   蒲孟
 *日期:	   27/5/2015
 *文件描述: 对数据库的tags表进行增删改查的实现
 *修改历史:
           日期1 27/5/2015 蒲孟   创建
           
 */
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.ITagsDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.db.TransactionManager;
import edu.newdesign.joinus.po.Tags;

public class TagsDaoImpl implements ITagsDao{
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public TagsDaoImpl(){
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}

	/** 
	* 函数名称:   insert 
	* 函数描述 :  数据库中tags表中插入数据
	* @param：       tags 标签
	* @return     int 数据库操作影响行数
	* @Author:       ghc 
	* @Create Date: 2008-07-02 
	 */ 
	@Override
	public int insert(Tags tags) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();				
		int tid = tags.getTid();
		String tname = tags.getTname();
		String strSQL = "insert into tags values(null,?)";
		Object[] params = new Object[]{tid, tname};
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if(affectedRows > 0){
			TransactionManager.commit();
		}else{
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	/** 
	* 函数名称:   selectAll 
	* 函数描述 :  返回数据库中tags表中所有数据
	* @return     List<Tags> 标签列表
	* @Author:       ghc 
	* @Create Date: 2008-07-02 
	 */ 
	@Override
	public List<Tags> selectAll() {
		// TODO Auto-generated method stub
		List<Tags> lstTags = new ArrayList<Tags>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from tags order by tid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		try {
			while(resultSet.next()){
				Tags tags = new Tags();
				tags.setTid(resultSet.getInt(1));
				tags.setTname(resultSet.getString(2));			
				lstTags.add(tags);				
			}
			return lstTags;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

	/** 
	* 函数名称:   deleteById 
	* 函数描述 :  根据标签id删除数据库中tags表中数据
	* @param：       tid 标签id
	* @return     int 数据库操作影响行数
	* @Author:       ghc 
	* @Create Date: 2008-07-02 
	 */ 
	@Override
	public int deleteById(int tid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from tags where tid=?";
		Object[] params = new Object[] { tid };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

	/** 
	* 函数名称:   selectById 
	* 函数描述 :  根据标签id查询数据库中tags表中数据
	* @param：       tid 标签id
	* @return     Tags 返回标签
	* @Author:       ghc 
	* @Create Date: 2008-07-02 
	 */ 
	@Override
	public Tags selectById(int tid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from tags where tid=?";
		Object[] params = new Object[] { tid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Tags tags = new Tags();
				tags.setTid(resultSet.getInt(1));
				tags.setTname(resultSet.getString(2));	
				return tags;
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
	* 函数名称:   update
	* 函数描述 :  根据标签查询数据库中资源表中数据
	* @param：       tags 标签
	* @return     int 数据库操作影响行数
	* @Author:       ghc 
	* @Create Date: 2008-07-02 
	 */ 
	@Override
	public int update(Tags tags) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "update tags set tname=?? where tid=?";
		Object[] params = new Object[] { tags.getTid(), tags.getTname() };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

}
