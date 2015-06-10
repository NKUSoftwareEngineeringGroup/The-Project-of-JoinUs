/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IChatroomsDao.java
 *作者:	          金悦
 *日期:	   2015.5.14
 *文件描述:   对数据库的Chatrooms表进行增删改查
 *修改历史:
           日期1 2015.5.14     金悦	   创建.

 ************************************************/
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.po.Chatrooms;

public interface IChatroomsDao {
	/**
	*接口目的：                     根据讨论组对象进行数据库插入
	*@Author:      金悦
	*@Create Date: 2015-05-14*/
	public abstract int insert(final Chatrooms chatrooms);
	/**
	*接口目的：                     返回数据库中所有讨论组记录
	*@Author:      金悦
	*@Create Date: 2015-05-14*/
	public abstract List<Chatrooms> selectAll();
	/**
	*接口目的：                     根据讨论组编号删除记录
	*@Author:      金悦
	*@Create Date: 2015-05-14*/
	public abstract int deleteById(final int rid);
	/**
	*接口目的：                     根据讨论组编号返回对应讨论组
	*@Author:      金悦
	*@Create Date: 2015-05-14*/
	public abstract Chatrooms selectById(final int rid);
	/**
	*接口目的：                     根据讨论组对象更新记录
	*@Author:      金悦
	*@Create Date: 2015-05-14*/
	public abstract int update(final Chatrooms chatrooms);

}
