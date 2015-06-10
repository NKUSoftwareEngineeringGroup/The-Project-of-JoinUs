/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    INewsDao.java
 *作者:	          金悦
 *日期:	   2015-05-18
 *文件描述:   对数据库的News表进行增删改查
 *修改历史:
                        日期1 2015-05-18     金悦	   创建.
 ************************************************/
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.po.News;

public interface INewsDao {
	/**
	*接口目的：                     根据消息对象进行数据库插入
	*@Author:      金悦
	*@Create Date: 2015-05-18*/
	public abstract int insert(final News news);
	/**
	*接口目的：                     返回数据库中所有消息记录
	*@Author:      金悦
	*@Create Date: 2015-05-18*/
	public abstract List<News> selectAll();
	/**
	*接口目的：                     根据消息编号删除记录
	*@Author:      金悦
	*@Create Date: 2015-05-18*/
	public abstract int deleteById(final int nid);
	/**
	*接口目的：                     根据消息编号返回对应消息
	*@Author:      金悦
	*@Create Date: 2015-05-18*/
	public abstract News selectById(final int nid);
	/**
	*接口目的：                     根据用户账号返回消息列表
	*@Author:      金悦
	*@Create Date: 2015-05-18*/
	public abstract List<News> selectByUccid(final String uccid);
	/**
	*接口目的：                     根据用户账号删除消息
	*@Author:      金悦
	*@Create Date: 2015-05-18*/
	public abstract int deleteByUccid(final String uccid);
}
