/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  SearchBizImpl.java
 *作者:	     李东池
 *日期:	   17/05/2015
 *文件描述: 查找活动业务逻辑
 *修改历史:
           日期1 17/05/2015   李东池	   创建
           日期2 18/05/2015  李宛恒  修改
 */

package edu.newdesign.joinus.biz.impl;

import java.util.List;

import edu.newdesign.joinus.biz.ISearchBiz;
import edu.newdesign.joinus.dao.IActivitiesDao;
import edu.newdesign.joinus.dao.impl.ActivitiesDaoImpl;
import edu.newdesign.joinus.po.Activities;

@SuppressWarnings("serial")
public class SearchBizImpl implements ISearchBiz {
	
	private IActivitiesDao activitiesDao;

	
	public SearchBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.activitiesDao = new ActivitiesDaoImpl();
	}

	/** 
	* 函数名称:   search 
	* 函数描述 :  根据活动名称查找活动
	* @param：       searchcont 进行模糊查询的内容
	* @return     List<Activities>  返回活动列表
	* @Author:       李东池 
	* @Create Date: 17/05/2015 
	 */ 
	@Override
	public List<Activities> search(String searchcont) {
		// TODO Auto-generated method stub
		return this.activitiesDao.searchAllByname(searchcont);
	}


	/** 
	* 函数名称:   searchBytopic 
	* 函数描述 :  根据活动主题查找活动
	* @param：       searchcont 进行模糊查询的内容
	* @return     List<Activities>  返回活动列表
	* @Author:      李东池 
	* @Create Date: 17/05/2015 
	 */ 
	@Override
	public List<Activities> searchBytopic(String searchcont) {
		// TODO Auto-generated method stub
		return this.activitiesDao.searchAllBytopic(searchcont);
	}


	/** 
	* 函数名称:   searchBytopic 
	* 函数描述 :  根据活动内容查找活动
	* @param：       searchcont 进行模糊查询的内容
	* @return     List<Activities>  返回活动列表
	* @Author:      李东池 
	* @Create Date: 17/05/2015 
	 */ 
	@Override
	public List<Activities> searchBycontent(String searchcont) {
		// TODO Auto-generated method stub
		return this.activitiesDao.searchAllBycontent(searchcont);
	}
	

}
