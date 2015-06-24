/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    BelongBizImpl.java
 *作者:	    李宛恒
 *日期:	   May 19, 2015
 *文件描述:   对活动的评论进行操作
 *修改历史:
           日期1 19/5/2015  李宛恒	   创建
           日期2 28/5/2015 李宛恒    修改
 ************************************************/
package edu.newdesign.joinus.biz.impl;

import edu.newdesign.joinus.biz.IBelongBiz;
import edu.newdesign.joinus.dao.IBelongDao;
import edu.newdesign.joinus.dao.impl.BelongDaoImpl;
import edu.newdesign.joinus.po.Belong;

public class BelongBizImpl implements IBelongBiz {
	
	private IBelongDao belongDao;

	public BelongBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.belongDao = new BelongDaoImpl();
	}

	/** 
	 * 函数名称:       add
	 * 函数描述 :       根据属于对象实现添加标签的功能
	 * @param：                    belong 所要添加的属于对象
	 * @return       boolean：添加成功返回true，失败false
	 * @Author:      李宛恒
	 * @Create Date: 19/5/2015
	 */ 
	@Override
	public boolean add(Belong belong) {
		// TODO Auto-generated method stub
		return this.belongDao.insert(belong)>0?true:false;
	}

	/** 
	 * 函数名称:       delete
	 * 函数描述 :       根据活动编号实现删除标签功能
	 * @param：                    aid 活动编号
	 * @return       boolean：删除成功返回true，失败false
	 * @Author:      李宛恒
	 * @Create Date: 19/5/2015
	 */ 
	@Override
	public boolean delete(int aid) {
		// TODO Auto-generated method stub
		return this.belongDao.deleteByAid(aid);
	}

}
