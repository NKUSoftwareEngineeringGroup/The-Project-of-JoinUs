/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    FriendsDaoImpl.java
 *作者:	       李宛恒
 *日期:	    May 17, 2015
 *文件描述: 对数据库的Friends表进行增删改查
 *修改历史:
            日期1 17/5/2015  李宛恒  创建
            日期2 26/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.IFriendsDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.db.TransactionManager;
import edu.newdesign.joinus.po.Friends;

public class FriendsDaoImpl implements IFriendsDao {
	
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public FriendsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	/** 
	 * 函数名称:       insert
	 * 函数描述 :       根据好友对象进行数据库插入
	 * @param：                    friends 根据对象的属性在数据库中插入一条新纪录
	 * @return       int：数据库操作影响的行数
	 * @Author:      李宛恒 
	 * @Create Date: 17/5/2015
	 */ 
	@Override
	public int insert(Friends friends) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String fuser = friends.getFuser();
		String fuserfri = friends.getFuserfri();
		String strSQL = "insert into customers values(null,?,?)";
		Object[] params = new Object[] {fuser,fuserfri };
		Object[] params2 = new Object[] {fuserfri,fuser };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		int affectedRows2 = this.dbUtils.execOthers(conn, strSQL, params2);
		if (affectedRows > 0&&affectedRows2 >0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}
	/** 
	 * 函数名称:       selectAll
	 * 函数描述 :       返回数据库中所有好友记录
	 * @return       List<Friends>：调用函数时数据库中所有的好友
	 * @Author:      李宛恒
	 * @Create Date: 17/5/2015
	 */ 
	@Override
	public List<Friends> selectAll() {
		// TODO Auto-generated method stub
		List<Friends> lstFriends = new ArrayList<Friends>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from friends order by relid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		try {
			while (resultSet.next()) {
				Friends friends = new Friends();
				friends.setRelid(resultSet.getInt(1));
				friends.setFuser(resultSet.getString(2));
				friends.setFuserfri(resultSet.getString(3));
				lstFriends.add(friends);
			}
			return lstFriends;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
	/** 
	 * 函数名称:       deleteById
	 * 函数描述 :       根据好友编号进行数据库删除 
	 * @param：                    relid 要删除的好友编号
	 * @return       int：数据库操作影响的行数
	 * @Author:      李宛恒 
	 * @Create Date: 17/5/2015 
	 */ 
	@Override
	public int deleteById(int relid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from friends where relid=?";
		Object[] params = new Object[] { relid };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}
	/** 
	 * 函数名称:       selectById
	 * 函数描述 :       根据好友编号选择好友
	 * @param：                    relid 要选择的好友的编号
	 * @return       Friends：好友对象
	 * @Author:      李宛恒 
	 * @Create Date: 17/5/2015 
	 */ 
	@Override
	public Friends selectById(int relid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from friends where relid=?";
		Object[] params = new Object[] { relid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Friends friends = new Friends();
				friends.setRelid(resultSet.getInt(1));
				friends.setFuser(resultSet.getString(2));
				friends.setFuserfri(resultSet.getString(3));
				return friends;
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
	 * 函数描述 :       根据好友对象进行数据库更新
	 * @param：                    friends 要进行更新的对象
	 * @return       int：数据库操作影响的行数
	 * @Author:      李宛恒 
	 * @Create Date: 17/5/2015 
	 */ 
	@Override
	public int update(Friends friends) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "update customers set fuser=?, fuserfri=? where relid=?";
		Object[] params = new Object[] { friends.getFuser(), friends.getFuserfri(), friends.getRelid() };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRows;
	}
	/** 
	 * 函数名称:       selectByUccid
	 * 函数描述 :       根据用户编号返回他的所有好友
	 * @param：                    fuser 要返回好友列表的用户账号
	 * @return       List<String>：好友账号列表
	 * @Author:      李宛恒 
	 * @Create Date: 17/5/2015
	 */ 
	@Override
	public List<String> selectByUccid(String fuser) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		List<String> lstFri = new ArrayList<>();
		String strSQL = "select fuserfri from friends where fuser=?";
		Object[] params = new Object[] { fuser };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			while (resultSet.next()) {
                   lstFri.add(resultSet.getString(1));
			
			} 
		       return lstFri;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
	/** 
	 * 函数名称:       insertById
	 * 函数描述 :       根据两个用户编号判断他们是否是好友关系
	 * @param：                    uccid 其中一个用户账号 uccidfri 另一个用户账号
	 * @return       int：数据库操作影响的行数
	 * @Author:      李宛恒
	 * @Create Date: 17/5/2015
	 */ 
	@Override
	public int insertById(String uccid,String uccidfri) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String fuser = uccid;
		String fuserfri = uccidfri;
		String strSQL = "insert into friends values(null,?,?)";
		Object[] params = new Object[] {fuser,fuserfri };
		//Object[] params2 = new Object[] {fuserfri,fuser };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		//int affectedRows2 = this.dbUtils.execOthers(conn, strSQL, params2);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}
	/** 
	 * 函数名称:       selectByUfid
	 * 函数描述 :       根据两个用户编号判断他们是否是好友关系
	 * @param：                   fuser 其中一个用户账号 fuserfri 另一个用户账号
	 * @return       boolean：存在记录返回true，否则false
	 * @Author:      李宛恒
	 * @Create Date: 17/5/2015 
	 */ 
	@Override
	public boolean selectByUfid(String fuser, String fuserfri) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select relid from friends where fuser=? and fuserfri =?";
		Object[] params = new Object[] { fuser,fuserfri };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
			
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
	/** 
	 * 函数名称:       update
	 * 函数描述 :       根据俩个用户编号删除他们的好友关系
	 * @param：                   fuser 其中一个用户账号 fuserfri 另一个用户账号
	 * @return       boolean：事务成功提交返回true，否则false
	 * @Author:      李宛恒
	 * @Create Date: 17/5/2015
	 */ 
	@Override
	public boolean deleteByUfid(String fuser, String fuserfri) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from friends where fuser=? and fuserfri=?";
		Object[] params = new Object[] { fuser,fuserfri };
		Object[] params2 = new Object[] { fuserfri,fuser };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		int affectedRows2 = this.dbUtils.execOthers(conn, strSQL, params2);
		if (affectedRows > 0&&affectedRows2 > 0) {
			TransactionManager.commit();
			return true;
		} else {
			TransactionManager.rollback();
			return false;
		}

	}

	
}
