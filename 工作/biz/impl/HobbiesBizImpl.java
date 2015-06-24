/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    HobbiesBizImpl.java
 *作者:	     李宛恒
 *日期:	   May 19, 2015
 *文件描述:   对用户拥有标签的关系进行操作
 *修改历史:
           日期1 19/5/2015  李宛恒	   创建
           日期2 28/5/2015 李宛恒    修改
 ************************************************/
package edu.newdesign.joinus.biz.impl;

import edu.newdesign.joinus.biz.IHobbiesBiz;
import edu.newdesign.joinus.dao.IHobbiesDao;
import edu.newdesign.joinus.dao.impl.HobbiesDaoImpl;
import edu.newdesign.joinus.po.Hobbies;

public class HobbiesBizImpl implements IHobbiesBiz {
	
	private IHobbiesDao hobbiesDao;
	
	public HobbiesBizImpl() {	
		super();
		// TODO Auto-generated constructor stub
		this.hobbiesDao =new HobbiesDaoImpl();
	}

	/** 
	 * 函数名称:       add
	 * 函数描述 :       根据爱好对象添加用户拥有标签这一关系
	 * @param：                    hobby 爱好对象
	 * @return       boolean：插入成功返回true，失败false
	 * @Author:      李宛恒
	 * @Create Date: 19/5/2015
	 */ 
	@Override
	public boolean add(Hobbies hobby) {
		// TODO Auto-generated method stub
		return this.hobbiesDao.insert(hobby)>0?true:false;
	}

	/** 
	 * 函数名称:       premodify
	 * 函数描述 :       根据用户账号删除标签
	 * @param：                   uccid：用户账号
	 * @return       boolean：删除成功返回true，失败false
	 * @Author:      李宛恒
	 * @Create Date: 19/5/2015
	 */ 
	@Override
	public boolean premodify(String uccid) {
		// TODO Auto-generated method stub
		return this.hobbiesDao.deleteByHuser(uccid)>0?true:false;
	}




	
}
