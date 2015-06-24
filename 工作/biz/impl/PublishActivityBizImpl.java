/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  PublishActivityBizImpl.java
 *作者:	   李东池
 *日期:	   18/05/2015
 *文件描述: 发布活动业务逻辑实现
 *修改历史:
           日期1 18/05/2015    李东池	   创建
           日期2 20/05/2015  金悦  修改
 */
package edu.newdesign.joinus.biz.impl;

import edu.newdesign.joinus.biz.IPublishActivityBiz;
import edu.newdesign.joinus.dao.IActivitiesDao;
import edu.newdesign.joinus.dao.impl.ActivitiesDaoImpl;
import edu.newdesign.joinus.po.Activities;

public class PublishActivityBizImpl implements IPublishActivityBiz {

	private IActivitiesDao activitiesDao;
	
	public PublishActivityBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.activitiesDao=new ActivitiesDaoImpl();
	}
	
	/** 
	* 函数名称:   publish 
	* 函数描述 :  填写具体活动信息，发布活动
	* @param：       activity 包含活动的具体信息 
	* @return     boolean  检查是否成功插入一条活动信息
	*                      即是否成功发布活动
	* @Author:       李东池 
	* @Create Date: 18/05/2015
	 */ 
	@Override
	public boolean publish(Activities activity) {
		
		
		// TODO Auto-generated method stub
		return this.activitiesDao.insert(activity)>0?true:false;
	}

}
