/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ShowActInPersonalBizImpl.java
 *作者:	          金悦
 *日期:	   2015-05-18
 *文件描述: 查询个人主页活动所需信息的业务逻辑实现
 *修改历史:
          日期1 2015-05-18     金悦	   创建.
           日期2 2015-05-20  金悦      修改
 */
package edu.newdesign.joinus.biz.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.newdesign.joinus.biz.IShowActInPersonalBiz;
import edu.newdesign.joinus.dao.IShowActInIndexDao;
import edu.newdesign.joinus.dao.impl.ShowActInIndexDaoImpl;
import edu.newdesign.joinus.vo.ShowActInIndex;

public class ShowActInPersonalBizImpl implements IShowActInPersonalBiz {
    IShowActInIndexDao iShowActInIndexDao;
    
	public ShowActInPersonalBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		 iShowActInIndexDao = new ShowActInIndexDaoImpl() ;
	}

	/** 
	* 函数名称:   selectAct 
	* 函数描述 :  根据用户id，查询用户相关活动信息,并按日期排序
	* @param：      uccid 用户id
	* @return    List<ShowActInIndex> 返回首页显示的活动信息
	* @Author:       金悦
	* @Create Date: 2015-05-20 
	 */ 
	@Override
	public List<ShowActInIndex> selectAct(String uccid) {
		// TODO Auto-generated method stub
		List<ShowActInIndex>  lstAct =  iShowActInIndexDao.selectById(uccid);
		
		Collections.sort(lstAct, new Comparator<ShowActInIndex>() {

			@Override
			public int compare(ShowActInIndex o1, ShowActInIndex o2) {
				// TODO Auto-generated method stub
				return o2.getPdate().compareTo(o1.getPdate());
			}
			
		});
		return lstAct;
	}

	//根据活动id查询活动信息，并按日期排序显示
	@Override
	public List<ShowActInIndex> selectAct1(String uccid) {
		// TODO Auto-generated method stub
		List<ShowActInIndex>  lstAct =  iShowActInIndexDao.selectById(uccid);
		
		Collections.sort(lstAct, new Comparator<ShowActInIndex>() {

			@Override
			public int compare(ShowActInIndex o1, ShowActInIndex o2) {
				// TODO Auto-generated method stub
				return o1.getAdate().compareTo(o2.getAdate());
			}
			
		});
		return lstAct;
	}

}
