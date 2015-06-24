/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    AddFriendsBizImpl.java
 *作者:	     李宛恒
 *日期:	   May 19, 2015
 *文件描述:   对活动的评论进行操作
 *修改历史:
           日期1 19/5/2015  李宛恒	   创建
           日期2 28/5/2015 李宛恒    修改
 ************************************************/
package edu.newdesign.joinus.biz.impl;

import edu.newdesign.joinus.biz.IAddFriendsBiz;
import edu.newdesign.joinus.dao.IFriendsDao;
import edu.newdesign.joinus.dao.impl.FriendsDaoImpl;

public class AddFriendsBizImpl implements IAddFriendsBiz {
	
	private IFriendsDao friendsDao;
	
	public AddFriendsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.friendsDao = new FriendsDaoImpl();
	}

	/** 
	 * 函数名称:       addFriends
	 * 函数描述 :       根据两个用户账号实现添加好友的功能
	 * @param：                    uccid 其中一个用户账号 uccidfri另一个用户账号
	 * @return       int：添加成功返回1，否则返回0
	 * @Author:      李宛恒
	 * @Create Date: 19/5/2015
	 */ 
	@Override
	public int addFriends(String uccid,String uccidfri) {
		// TODO Auto-generated method stub
		if(!friendsDao.selectByUfid(uccid, uccidfri)){
			if(friendsDao.insertById(uccid,uccidfri)>0)
				return 1;
			return 0;
		}
       return -1;
	}

	/** 
	 * 函数名称:       deleteFriends
	 * 函数描述 :       根据两个用户账号实现删除好友的功能
	 * @param：                     uccid 其中一个用户账号 uccidfri另一个用户账号
	 * @return       boolean：删除成功返回true，否则返回false
	 * @Author:      李宛恒
	 * @Create Date: 19/5/2015
	 */ 
	@Override
	public boolean deleteFriends(String uccid, String uccidfri) {
		// TODO Auto-generated method stub
		return friendsDao.deleteByUfid(uccid, uccidfri);
	}

}
