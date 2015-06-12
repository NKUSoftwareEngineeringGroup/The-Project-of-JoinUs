/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ShowUserTagImpl.java
 *作者:	   Pu Meng
 *日期:	   27/5/2015
 *文件描述: 对数据库的showusertag表进行增删改查的实现
 *修改历史:
           日期1 27/5/2015 Pu Meng	   创建
           
 */
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.IShowUserTagDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.vo.ShowUserTag;

public class ShowUserTagImpl implements IShowUserTagDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public ShowUserTagImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	/** 
	* 函数名称:   selectById 
	* 函数描述 :  根据资源id查询数据库中资源表中数据
	* @param：       uccid 用户id
	* @return     List<ShowUserTag> 返回用户标签列表
	* @Author:       ghc 
	* @Create Date: 2008-07-02 
	 */ 
	@Override
	public List<ShowUserTag> selectById(String uccid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showusertag where uccid=?";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{uccid});
		List<ShowUserTag> lstShowUserTag = new ArrayList<ShowUserTag>();
		try {
			while(resultSet.next()){
				ShowUserTag showUserTag = new ShowUserTag();
				showUserTag.setUccid(resultSet.getString(1));
				showUserTag.setUname(resultSet.getString(2));
				showUserTag.setTname(resultSet.getString(3));
				lstShowUserTag.add(showUserTag);
			}
			return lstShowUserTag;
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
	* 函数描述 :  根据标签名称查询数据库中showusertag表中数据
	* @param：       tname 标签名称
	* @return     List<ShowUserTag> 返回用户标签列表
	* @Author:       ghc 
	* @Create Date: 2008-07-02 
	 */ 
	@Override
	public List<ShowUserTag> selectByTname(String tname) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showusertag where tname=? order by uccid";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{tname});
		List<ShowUserTag> lstShowUserTag = new ArrayList<ShowUserTag>();
		try {
			while(resultSet.next()){
				ShowUserTag showUserTag = new ShowUserTag();
				showUserTag.setUccid(resultSet.getString(1));
				showUserTag.setUname(resultSet.getString(2));
				showUserTag.setTname(resultSet.getString(3));
				lstShowUserTag.add(showUserTag);
			}
			return lstShowUserTag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}


}
