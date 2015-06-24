/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:   IBelongDao.java
 *作者:	       李宛恒
 *日期:	    May 14, 2015
 *文件描述: 对数据库的Belong表进行增删改查
 *修改历史:
           日期1 14/5/2015  李宛恒  创建
           日期2 26/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.po.Belong;


public interface IBelongDao {
	/**
	*接口目的：                     根据属于对象进行数据库插入
	*@Author:      李宛恒
	*@Create Date: 14/5/2015*/
	public abstract int insert(final Belong belong);
	/**
	*接口目的：                     返回数据库所有属于记录
	*@Author:      李宛恒
	*@Create Date: 14/5/2015*/
	public abstract List<Belong> selectAll();
	/**
	*接口目的：                      根据属于编号进行数据库删除 
	*@Author:      李宛恒 
	*@Create Date: 14/5/2015*/
	public abstract int deleteById(final int bid);
	/**
	*接口目的：                      根据属于编号返回对应属于关系
	*@Author:      李宛恒 
	*@Create Date: 14/5/2015*/
	public abstract Belong selectById(final int bid);
	/**
	*接口目的：                     根据属于对象进行数据库更新
	*@Author:      李宛恒
	*@Create Date: 14/5/2015*/
	public abstract int update(final Belong belong);
	/**
	*接口目的：                     根据活动编号进行删除属于关系
	*@Author:      李宛恒
	*@Create Date: 14/5/2015*/
	public abstract boolean deleteByAid(final int aid);
}
