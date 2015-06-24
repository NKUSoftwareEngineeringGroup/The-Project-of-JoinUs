/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ShowUserCommActDaoImpl.java
 *作者:	     李宛恒
 *日期:	    May 18, 2015
 *文件描述: 对数据库的showuserscommact表进行增删改查
 *修改历史:
            日期1 18/5/2015  李宛恒  创建
            日期2 26/5/2015  李宛恒  修改
 */
package edu.newdesign.joinus.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

















import edu.newdesign.joinus.dao.IShowUserCommActDao;
import edu.newdesign.joinus.db.ConnectionManager;
import edu.newdesign.joinus.db.DBUtils;
import edu.newdesign.joinus.vo.ShowUserCommAct;

public class ShowUserCommActDaoImpl implements IShowUserCommActDao {

	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
		
	public ShowUserCommActDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	/** 
	* 函数名称:   selectByAname 
	* 函数描述 :  根据标签名称查询数据库中showuserscommact表中数据
	* @param：       tname 标签名称
	* @return     List<ShowUserCommAct> 返回用户对活动评论的列表
	* @Author:      李宛恒
	* @Create Date: 18/5/2015
	 */ 
	@Override
	public List<ShowUserCommAct> selectByAname(String tname) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showuserscommact where aname=? ";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{tname});
		List<ShowUserCommAct> lstShowUserCommAct = new ArrayList<ShowUserCommAct>();
		try {
			while(resultSet.next()){
				ShowUserCommAct showUserCommAct = new ShowUserCommAct();
				showUserCommAct.setUname(resultSet.getString(1));
				showUserCommAct.setPhoto(resultSet.getString(2));
				showUserCommAct.setCid(resultSet.getInt(3));
				showUserCommAct.setCuser_from(resultSet.getString(4));
				showUserCommAct.setCuser_to(resultSet.getInt(5));
				showUserCommAct.setCcontent(resultSet.getString(6));
				showUserCommAct.setCdate(resultSet.getTimestamp(7));
				showUserCommAct.setAid(resultSet.getInt(8));
				lstShowUserCommAct.add(showUserCommAct);
			}
			return lstShowUserCommAct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

	/** 
	* 函数名称:   selectByAid 
	* 函数描述 :  根据活动id查询数据库中showuserscommact表中数据
	* @param：       aid 活动id
	* @return     List<ShowUserCommAct> 返回用户对活动评论的列表
	* @Author:      李宛恒
	* @Create Date: 18/5/2015
	 */ 
	@Override
	public List<ShowUserCommAct> selectByAid(int aid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from showusercommact where aid=? ";
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{aid});
		List<ShowUserCommAct> lstShowUserCommAct = new ArrayList<ShowUserCommAct>();
		try {
			while(resultSet.next()){
				ShowUserCommAct showUserCommAct = new ShowUserCommAct();
				showUserCommAct.setUname(resultSet.getString(1));
				showUserCommAct.setPhoto(resultSet.getString(2));
				showUserCommAct.setCid(resultSet.getInt(3));
				showUserCommAct.setCuser_from(resultSet.getString(4));
				showUserCommAct.setCuser_to(resultSet.getInt(5));
				showUserCommAct.setCcontent(resultSet.getString(6));
				showUserCommAct.setCdate(resultSet.getTimestamp(7));
				showUserCommAct.setAid(resultSet.getInt(8));
				lstShowUserCommAct.add(showUserCommAct);
			}
			return lstShowUserCommAct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}
}