/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:   UsersDaoImpl.java
 *作者:	         金悦
 *日期:	   2015-05-15
 *文件描述: 对数据库的users表进行增删改查
 *修改历史:
               日期1 2015-05-15     金悦	   创建.
                日期2 2015-05-17     金悦	   修改.
 */
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.newdesign.joinus.dao.IUsersDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.db.TransactionManager;
import edu.newdesign.joinus.po.Users;

public class UsersDaoImpl implements IUsersDao {
	
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public UsersDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	/** 
	* 函数名称:   insert 
	* 函数描述 :  数据库中users表中插入数据
	* @param：       users 用户信息
	* @return     int 数据库操作影响行数
	* @Author:      金悦 
	* @Create Date: 2015-05-15 
	 */ 
	@Override
	public int insert(Users users) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();

		String uccid = users.getUccid();
		String uname = users.getUname();
		String upwd = users.getUpwd();
		String ugender = users.getUgender();
		String uorg = users.getUorg();
		String uphoto = users.getUphoto();
		Date ubirth = users.getUbirth();
		String utele = users.getUtele();
		String uqq = users.getUqq();
		String ucity = users.getUcity();
		String uadd = users.getUadd();
		int ustate = users.getUstate();
		String strSQL = "insert into users values(?,?,?,?,?,?,?,?,?,?,?,?,now())";
		Object[] params = new Object[] {uccid,uname,upwd,ugender,uorg,uphoto,ubirth,utele,uqq,ucity,uadd,ustate };
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
	* 函数描述 :  返回数据库中users表中所有数据
	* @return     List<Users> 返回用户列表
	* @Author:      金悦 
	* @Create Date: 2015-05-15 
	 */ 
	@Override
	public List<Users> selectAll() {
		// TODO Auto-generated method stub
		List<Users> lstUsers = new ArrayList<Users>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from users order by uccid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {});
		try {
			while (resultSet.next()) {
				Users users = new Users();
				users.setUccid(resultSet.getString(1));
				users.setUname(resultSet.getString(2));
				users.setUpwd(resultSet.getString(3));
				users.setUgender(resultSet.getString(4));
				users.setUorg(resultSet.getString(5));
				users.setUphoto(resultSet.getString(6));
				users.setUbirth(resultSet.getDate(7));
				users.setUtele(resultSet.getString(8));
				users.setUqq(resultSet.getString(9));
				users.setUcity(resultSet.getString(10));
				users.setUadd(resultSet.getString(11));
				users.setUstate(resultSet.getInt(12));
				users.setUdate(resultSet.getDate(13));
				lstUsers.add(users);
			}
			return lstUsers;
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
	* 函数描述 :  根据用户id删除数据库中users表中数据
	* @param：       uccid 用户id
	* @return     int 数据库操作影响行数
	* @Author:      金悦 
	* @Create Date: 2015-05-15 
	 */ 
	@Override
	public int deleteById(int uccid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from users where uccid=?";
		Object[] params = new Object[] { uccid };
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
	* 函数描述 :  根据用户id查询数据库中users表中数据
	* @param：       uccid 用户id
	* @return     Users 返回用户信息
	* @Author:      金悦 
	* @Create Date: 2015-05-15 
	 */ 
	@Override
	public Users selectById(String uccid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from users where uccid=?";
		Object[] params = new Object[] { uccid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Users users = new Users();
				users.setUccid(resultSet.getString(1));
				users.setUname(resultSet.getString(2));
				users.setUpwd(resultSet.getString(3));
				users.setUgender(resultSet.getString(4));
				users.setUorg(resultSet.getString(5));
				users.setUphoto(resultSet.getString(6));
				users.setUbirth(resultSet.getDate(7));
				users.setUtele(resultSet.getString(8));
				users.setUqq(resultSet.getString(9));
				users.setUcity(resultSet.getString(10));
				users.setUadd(resultSet.getString(11));
				users.setUstate(resultSet.getInt(12));
				users.setUdate(resultSet.getDate(13));
				// 步骤7：返回对象
				return users;
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
	* 函数描述 :  根据用户id更新数据库中users表中数据
	* @param：       users 用户信息
	* @Author:      金悦 
	* @Create Date: 2015-05-15 
	 */ 
	@Override
	public int update(Users users) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "update users set uname=?,upwd=?,ugender=?,uorg=?,uphoto=?,ubirth=?,utele=?,uqq=?,ucity=?,uadd=? where uccid=?";
		Object[] params = new Object[] { users.getUname(), users.getUpwd(), users.getUgender(), users.getUorg(),users.getUphoto(),users.getUbirth(),users.getUtele(),users.getUqq(),users.getUcity(),users.getUadd(),users.getUccid() };
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	/** 
	* 函数名称:   selectByObject 
	* 函数描述 :  根据用户id、用户密码查询数据库中users表中数据
	* @param：       uccid 用户id，upwd用户密码
	* @return     Users 返回用户信息
	* @Author:      金悦 
	* @Create Date: 2015-05-15 
	 */ 
	@Override
	public Users selectByObject(String uccid, String upwd) {
		// TODO Auto-generated method stub
        Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from users where uccid=? and upwd=?";
		Object[] params = new Object[]{uccid, upwd};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if(resultSet.next()){
				Users user = new Users();
				user.setUccid(resultSet.getString(1));
				user.setUname(resultSet.getString(2));
				user.setUpwd(resultSet.getString(3));
				user.setUgender(resultSet.getString(4));
				user.setUorg(resultSet.getString(5));
				user.setUphoto(resultSet.getString(6));
				user.setUbirth(resultSet.getDate(7));
				user.setUtele(resultSet.getString(8));
				user.setUqq(resultSet.getString(9));
				user.setUcity(resultSet.getString(10));
				user.setUadd(resultSet.getString(11));
				user.setUstate(resultSet.getInt(12));
				user.setUdate(resultSet.getDate(13));
				
				
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}	
		return null;
	}
	

	/** 
	* 函数名称:   selectByUccid 
	* 函数描述 :  根据用户id查询数据库，返回用户列表
	* @param：       uccid 用户id
	* @return     List<Users> 返回用户列表
	* @Author:      金悦 
	* @Create Date: 2015-05-17 
	 */ 
	@Override
	public List<Users> selectByUccid(String uccid) {
		// TODO Auto-generated method stub
		List<Users> lstUsers = new ArrayList<Users>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from users as a where a.uorg in (select uorg from users where uccid=?) and a.uccid!=?";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {uccid,uccid});
		try {
			while (resultSet.next()) {
				Users users = new Users();
				users.setUccid(resultSet.getString(1));
				users.setUname(resultSet.getString(2));
				users.setUpwd(resultSet.getString(3));
				users.setUgender(resultSet.getString(4));
				users.setUorg(resultSet.getString(5));
				users.setUphoto(resultSet.getString(6));
				users.setUbirth(resultSet.getDate(7));
				users.setUtele(resultSet.getString(8));
				users.setUqq(resultSet.getString(9));
				users.setUcity(resultSet.getString(10));
				users.setUadd(resultSet.getString(11));
				users.setUstate(resultSet.getInt(12));
				users.setUdate(resultSet.getDate(13));
				lstUsers.add(users);
			}
			return lstUsers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	/** 
	* 函数名称:   selectByKey 
	* 函数描述 :  根据用户名称模糊查询数据库，返回用户列表
	* @param：       uname 用户名称
	* @return     List<Users> 返回用户列表
	* @Author:    金悦 
	* @Create Date: 2015-05-17 
	 */ 
	@Override
	public List<Users> selectByKey(String uname) {
		// TODO Auto-generated method stub
		List<Users> lstUsers = new ArrayList<Users>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from users  where uname like ?";
		String keyword = "%"+uname+"%";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,new Object[] {keyword});
		try {
			while (resultSet.next()) {
				Users users = new Users();
				users.setUccid(resultSet.getString(1));
				users.setUname(resultSet.getString(2));
				users.setUpwd(resultSet.getString(3));
				users.setUgender(resultSet.getString(4));
				users.setUorg(resultSet.getString(5));
				users.setUphoto(resultSet.getString(6));
				users.setUbirth(resultSet.getDate(7));
				users.setUtele(resultSet.getString(8));
				users.setUqq(resultSet.getString(9));
				users.setUcity(resultSet.getString(10));
				users.setUadd(resultSet.getString(11));
				users.setUstate(resultSet.getInt(12));
				users.setUdate(resultSet.getDate(13));
				lstUsers.add(users);
			}
			return lstUsers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
	}


