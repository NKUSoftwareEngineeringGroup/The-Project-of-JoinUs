/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    HobbiesDaoImpl.java
 *作者:	       李宛恒 
 *日期:	    May 17, 2015
 *文件描述:  对数据库的Hobbies表进行增删改查
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

import edu.newdesign.joinus.dao.IHobbiesDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.db.TransactionManager;
import edu.newdesign.joinus.po.Hobbies;

public class HobbiesDaoImpl implements IHobbiesDao{
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public HobbiesDaoImpl(){
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}
	/** 
	 * 函数名称:       insert
	 * 函数描述 :       根据爱好对象进行数据库插入
	 * @param：                    hobbies 根据对象的属性在数据库中插入一条新纪录
	 * @return       int：数据库操作影响的行数
	 * @Author:      李宛恒 
	 * @Create Date: 17/5/2015
	 */ 
	@Override
	public int insert(Hobbies hobbies) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();				
		int htag = hobbies.getHtag();
		String huser = hobbies.getHuser();		
		String strSQL = "insert into hobbies values(null,?,?)";
		Object[] params = new Object[]{htag, huser};
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
	 * 函数描述 :       返回数据库中所有爱好记录
	 * @return       List<Hobbies>：调用函数时数据库中所有的爱好
	 * @Author:      李宛恒
	 * @Create Date: 17/5/2015 
	 */ 
	@Override
	public List<Hobbies> selectAll() {
		// TODO Auto-generated method stub
		List<Hobbies> lstHobbies = new ArrayList<Hobbies>();
		this.conn = connectionManager.openConnection();
		String strSQL = "select * from hobbies order by hid";
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		try {
			while(resultSet.next()){
				Hobbies hobbies = new Hobbies();
				hobbies.setHid(resultSet.getInt(1));
				hobbies.setHtag(resultSet.getInt(2));
				hobbies.setHuser(resultSet.getString(3));				
				lstHobbies.add(hobbies);				
			}
			return lstHobbies;
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
	 * 函数描述 :       根据爱好编号进行数据库删除 
	 * @param：                    hid 要删除的爱好编号
	 * @return       int：数据库操作影响的行数
	 * @Author:      李宛恒
	 * @Create Date: 17/5/2015
	 */ 
	@Override
	public int deleteById(int hid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from hobbies where hid=?";
		Object[] params = new Object[] { hid };
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
	 * 函数描述 :       根据爱好编号选择爱好
	 * @param：                    hid 要选择的爱好的编号
	 * @return       Hobbies：爱好对象
	 * @Author:      李宛恒 
	 * @Create Date: 17/5/2015
	 */ 
	@Override
	public Hobbies selectById(int hid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from hobbies where hid=?";
		Object[] params = new Object[] { hid };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				Hobbies hobbies = new Hobbies();
				hobbies.setHid(resultSet.getInt(1));
				hobbies.setHtag(resultSet.getInt(2));
				hobbies.setHuser(resultSet.getString(3));	
				return hobbies;
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
	 * 函数描述 :       根据爱好对象进行数据库更新
	 * @param：                    hobbies 要进行更新的对象
	 * @return       int：数据库操作影响的行数
	 * @Author:      李宛恒
	 * @Create Date: 17/5/2015 
	 */ 
	@Override
	public int update(Hobbies hobbies) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "update hobbies set htag=?, huser=? where jid=?";
		Object[] params = new Object[] { hobbies.getHid(), hobbies.getHtag(), hobbies.getHuser() };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}
	/** 
	 * 函数名称:       selectById2
	 * 函数描述 :       根据用户账号返回所有爱好
	 * @param：                    huser 用户账号
	 * @return       List<Hobbies>：用户的所有爱好
	 * @Author:      李宛恒 
	 * @Create Date: 17/5/2015 
	 */ 
	@Override
	public List<Hobbies> selectById2(String huser) {
		// TODO Auto-generated method stub
		List<Hobbies> lstHobbies = new ArrayList<Hobbies>();
		this.conn = this.connectionManager.openConnection();
		String strSQL = "select * from hobbies where huser=?";
		Object[] params = new Object[] { huser };
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
			try {
				while (resultSet.next()) {
					Hobbies hobbies = new Hobbies();
					hobbies.setHid(resultSet.getInt(1));
					hobbies.setHtag(resultSet.getInt(2));
					hobbies.setHuser(resultSet.getString(3));				
					lstHobbies.add(hobbies);
				}
				return lstHobbies;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 
		finally{
			this.connectionManager.closeConnection(conn);}

	}
	/** 
	 * 函数名称:       deleteByHuser
	 * 函数描述 :       根据用户编号删除对应爱好
	 * @param：                    uccid 所要删除爱好的用户编号
	 * @return       int：数据库操作影响的行数
	 * @Author:      李宛恒 
	 * @Create Date: 17/5/2015 
	 */ 
	@Override
	public int deleteByHuser(String uccid) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		String strSQL = "delete from hobbies where huser=?";
		Object[] params = new Object[] { uccid };
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

}
