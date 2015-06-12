/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IResourcesDao.java
 *作者:	   Pu Meng
 *日期:	   27/5/2015
 *文件描述: 对数据库的Resources表进行增删改查的实现
 *修改历史:
           日期1 27/5/2015  Pu Meng	   创建
           
 */
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.IResourcesDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.db.TransactionManager;
import edu.newdesign.joinus.po.Resources;

public class ResourcesDaoImpl implements IResourcesDao {
	
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	
	public ResourcesDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	/** 
	* 函数名称:   insert 
	* 函数描述 :  数据库中资源表中插入数据
	* @param：       resourse 资源信息
	* @return     int 数据库操作影响行数
	* @Author:       ghc 
	* @Create Date: 2008-07-02 
	 */ 
	@Override
	public int insert(Resources resourse) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		int restype = resourse.getRestype();
		String resurl = resourse.getResurl();
		String strSQL = "insert into resources values(null,?,?)";
		Object[] params = new Object[] {restype,resurl };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	/** 
	* 函数名称:   selectAll 
	* 函数描述 :  返回数据库中资源表中所有数据
	* @return     List<Resources> 资源列表
	* @Author:       ghc 
	* @Create Date: 2008-07-02 
	 */ 
	@Override
	public List<Resources> selectAll() {
		// TODO Auto-generated method stub
		List<Resources> lstResources = new ArrayList<Resources>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from resources order by resid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		try {
			while (resultSet.next()) {
				Resources resource = new Resources();
                resource.setResid(resultSet.getInt(1));
                resource.setRestype(resultSet.getInt(2));
                resource.setResurl(resultSet.getString(3));
				lstResources.add(resource);
			}
			return lstResources;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	/** 
	* 函数名称:   deleteById 
	* 函数描述 :  根据资源id删除数据库中资源表中数据
	* @param：       resourse 资源信息
	* @return     int 数据库操作影响行数
	* @Author:       ghc 
	* @Create Date: 2008-07-02 
	 */ 
	@Override
	public int deleteById(int resid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from resources where resid=?";
		Object[] params = new Object[] { resid };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	/** 
	* 函数名称:   selectById 
	* 函数描述 :  根据资源id查询数据库中资源表中数据
	* @param：       resourse 资源信息
	* @return     Resources 返回资源
	* @Author:       ghc 
	* @Create Date: 2008-07-02 
	 */ 
	@Override
	public Resources selectById(int resid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from resources where resid=?";
		Object[] params = new Object[] { resid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Resources resource = new Resources();
				resource.setResid(resultSet.getInt(1));
				resource.setRestype(resultSet.getInt(2));
				resource.setResurl(resultSet.getString(3));
				return resource;
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

}
