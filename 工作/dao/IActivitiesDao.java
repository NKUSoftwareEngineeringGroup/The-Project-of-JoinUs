/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    Attend.java
 *作者:	        李东池
 *日期:	    14/05/2015
 *文件描述:   对数据库的Activities表进行增删改查
 *修改历史:
           日期1 14/05/2015  李东池    创建
           日期2 15/05/2015  李宛恒   修改
 ************************************************/
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.po.Activities;

public interface IActivitiesDao {
	/**
	*接口目的：                     根据活动对象进行数据库插入
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract int insert(final Activities activity);
	/**
	*接口目的：                     返回数据库中所有活动
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract List<Activities> selectAll();
	/**
	*接口目的：                    根据活动编号进行数据库删除 
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract int deleteById(final int aid);
	/**
	*接口目的：                     根据活动编号选择活动
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract Activities selectById(final int aid);
	/**
	*接口目的：                     根据活动对象进行数据库更新
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract int update(final Activities activity);
	/**
	*接口目的：                     根据活动对象找到活动编号
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract int selectAid(final Activities activity);
	/**
	*接口目的：                     根据活动编号进行点赞数加一
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract int updatezan(final int aid);
	/**
	*接口目的：                     根据活动编号进行评论数加一
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract int updatecom_num(final int aid);
	/**
	*接口目的：                     根据活动编号进行分享数加一
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract int updateShare(final int aid);
	/**
	*接口目的：                     根据活动编号进行当前人数加一
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract int updateCurr(final int aid);
	/**
	*接口目的：                     根据搜索内容中返回符合名字条件的活动
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract List<Activities> searchAllByname(String searchcont);
	/**
	*接口目的：                      根据搜索内容中返回符合主题条件的活动
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract List<Activities> searchAllBytopic(String searchcont);
	/**
	*接口目的：                       根据搜索内容中返回符合内容条件的活动
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract List<Activities> searchAllBycontent(String searchcont);
	/**
	*接口目的：                     根据活动编号进行当前人数减一
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract int minusCurr(final int aid);
	/**
	*接口目的：                     根据活动编号找到发布者账号
	*@Author: 李东池 
	*@Create Date: 2015-05-14*/
	public abstract String findPub(final int aid);
}
