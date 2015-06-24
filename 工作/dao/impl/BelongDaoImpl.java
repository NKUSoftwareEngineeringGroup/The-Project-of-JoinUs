/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:   BelongDaoImpl.java
 *作者:	      李宛恒
 *日期:	    May 16, 2015
 *文件描述: 对数据库的 Belong表进行增删改查
 *修改历史:
            日期1 16/5/2015  李宛恒  创建
            日期2 26/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.IBelongDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.db.TransactionManager;
import edu.newdesign.joinus.po.Belong;

public class BelongDaoImpl implements IBelongDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public BelongDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	/** 
	 * 函数名称:       insert
	 * 函数描述 :       根据属于对象进行数据库插入
	 * @param：                    belong 根据对象的属性在数据库中插入一条新纪录
	 * @return       int：数据库操作影响的行数
	 * @Author:      李宛恒
	 * @Create Date: 16/5/2015
	 */ 
	@Override
	public int insert(Belong belong) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启一个事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：拆分对向属性
		int bact = belong.getBact();
		int btag = belong.getBtag();
		// 步骤4：设置添加SQL语句模板
		String strSQL = "insert into belong values(null,?,?)";
		Object[] params = new Object[] { bact, btag };
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
	 * 函数描述 :       返回数据库中所有属于记录
	 * @return       List<Belong>：调用函数时数据库中所有的属于
	 * @Author:      李宛恒 
	 * @Create Date: 16/5/2015
	 */ 
	@Override
	public List<Belong> selectAll() {
		// TODO Auto-generated method stub
		// 步骤1：创建一个空的集合准备存放查询的结果
		List<Belong> lstBelong = new ArrayList<Belong>();
		// 步骤2：获取一个数据库的连接对象
		this.conn = connectionManager.openConnection();
		// 步骤3：创建查询语句的模板
		String strSQL = "select * from belong order by bid";
		// 步骤4：使用dbutils方法实现查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 步骤5：将resultSet结果集转换成List数据结构
		try {
			while (resultSet.next()) {
				// 步骤5-1：创建一个belong对象
				Belong belong = new Belong();
				belong.setBid(resultSet.getInt(1));
				belong.setBact(resultSet.getInt(2));
				belong.setBtag(resultSet.getInt(3));

				// 步骤5-2：将封装好的对象添加到List集合中
				lstBelong.add(belong);
			}
			// 返回结果
			return lstBelong;
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
	 * 函数描述 :       根据属于编号进行数据库删除 
	 * @param：                    bid 要删除的属于编号
	 * @return       int：数据库操作影响的行数
	 * @Author:      李宛恒
	 * @Create Date: 16/5/2015
	 */ 
	@Override
	public int deleteById(int bid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "delete from belong where bid=?";
		Object[] params = new Object[] { bid };
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
	 * 函数描述 :       根据属于编号选择属于
	 * @param：                    bid 要选择的属于的编号
	 * @return       Belong：属于对象
	 * @Author:      李宛恒
	 * @Create Date: 16/5/2015 
	 */ 
	@Override
	public Belong selectById(int bid) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：创建SQL语句模板
		String strSQL = "select * from belong where bid=?";
		Object[] params = new Object[] { bid };
		// 步骤4：调用dbutils中的方法完成对数据库的查询操作
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 步骤5：获取结果集合并封装成一个对象
		try {
			if (resultSet.next()) {
				// 步骤6：创建一个belong对象
				Belong belong = new Belong();
				belong.setBid(resultSet.getInt(1));
				belong.setBact(resultSet.getInt(2));
				belong.setBtag(resultSet.getInt(3));
			
				// 步骤7：返回对象
				return belong;
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
	 * 函数描述 :       根据属于对象进行数据库更新
	 * @param：                    belong 要进行更新的对象
	 * @return       int：数据库操作影响的行数
	 * @Author:      李宛恒
	 * @Create Date: 16/5/2015
	 */ 
	@Override
	public int update(Belong belong) {
		// TODO Auto-generated method stub
		// 步骤1：获取一个数据库连接对象
		this.conn = this.connectionManager.openConnection();
		// 步骤2：开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 步骤3：创建SQL语句模板
		String strSQL = "update belong set bact=?,btag=? where bid=?";
		Object[] params = new Object[] { belong.getBact(),belong.getBtag(),belong.getBid() };
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
	 * 函数名称:       deleteByAid
	 * 函数描述 :       根据活动编号进行删除属于关系
	 * @param：                    aid 所要删除属于关系的活动编号
	 * @return       boolean：事务成功提交返回true，否则false
	 * @Author:      李宛恒
	 * @Create Date: 16/5/2015 
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
		String strSQL = "select bid from belong where bact=?";
		String strSQL2 = "delete from belong where bact=?";
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

}
