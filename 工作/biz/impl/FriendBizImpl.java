/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IFriendBiz.java
 *作者:	     李宛恒
 *日期:	   May 19, 2015
 *文件描述: 列出全部或特定好友信息
 *修改历史:
           日期1 19/5/2015  李宛恒	   创建
           日期2 28/5/2015 李宛恒    修改
 ************************************************/
package edu.newdesign.joinus.biz.impl;

import java.util.List;

import edu.newdesign.joinus.biz.IFriendBiz;
import edu.newdesign.joinus.dao.IShowUserFriendDao;
import edu.newdesign.joinus.dao.impl.ShowUserFriendDaoImpl;
import edu.newdesign.joinus.vo.ShowUserFriend;

public class FriendBizImpl implements IFriendBiz {
      IShowUserFriendDao iShowUserFriendDao;
      
      public FriendBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		 iShowUserFriendDao = new ShowUserFriendDaoImpl();
	}

  	/** 
  	 * 函数名称:       showFriend
  	 * 函数描述 :       列出全部好友信息
  	 * @param：                    uccid 用户账号
  	 * @return       List<ShowUserFriend>：所有好友的关键信息列表
  	 * @Author:      李宛恒
  	 * @Create Date: 19/5/2015
  	 */ 
	@Override
	public List<ShowUserFriend> showFriend(String uccid) {
		// TODO Auto-generated method stub
		return iShowUserFriendDao.selectByUser(uccid);
	}

	/** 
	 * 函数名称:       searchFriend
	 * 函数描述 :       列出特定好友信息
	 * @param：                    uccid 用户账号 keyword 好友姓名
	 * @return       List<ShowUserFriend>：指定好友的关键信息列表
	 * @Author:      李宛恒 
	 * @Create Date: 19/5/2015
	 */ 
	@Override
	public List<ShowUserFriend> searchFriend(String uccid,String keyword) {
		// TODO Auto-generated method stub
		return iShowUserFriendDao.selectByKey(uccid,keyword);
	}

}
