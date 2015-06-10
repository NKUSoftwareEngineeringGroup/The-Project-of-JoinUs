/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ShowUserChatroomsDaoImpl.java
 *作者:	          金悦
 *日期:	   2015-05-25
 *文件描述: 对数据库的showuserchatrooms表进行增删改查的实现
 *修改历史:
            日期1 2015-05-25     金悦	   创建.
 */
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.dao.IShowUserChatroomsDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.vo.ShowUserChatrooms;

public class ShowUserChatroomsDaoImpl implements IShowUserChatroomsDao {

	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public ShowUserChatroomsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	/** 
	* 函数名称:   selectById 
	* 函数描述 :  根据用户id查询数据库中showuserchatrooms表中数据
	* @param：       uccid 用户id
	* @return     List<ShowUserChatrooms> 返回showuserchatrooms列表
	* @Author:       金悦
	* @Create Date: 2015-05-25 
	 */ 
	@Override
	public List<ShowUserChatrooms> selectById(String uccid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showuserchatrooms where uccid=? ";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{uccid});
		List<ShowUserChatrooms> lstShowUserChatrooms = new ArrayList<ShowUserChatrooms>();
		try {
			while(resultSet.next()){
				ShowUserChatrooms showUserChatrooms = new ShowUserChatrooms();
				showUserChatrooms.setUccid(resultSet.getString(1));
				showUserChatrooms.setUname(resultSet.getString(2));
				showUserChatrooms.setRname(resultSet.getString(3));
				lstShowUserChatrooms.add(showUserChatrooms);
			}
			return lstShowUserChatrooms;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
}
