/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IAttendDao.java
 *作者:	   Pu Meng
 *日期:	   27/5/2015
 *文件描述:   对数据库的Attend表进行增删改查
 *修改历史:
           日期1 27/5/2015 Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.po.Attend;


public interface IAttendDao {
	/**
	*接口目的：                     根据加入对象进行数据库插入
	*@Author:      ghc 
	*@Create Date: 2008-07-02*/
	public abstract int insert(final Attend attend);
	/**
	*接口目的：                     返回数据库中所有加入记录
	*@Author:      ghc 
	*@Create Date: 2008-07-02*/
	public abstract List<Attend> selectAll();
	/**
	*接口目的：                     根据加入编号删除对应加入关系
	*@Author:      ghc 
	*@Create Date: 2008-07-02*/
	public abstract int deleteById(final int jid);
	/**
	*接口目的：                      根据加入编号返回对应加入对象
	*@Author:      ghc 
	*@Create Date: 2008-07-02*/
	public abstract Attend selectById(final int jid);
	/**
	*接口目的：                     根据加入对象进行数据库更新
	*@Author:      ghc 
	*@Create Date: 2008-07-02*/
	public abstract int update(final Attend attend);
}
