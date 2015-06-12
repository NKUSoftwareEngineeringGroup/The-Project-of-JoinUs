/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ShowUsersNewsDaoImpl.java
 *作者:	   Pu Meng
 *日期:	   27/5/2015
 *文件描述: 对数据库的shownewsusers表进行增删改查的实现
 *修改历史:
           日期1 27/5/2015 Pu Meng	   创建
           
 */
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.IShowUsersNewsDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.vo.ShowUsersNews;

public class ShowUsersNewsDaoImpl implements IShowUsersNewsDao {
	
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public ShowUsersNewsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	/** 
	* 函数名称:   selectById 
	* 函数描述 :  根据用户id查询数据库中shownewsusers表中数据
	* @param：       uccid 用户id
	* @return     List<ShowUsersNews> 返回用户消息列表
	* @Author:       ghc 
	* @Create Date: 2008-07-02 
	 */ 
	@Override
	public List<ShowUsersNews> selectById(String uccid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from shownewsusers where uccid=? ";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{uccid});
		List<ShowUsersNews> lstShowUsersNews = new ArrayList<ShowUsersNews>();
		try {
			while(resultSet.next()){
				ShowUsersNews showUsersNews = new ShowUsersNews();
				showUsersNews.setUccid(resultSet.getString(1));
				showUsersNews.setUname(resultSet.getString(2));
				showUsersNews.setNuser(resultSet.getString(3));
				showUsersNews.setNcontent(resultSet.getString(4));
				showUsersNews.setNdate(resultSet.getDate(5));
				showUsersNews.setNtype(resultSet.getInt(6));
				lstShowUsersNews.add(showUsersNews);
			}
			return lstShowUsersNews;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

}
