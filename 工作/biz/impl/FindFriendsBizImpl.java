/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    FindFriendsBizImpl.java
 *作者:	     李宛恒
 *日期:	   May 19, 2015
 *文件描述:   系统为用户寻找新的好友
 *修改历史:
           日期1 19/5/2015  李宛恒	   创建
           日期2 28/5/2015 李宛恒    修改
 ************************************************/
package edu.newdesign.joinus.biz.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.newdesign.joinus.biz.IFindFriendsBiz;
import edu.newdesign.joinus.dao.IFriendsDao;
import edu.newdesign.joinus.dao.IUsersDao;
import edu.newdesign.joinus.dao.impl.FriendsDaoImpl;
import edu.newdesign.joinus.dao.impl.UsersDaoImpl;
import edu.newdesign.joinus.po.Users;


public class FindFriendsBizImpl implements IFindFriendsBiz {
	
	IUsersDao usersDao;
	IFriendsDao friendsDao;
	
	public FindFriendsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersDao = new UsersDaoImpl();
	   this.friendsDao = new FriendsDaoImpl();
	}

	/** 
	 * 函数名称:       findFriends
	 * 函数描述 :       根据用户编号返回与用户同单位或是好友的好友列表
	 * @param：                    uccid 用户账号
	 * @return       List<Users>：找到的好友的所有账户列表
	 * @Author:      李宛恒
	 * @Create Date: 19/5/2015
	 */ 
	@Override
	public List<Users> findFriends(String uccid) {
		// TODO Auto-generated method stub
		//根据单位找好友
		List<Users> lstu = usersDao.selectByUccid(uccid);
		//个人已有的好友
		List<String> lstf =  friendsDao.selectByUccid(uccid);
		//寻找好友的好友
        for(String fuser:lstf){
        	List<String> fusers= friendsDao.selectByUccid(fuser);
        	for(String ff:fusers){
        		lstu.add(usersDao.selectById(ff));
        	}
        }
      
        Set<Users>  h = new HashSet<Users>(lstu);
        lstu.clear();
        lstu.addAll(h);

        Users br = usersDao.selectById(uccid);
        lstu.remove(br);
        //去除重复好友
        for(String lst:lstf){
           Users ff = usersDao.selectById(lst);
           lstu.remove(ff);
       }

		return lstu;
	}

}
