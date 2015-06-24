/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IHobbiesDao.java
 *作者:	         李宛恒
 *日期:	     May 15, 2015
 *文件描述:  对数据库的Hobbies表进行增删改查
 *修改历史:
           日期1 15/5/2015  李宛恒  创建
           日期2 26/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.po.Hobbies;

public interface IHobbiesDao {
	/**
	*接口目的：                     根据爱好对象进行数据库插入
	*@Author:      李宛恒 
	*@Create Date: 15/5/2015*/
	public abstract int insert(final Hobbies hobbies);
	/**
	*接口目的：                     返回数据库中所有爱好记录
	*@Author:      李宛恒 
	*@Create Date: 15/5/2015*/
	public abstract List<Hobbies> selectAll();
	/**
	*接口目的：                     根据爱好编号删除记录
	*@Author:      李宛恒 
	*@Create Date: 15/5/2015*/
	public abstract int deleteById(final int hid);
	/**
	*接口目的：                     根据爱好编号返回对应爱好
	*@Author:      李宛恒 
	*@Create Date: 15/5/2015*/
	public abstract Hobbies selectById(final int hid);
	/**
	*接口目的：                     根据爱好对象更新记录
	*@Author:      李宛恒
	*@Create Date: 15/5/2015*/
	public abstract int update(final Hobbies hobbies);
	/**
	*接口目的：                     根据用户编号返回所有爱好
	*@Author:      李宛恒
	*@Create Date: 15/5/2015*/
	public abstract List<Hobbies> selectById2(final String huser);
	/**
	*接口目的：                     根据用户编号删除对应爱好
	*@Author:      李宛恒
	*@Create Date: 15/5/2015*/
	public abstract int deleteByHuser(final String uccid);

}
