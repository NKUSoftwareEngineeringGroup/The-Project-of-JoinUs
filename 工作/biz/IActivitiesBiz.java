/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IActivitiesBiz.java
 *作者:	      李东池
 *日期:	   15/05/2015
 *文件描述:   根据活动编号删除活动记录
 *修改历史:
           日期1 15/05/2015  李东池	   创建
 ************************************************/
package edu.newdesign.joinus.biz;



public interface IActivitiesBiz {
	/**
	*接口目的：                     根据活动编号删除活动记录
	*@Author:      李东池 
	*@Create Date: 15/05/2015*/
     public abstract int deleteActivities(final int aid);
}
