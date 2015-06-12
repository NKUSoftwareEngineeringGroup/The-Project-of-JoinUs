/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    AttendDaoImpl.java
 *作者:	   Pu Meng
 *日期:	   27/5/2015
 *文件描述:   对数据库的Attend表进行增删改查
 *修改历史:
           日期1 27/5/2015 Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.IAttendDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.db.TransactionManager;
import edu.newdesign.joinus.po.Attend;



public class AttendDaoImpl implements IAttendDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public AttendDaoImpl(){
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}
	
	@Override
	/** 
	 * 函数名称:       insert
	 * 函数描述 :       根据加入对象进行数据库插入
	 * @param：                    attend 根据对象的属性在数据库中插入一条新纪录
	 * @return       int：数据库操作影响的行数
	 * @Author:      ghc 
	 * @Create Date: 2008-07-02 
	 */ 
	public int insert(Attend attend) {
		// TODO Auto-generated method stub
		     	this.conn = this.connectionManager.openConnection();
				TransactionManager.conn = this.conn;
				TransactionManager.beginTransaction();				
				int jid = attend.getJid();
				String juser = attend.getJuser();
				int jroom = attend.getJroom();
				String strSQL = "insert into attend values(null,?,?)";
				Object[] params = new Object[]{jid, juser, jroom};
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
	 * 函数描述 :       返回数据库中所有加入记录
	 * @return       List<Attend>：调用函数时数据库中所有的加入
	 * @Author:      ghc 
	 * @Create Date: 2008-07-02 
	 */ 
	@Override
	public List<Attend> selectAll() {
		// TODO Auto-generated method stub
		List<Attend> lstAttend = new ArrayList<Attend>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from attend order by jid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		try {
			while(resultSet.next()){
				Attend attend = new Attend();
				attend.setJid(resultSet.getInt(1));
				attend.setJuser(resultSet.getString(2));
				attend.setJroom(resultSet.getInt(3));
				lstAttend.add(attend);				
			}
			return lstAttend;
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
	 * 函数描述 :       根据加入编号进行数据库删除 
	 * @param：                    jid 要删除的加入编号
	 * @return       int：数据库操作影响的行数
	 * @Author:      ghc 
	 * @Create Date: 2008-07-02 
	 */ 
	@Override
	public int deleteById(int jid) {
		 // TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from attend where jid=?";
		Object[] params = new Object[] { jid };
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
	 * 函数描述 :       根据加入编号选择加入
	 * @param：                    jid 要选择的加入的编号
	 * @return       Attend：加入对象
	 * @Author:      ghc 
	 * @Create Date: 2008-07-02 
	 */ 
	@Override
	public Attend selectById(int jid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from attend where jid=?";
		Object[] params = new Object[] { jid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Attend attend = new Attend();
				attend.setJid(resultSet.getInt(1));
				attend.setJuser(resultSet.getString(2));
				attend.setJroom(resultSet.getInt(3));			
				return attend;
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
	 * 函数描述 :       根据加入对象进行数据库更新
	 * @param：                    attend 要进行更新的对象
	 * @return       int：数据库操作影响的行数
	 * @Author:      ghc 
	 * @Create Date: 2008-07-02 
	 */ 
	@Override
	public int update(Attend attend) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "update attend set juser=?, jroom=? where jid=?";
		Object[] params = new Object[] { attend.getJid(), attend.getJuser(), attend.getJroom() };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

}
