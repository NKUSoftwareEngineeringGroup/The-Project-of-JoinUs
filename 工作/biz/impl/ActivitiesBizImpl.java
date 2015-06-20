/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ActivitiesBizImpl.java
 *作者:	   李东池
 *日期:	  17/05/2015
 *文件描述:   根据活动编号删除活动记录
 *修改历史:
           日期1 17/05/2015  李东池	   创建
 ************************************************/
package edu.newdesign.joinus.biz.impl;

import edu.newdesign.joinus.biz.IActivitiesBiz;
import edu.newdesign.joinus.dao.IActivitiesDao;
import edu.newdesign.joinus.dao.impl.ActivitiesDaoImpl;


public class ActivitiesBizImpl implements IActivitiesBiz {
     IActivitiesDao activitiesDao;
     
	public ActivitiesBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		activitiesDao = new ActivitiesDaoImpl();
	}
	/** 
	 * 函数名称:      deleteActivities
	 * 函数描述 :     根据活动编号删除活动记录
	 * @param：             aid：要删除的活动编号
	 * @return       int：数据库操作影响的行数
	 * @Author:      李东池 
	 * @Create Date: 17/05/2015 
	 */ 
	@Override
	public int deleteActivities(int aid) {
		// TODO Auto-generated method stub
		return activitiesDao.deleteById(aid);
	}

}
