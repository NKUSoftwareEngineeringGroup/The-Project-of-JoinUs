/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    CommentsDaoImpl.java
 *作者:	          金悦
 *日期:	   2015-05-14
 *文件描述:   对数据库的Comments表进行增删改查
 *修改历史:
           日期1 2015-05-14     金悦	   创建.
 ************************************************/
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.ICommentsDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.db.TransactionManager;
import edu.newdesign.joinus.po.Comments;



public class CommentsDaoImpl implements ICommentsDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public CommentsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	/** 
	 * 函数名称:       insert
	 * 函数描述 :       根据评论对象进行数据库插入
	 * @param：                    comments 根据对象的属性在数据库中插入一条新纪录
	 * @return       int：数据库操作影响的行数
	 * @Author:      金悦
	 * @Create Date: 2015-05-14
	 */ 
	@Override
	public int insert(Comments comments) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：拆分对向属性
		int cact = comments.getCact();
		String cuser = comments.getCuser_from();
		String ccontent = comments.getCcontent();
		int cuser_to = comments.getCuser_to();


		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into comments values(null,?,?,?,now(),?)";
		Object[] params = new Object[] { cact, cuser, ccontent,cuser_to };
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
	 * 函数描述 :       返回数据库中所有评论记录
	 * @return       List<Comments>：调用函数时数据库中所有的评论
	 * @Author:      金悦
	 * @Create Date: 2015-05-14
	 */ 
	@Override
	public List<Comments> selectAll() {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		List<Comments> lstComments = new ArrayList<Comments>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from comments order by cid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个comments对象
				Comments comments = new Comments();
				comments.setCid(resultSet.getInt(1));
				comments.setCact(resultSet.getInt(2));
				comments.setCuser_from(resultSet.getString(3));
				comments.setCcontent(resultSet.getString(4));
				comments.setCdate(resultSet.getDate(5));
				comments.setCuser_to(resultSet.getInt(6));


				// 步骤5-2：将封装好的对象添加到List集合中
				lstComments.add(comments);
			}
			// 返回结果
			return lstComments;
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
	 * 函数描述 :       根据评论编号进行数据库删除 
	 * @param：                    cid 要删除的评论编号
	 * @return       int：数据库操作影响的行数
	 * @Author:      金悦
	 * @Create Date: 2015-05-14
	 */ 
	@Override
	public int deleteById(int cid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "delete from comments where cid=?";
		Object[] params = new Object[] { cid };
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
	 * 函数描述 :       根据评论编号选择评论
	 * @param：                    cid 要选择的评论的编号
	 * @return       Comments：评论对象
	 * @Author:      金悦
	 * @Create Date: 2015-05-14
	 */ 
	@Override
	public Comments selectById(int cid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from comments where cid=?";
		Object[] params = new Object[] { cid };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			if (resultSet.next()) {
				// 步骤6：创建一个comments对象
				Comments comments = new Comments();
				comments.setCid(resultSet.getInt(1));
				comments.setCact(resultSet.getInt(2));
				comments.setCuser_from(resultSet.getString(3));
				comments.setCcontent(resultSet.getString(4));
				comments.setCdate(resultSet.getDate(5));
				comments.setCuser_to(resultSet.getInt(6));

				// 步骤7：返回对象
				return comments;
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
	 * 函数名称:       deleteByAid
	 * 函数描述 :       根据活动编号删除评论
	 * @param：                    aid 所要删除的评论的活动编号
	 * @return       boolean：事务成功提交返回true，否则false
	 * @Author:      金悦
	 * @Create Date: 2015-05-14
	 */ 
	@Override
	public boolean deleteByAid(int aid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
				this.conn = this.connectionManager.openConnection();
				// 步骤2：开启事务
				TransactionManager.conn = this.conn;
				TransactionManager.beginTransaction();
				// 步骤3：创建SQL语句模板
				String  strSQL = "select cid from comments where cact=?";
			    String strSQL2 = "delete from comments where cact=?";
			    Object[] params = new Object[] { aid };
		         ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		         try {
					if(resultSet.next()){
					// 步骤4：调用dbutils中的方法完成对数据库的删除操作
					int affectedRwos = this.dbUtils.execOthers(conn, strSQL2, params);
					// 步骤5：根据步骤4的操作结果提交或回滚事务
					if (affectedRwos > 0) {
						TransactionManager.commit(); // 事务提交
						return true;
					} else {
						TransactionManager.rollback(); // 事务的回滚
						return false;
					}
					}else{
						return true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
	}
	/** 
	 * 函数名称:       insertu
	 * 函数描述 :       根据讨论组对象进行数据库插入
	 * @param：                    comments 根据对象的属性在数据库中插入一条新纪录
	 * @return       int：数据库操作影响的行数
	 * @Author:      金悦
	 * @Create Date: 2015-05-14
	 */ 
	@Override
	public int insertu(Comments comments) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：拆分对向属性
		int cact = comments.getCact();
		String cuser = comments.getCuser_from();
		String ccontent = comments.getCcontent();

		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into comments values(null,?,?,?,now(),null)";
		Object[] params = new Object[] { cact, cuser, ccontent};
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


}
