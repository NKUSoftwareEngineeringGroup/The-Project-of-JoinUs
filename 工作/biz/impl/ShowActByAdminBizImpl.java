/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ShowActByAdminBizImpl.java
 *作者:	          金悦
 *日期:	   2015-05-16
 *文件描述: 显示活动信息业务逻辑实现
 *修改历史:
          日期1 2015-05-15     金悦	   创建.
 */
package edu.newdesign.joinus.biz.impl;

import java.util.List;

import edu.newdesign.joinus.biz.IShowActByAdminBiz;
import edu.newdesign.joinus.dao.IShowActInIndexDao;
import edu.newdesign.joinus.dao.impl.ShowActInIndexDaoImpl;
import edu.newdesign.joinus.vo.ShowActInIndex;

public class ShowActByAdminBizImpl implements IShowActByAdminBiz {
	
	IShowActInIndexDao iShowActInIndexDao;

	public ShowActByAdminBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.iShowActInIndexDao = new ShowActInIndexDaoImpl() ;
	}

	/** 
	* 函数名称:   selectAct 
	* 函数描述 :  根据用户id查找并显示出其相应活动信息
	* @param：      uccid 用户id
	* @return    List<ShowActInIndex> 返回活动信息
	* @Author:       金悦
	* @Create Date: 2015-05-16
	 */ 
	@Override
	public List<ShowActInIndex> selectAct(String uccid) {
		// TODO Auto-generated method stub
		return this.iShowActInIndexDao.selectById(uccid);
	}

}
