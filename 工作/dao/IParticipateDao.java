/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IChatroomsDao.java
 *作者:	         李东池
 *日期:	     14/05/2015
 *文件描述:   对数据库的Chatrooms表进行增删改查
 *修改历史:
           日期1 14/05/2015  李东池      创建.
           日期2 14/05/2015  蒲孟          修改
 ************************************************/
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.po.Participate;

public interface IParticipateDao {
	/**
	*接口目的：                     根据参加对象进行数据库插入
	*@Author: 李东池
	*@Create Date: 2015-05-14*/
	public abstract int insert(final Participate participate);
	/**
	*接口目的：                     返回数据库中所有参加记录
	*@Author: 李东池
	*@Create Date: 2015-05-14*/
	public abstract List<Participate> selectAll();
	/**
	*接口目的：                     根据参加编号删除记录
	*@Author: 李东池
	*@Create Date: 2015-05-14*/
	public abstract int deleteById(final int pid);
	/**
	*接口目的：                     根据参加编号返回对应参加记录
	*@Author: 李东池
	*@Create Date: 2015-05-14*/
	public abstract Participate selectById(final int pid);
	/**
	*接口目的：                     根据活动编号返回参加记录列表
	*@Author: 李东池
	*@Create Date: 2015-05-14*/
	public abstract List<Participate> selectAct(final int pact);
	/**
	*接口目的：                     根据活动编号删除参加记录
	*@Author: 李东池
	*@Create Date: 2015-05-14*/
	public abstract boolean deleteByAid(final int aid);
	/**
	*接口目的：                     根据活动编号用户账户删除参加记录
	*@Author: 李东池
	*@Create Date: 2015-05-14*/
	public abstract boolean deleteByOthers(final String uccid,final int aid);
}
