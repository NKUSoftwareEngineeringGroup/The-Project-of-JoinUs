/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    NewsDaoImpl.java
 *作者:	          金悦
 *日期:	   2015-05-18
 *文件描述:   对数据库的News表进行增删改查
 *修改历史:
               日期1 2015-05-18     金悦	   创建.
 ************************************************/
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.INewsDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.db.TransactionManager;
import edu.newdesign.joinus.po.News;


public class NewsDaoImpl implements INewsDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public NewsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	/** 
	 * 函数名称:       insert
	 * 函数描述 :       根据消息对象进行数据库插入
	 * @param：                    news 根据对象的属性在数据库中插入一条新纪录
	 * @return       int：数据库操作影响的行数
	 * @Author:      金悦
	 * @Create Date: 2015-05-18
	 */ 
	@Override
	public int insert(News news) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：拆分对向属性
		String nuser = news.getNuser();
		String nfrom = news.getNfrom();
		int ntype = news.getNtype();
		String ncontent = news.getNcontent();
		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into news values(null,?,?,?,?,now())";
		Object[] params = new Object[] { nuser, nfrom, ntype, ncontent };
		// 步骤5：使用dbutils方法实现添加操作
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		// 步骤6：提交事务
		if (affectedRows > 0) {
			// 提交事务
			TransactionManager.commit();
		} else {
			// 回滚事务
			TransactionManager.rollback();
		}
		return affectedRows;
	}
	/** 
	 * 函数名称:       selectAll
	 * 函数描述 :       返回数据库中所有消息记录
	 * @return       List<News>：调用函数时数据库中所有的消息
	 * @Author:      金悦
	 * @Create Date: 2015-05-18
	 */ 
	@Override
	public List<News> selectAll() {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		List<News> lstNews = new ArrayList<News>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from news order by nid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个news对象
				News news = new News();
				news.setNid(resultSet.getInt(1));
				news.setNuser(resultSet.getString(2));
				news.setNfrom(resultSet.getString(3));
				news.setNtype(resultSet.getInt(4));
				news.setNcontent(resultSet.getString(5));
				news.setNdate(resultSet.getDate(6));

				// 步骤5-2：将封装好的对象添加到List集合中
				lstNews.add(news);
			}
			// 返回结果
			return lstNews;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			this.connectionManager.closeConnection(conn);
		}

	}
	/** 
	 * 函数名称:       deleteById
	 * 函数描述 :       根据消息编号进行数据库删除 
	 * @param：                    nid 要删除的消息编号
	 * @return       int：数据库操作影响的行数
	 * @Author:      金悦
	 * @Create Date: 2015-05-18
	 */ 
	@Override
	public int deleteById(int nid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "delete from news where nid=?";
		Object[] params = new Object[] { nid };
		// 步骤4：调用dbutils中的方法完成对数据库的删除操作
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		// 步骤5：根据步骤4的操作结果提交或回滚事务
		if (affectedRwos > 0) {
			TransactionManager.commit(); // 事务提交
		} else {
			TransactionManager.rollback(); // 事务的回滚
		}
		// 步骤6：返回影响行数
		return affectedRwos;
	}
	/** 
	 * 函数名称:       selectById
	 * 函数描述 :       根据消息编号选择消息
	 * @param：                    nid 要选择的消息的编号
	 * @return       News：消息对象
	 * @Author:      金悦
	 * @Create Date: 2015-05-18
	 */ 
	@Override
	public News selectById(int nid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from news where nid=?";
		Object[] params = new Object[] { nid };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			if (resultSet.next()) {
				// 步骤6：创建一个news对象
				News news = new News();
				news.setNid(resultSet.getInt(1));
				news.setNuser(resultSet.getString(2));
				news.setNfrom(resultSet.getString(3));
				news.setNtype(resultSet.getInt(4));
				news.setNcontent(resultSet.getString(5));
				news.setNdate(resultSet.getDate(6));
				// 步骤7：返回对象
				return news;
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
	 * 函数名称:       selectByUccid
	 * 函数描述 :       根据用户账号返回消息列表
	 * @param：                    uccid 需要返回消息的用户账号
	 * @return       List<News>：消息列表
	 * @Author:      金悦
	 * @Create Date: 2015-05-18
	 */ 
	@Override
	public List<News> selectByUccid(String uccid) {
		// TODO Auto-generated method stub
		List<News> lstNews = new ArrayList<News>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from news where nuser = ? order by ndate";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,uccid);
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个news对象
				News news = new News();
				news.setNid(resultSet.getInt(1));
				news.setNuser(resultSet.getString(2));
				news.setNfrom(resultSet.getString(3));
				news.setNtype(resultSet.getInt(4));
				news.setNcontent(resultSet.getString(5));
				news.setNdate(resultSet.getDate(6));

				// 步骤5-2：将封装好的对象添加到List集合中
				lstNews.add(news);
			}
			// 返回结果
			return lstNews;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			this.connectionManager.closeConnection(conn);
		}

	}
	/** 
	 * 函数名称:       deleteByUccid
	 * 函数描述 :       根据用户账号删除消息
	 * @param：                    uccid 用户账号
	 * @return       int：数据库操作影响的行数
	 * @Author:      金悦
	 * @Create Date: 2015-05-18
	 */ 
	@Override
	public int deleteByUccid(String uccid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "delete from news where nfrom=? and ntype=4";
		Object[] params = new Object[] { uccid };
		// 步骤4：调用dbutils中的方法完成对数据库的删除操作
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		// 步骤5：根据步骤4的操作结果提交或回滚事务
		if (affectedRwos > 0) {
			TransactionManager.commit(); // 事务提交
		} else {
			TransactionManager.rollback(); // 事务的回滚
		}
		// 步骤6：返回影响行数
		return affectedRwos;
}
	}

