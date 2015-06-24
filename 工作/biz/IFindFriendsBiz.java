/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IFindFriendsBiz.java
 *作者:	        李宛恒
 *日期:	     May 19, 2015
 *文件描述:  系统为用户寻找新的好友
 *修改历史:
            日期1 19/5/2015  李宛恒  创建
            日期2 27/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.biz;

import java.util.List;

import edu.newdesign.joinus.po.Users;

public interface IFindFriendsBiz {
	/**
	*接口目的：                     根据用户编号返回与用户同单位或是好友的好友列表
	*@Author:      李宛恒
	*@Create Date: 19/5/2015*/
	public abstract List<Users> findFriends(final String uccid);
}
