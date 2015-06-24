/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  SearchNewFriendBizImpl.java
 *作者:	    李宛恒
 *日期:	   May 19, 2015
 *文件描述: 查询新好友业务逻辑实现
 *修改历史:
           日期1 19/5/2015  李宛恒	   创建
           日期2 28/5/2015 李宛恒    修改
 */

package edu.newdesign.joinus.biz.impl;

import java.util.ArrayList;
import java.util.List;

import edu.newdesign.joinus.biz.ISearchNewFriendBiz;
import edu.newdesign.joinus.dao.IFriendsDao;
import edu.newdesign.joinus.dao.IUsersDao;
import edu.newdesign.joinus.dao.impl.FriendsDaoImpl;
import edu.newdesign.joinus.dao.impl.UsersDaoImpl;
import edu.newdesign.joinus.po.Users;

public class SearchNewFriendBizImpl implements ISearchNewFriendBiz {
    IUsersDao usersDao;
    IFriendsDao friendsDao;
    
	public SearchNewFriendBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersDao = new UsersDaoImpl();
		this.friendsDao = new FriendsDaoImpl();
	}

	/** 
	* 函数名称:   addNew 
	* 函数描述 :  根据用户名模糊查询，显示非好友的其他用户
	* @param：      uccid 用户id，keyword 模糊查询信息
	* @return    List<Users> 返回用户列表
	* @Author:      李宛恒
	* @Create Date: 19/5/2015
	 */ 
	@Override
	public List<Users> addNew(String uccid,String keyword) {
		// TODO Auto-generated method stub
		List<Users> lstUser = usersDao.selectByKey(keyword);
		List<String> lstFri = friendsDao.selectByUccid(uccid);
		List<Users> lstRem = new ArrayList<>();
		for(String fccid:lstFri){
			lstRem.add( usersDao.selectById(fccid));
		}
		lstUser.removeAll(lstRem);
		return lstUser;
 	}

}
