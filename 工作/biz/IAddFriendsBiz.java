/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IAddFriendsBiz.java
 *作者:	        李宛恒
 *日期:	     May 19, 2015
 *文件描述:   建立和解除好友关系
 *修改历史:
             日期1 19/5/2015  李宛恒  创建
             日期2 27/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.biz;

public interface IAddFriendsBiz {
	/**
	*接口目的：                     根据两个用户账号实现添加好友的功能
	*@Author:      李宛恒
	*@Create Date: 19/5/2015*/
	public abstract int addFriends(final String uccid,final String uccidfri); 
	/**
	*接口目的：                     根据两个用户账号实现删除好友的功能
	*@Author:      李宛恒 
	*@Create Date: 19/5/2015*/
	public abstract boolean deleteFriends(final String uccid,final String uccidfri);
}
