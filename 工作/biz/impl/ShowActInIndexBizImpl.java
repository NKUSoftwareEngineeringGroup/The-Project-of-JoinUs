/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowActInIndexBizImpl.java
 *作者:	          金悦
 *日期:	   2015-05-17
 *文件描述: 查询首页活动所需信息的业务逻辑实现
 *修改历史:
          日期1 2015-05-17     金悦	   创建.
 */
package edu.newdesign.joinus.biz.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.newdesign.joinus.biz.IShowActInIndexBiz;
import edu.newdesign.joinus.dao.IFriendsDao;
import edu.newdesign.joinus.dao.IShowActInIndexDao;
import edu.newdesign.joinus.dao.impl.FriendsDaoImpl;
import edu.newdesign.joinus.dao.impl.ShowActInIndexDaoImpl;
import edu.newdesign.joinus.vo.ShowActInIndex;

public class ShowActInIndexBizImpl implements IShowActInIndexBiz {
    IShowActInIndexDao iShowActInIndexDao;
	IFriendsDao iFriendsDao;	


	public ShowActInIndexBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		 iShowActInIndexDao = new ShowActInIndexDaoImpl() ;
		 iFriendsDao = new FriendsDaoImpl();
	}


	/** 
	* 函数名称:   selectAct 
	* 函数描述 :  根据用户id，查询用户及其朋友相关活动信息
	* @param：      uccid 用户id
	* @return    List<ShowActInIndex> 返回首页显示的活动信息
	* @Author:       金悦
	* @Create Date: 2015-05-17 
	 */ 
	@Override
	public List<ShowActInIndex> selectAct(String uccid) {
		// TODO Auto-generated method stub
		List<ShowActInIndex>  lstAct =  iShowActInIndexDao.selectById(uccid);
		List<String> lstFri = iFriendsDao.selectByUccid(uccid);
		for(String fuerfri:lstFri){
			 lstAct.addAll(iShowActInIndexDao.selectById(fuerfri));
		}
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
	public List<ShowActInIndex> selectActByAid(int aid) {
		// TODO Auto-generated method stub
		List<ShowActInIndex>  lstAct =  iShowActInIndexDao.selectByAId(aid);
		Collections.sort(lstAct, new Comparator<ShowActInIndex>() {
			@Override
			public int compare(ShowActInIndex o1, ShowActInIndex o2) {
				// TODO Auto-generated method stub
				return o1.getPdate().compareTo(o2.getPdate());
			}
		});
		return lstAct;
	}

}
