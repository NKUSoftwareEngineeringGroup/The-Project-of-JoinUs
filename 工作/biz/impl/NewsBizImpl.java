/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    NewsBizInpl.java
 *作者:	          金悦
 *日期:	   2015-05-19
 *文件描述:   对消息进行删除
 *修改历史:
                日期1 2015-05-19     金悦	   创建.
    
 ************************************************/
package edu.newdesign.joinus.biz.impl;

import edu.newdesign.joinus.biz.INewsBiz;
import edu.newdesign.joinus.dao.INewsDao;
import edu.newdesign.joinus.dao.impl.NewsDaoImpl;

public class NewsBizImpl implements INewsBiz {
     INewsDao newsDao;
     
	public NewsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		newsDao = new NewsDaoImpl();
	}

	/** 
	 * 函数名称:       delete
	 * 函数描述 :       根据消息编号进行删除
	 * @param：                    nid 消息编号
	 * @return       int：数据库影响行数，非零表示删除成功
	 * @Author:      金悦
	 * @Create Date: 2015-05-19 
	 */ 
	@Override
	public int delete(int nid) {
		// TODO Auto-generated method stub
		return newsDao.deleteById(nid);
	}

	/** 
	 * 函数名称:       deleteFri
	 * 函数描述 :       根据用户账号进行删除
	 * @param：                    uccid 用户账号
	 * @return       int：数据库影响行数，非零表示删除成功
	 * @Author:      金悦
	 * @Create Date: 2015-05-19 
	 */ 
	@Override
	public int deleteFri(String uccid) {
		// TODO Auto-generated method stub
         return newsDao.deleteByUccid(uccid);
	}

}
