/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IFriendsDao.java
 *作者:	        李宛恒
 *日期:	     May 14, 2015
 *文件描述:  对数据库的Friends表进行增删改查
 *修改历史:
           日期1 14/5/2015  李宛恒  创建
           日期2 26/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.po.Friends;

public interface IFriendsDao {
	/**
	*接口目的：                     根据好友对象进行数据库插入
	*@Author:      李宛恒
	*@Create Date: 14/5/2015*/
	public abstract int insert(final Friends friends);
	/**
	*接口目的：                     根据用户编号和好友编号进行数据库插入
	*@Author:      李宛恒 
	*@Create Date: 14/5/2015*/
	public abstract int insertById(final String uccid,final String uccidfri);
	/**
	*接口目的：                     返回数据库中所有好友记录
	*@Author:      李宛恒 
	*@Create Date: 14/5/2015*/
	public abstract List<Friends> selectAll();
	/**
	*接口目的：                     根据好友编号删除记录
	*@Author:      李宛恒
	*@Create Date: 14/5/2015*/
	public abstract int deleteById(final int relid);
	/**
	*接口目的：                     根据好友编号返回对应好友
	*@Author:      李宛恒 
	*@Create Date: 14/5/2015*/
	public abstract Friends selectById(final int relid);
	/**
	*接口目的：                     根据好友对象更新记录
	*@Author:      李宛恒 
	*@Create Date: 14/5/2015*/
	public abstract int update(final Friends friends);
	/**
	*接口目的：                     根据用户编号返回他的所有好友
	*@Author:      李宛恒
	*@Create Date: 14/5/2015*/
	public abstract List<String> selectByUccid(final String fuser);
	/**
	*接口目的：                     根据两个用户编号判断他们是否是好友关系
	*@Author:      李宛恒 
	*@Create Date: 14/5/2015*/
	public abstract boolean  selectByUfid(final String fuser,final String fuserfri);
	/**
	*接口目的：                     根据俩个用户编号删除他们的好友关系
	*@Author:      李宛恒 
	*@Create Date: 14/5/2015*/
	public abstract boolean deleteByUfid(final String fuser,final String fuserfri);
}
