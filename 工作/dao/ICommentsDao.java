/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ICommentsDao.java
 *作者:	          金悦
 *日期:	   2015-05-14
 *文件描述:   对数据库的Comments表进行增删改查
 *修改历史:
            日期1 2015-05-14     金悦	   创建.
 ************************************************/
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.po.Comments;


public interface ICommentsDao {
	/**
	*接口目的：                     根据评论对象进行数据库插入
	*@Author:      金悦
	*@Create Date: 2015-05-14*/
	public abstract int insert(final Comments comments);
	/**
	*接口目的：                     根据评论对象进行数据库插入
	*@Author:      金悦
	*@Create Date: 2015-05-14*/
	public abstract int insertu(final Comments comments);
	/**
	*接口目的：                     返回数据库中所有评论记录
	*@Author:      金悦
	*@Create Date: 2015-05-14*/
	public abstract List<Comments> selectAll();
	/**
	*接口目的：                     根据评论编号删除记录
	*@Author:      金悦
	*@Create Date: 2015-05-14*/
	public abstract int deleteById(final int cid);
	/**
	*接口目的：                     根据评论编号返回对应讨论组
	*@Author:      金悦
	*@Create Date: 2015-05-14*/
	public abstract Comments selectById(final int cid);
	/**
	*接口目的：                     根据活动编号删除评论
	*@Author:      金悦
	*@Create Date: 2015-05-14*/
	public abstract boolean deleteByAid(final int aid);

}
