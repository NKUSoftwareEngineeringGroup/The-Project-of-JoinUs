/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ParticipateBizImpl.java
 *作者:	   李东池
 *日期:	  18/05/2015
 *文件描述:   对参加发布的活动进行操作
 *修改历史:
           日期1 18/05/2015      李东池	   创建.
           日期2 18/05/2015  金悦  修改
 ************************************************/
package edu.newdesign.joinus.biz.impl;


import java.util.List;

import edu.newdesign.joinus.biz.IParticipateBiz;
import edu.newdesign.joinus.dao.IActivitiesDao;
import edu.newdesign.joinus.dao.INewsDao;
import edu.newdesign.joinus.dao.IParticipateDao;
import edu.newdesign.joinus.dao.IUsersDao;
import edu.newdesign.joinus.dao.impl.ActivitiesDaoImpl;
import edu.newdesign.joinus.dao.impl.NewsDaoImpl;
import edu.newdesign.joinus.dao.impl.ParticipateDaoImpl;
import edu.newdesign.joinus.dao.impl.UsersDaoImpl;
import edu.newdesign.joinus.po.Activities;
import edu.newdesign.joinus.po.News;
import edu.newdesign.joinus.po.Participate;
import edu.newdesign.joinus.po.Users;

public class ParticipateBizImpl implements IParticipateBiz {

	private IParticipateDao participateDao;
	private IActivitiesDao activityDao;
	private INewsDao  newsDao ;
	private IUsersDao usersDao;
	
	public ParticipateBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.participateDao = new ParticipateDaoImpl();
		this.activityDao= new ActivitiesDaoImpl();
		this.newsDao = new NewsDaoImpl();
		this.usersDao =new UsersDaoImpl();
	}


	/** 
	 * 函数名称:      participate
	 * 函数描述 :     根据参加对象增加一个新的参加记录
	 * @param：             participate 参加对象
	 * @return       boolean：参加成功返回true，失败false
	 * @Author:      李东池 
	 * @Create Date: 18/05/2015 
	 */ 

	@Override
	public boolean participate(Participate participate) {
		// TODO Auto-generated method stub
		
		return this.participateDao.insert(participate)>0?true:false;
	}


	/** 
	 * 函数名称:      selectAid
	 * 函数描述 :     根据活动对象找到它的活动编号
	 * @param：            activity 活动对象
	 * @return       int：活动的编号
	 * @Author:      李东池 
	 * @Create Date: 18/05/2015 
	 */ 

	@Override
	public int selectAid(Activities activity) {
		// TODO Auto-generated method stub
		return this.activityDao.selectAid(activity);
	}



	/** 
	 * 函数名称:      participateIndex
	 * 函数描述 :     根据参加对象判断它是否已经是活动中的一员
	 * @param：             participate 活动对象
	 * @return       int：-1代表参加过
	 *                    1代表参加成功
	 * @Author:      李东池 
	 * @Create Date: 18/05/2015 
	 */ 
	@Override
	public int participateIndex(Participate participate) {
		// TODO Auto-generated method stub
		int pact = participate.getPact();
		String puser = participate.getPuser();
		List<Participate> lstAct = participateDao.selectAct(pact);
		System.out.println(lstAct);
		for(Participate p:lstAct){
		if(p.getPuser().equals(puser)&&p.getPtype()!=2)
			return -1;
		}
	
		if(participateDao.insert(participate)>0){
			   Users user =  usersDao.selectById(puser);
			  Activities act = activityDao.selectById(pact);
			for(Participate p:lstAct){
				//通知所有参加活动的人有一个新成员加入
				if(p.getPtype()!=2){
			  
			     String ncontent = user.getUccid()+"/"+user.getUname()+"/"+user.getUphoto()+"/"+act.getAid()+"/"+act.getAname();
			     News news = new News();
			     news.setNfrom("小诚");
			     news.setNuser(p.getPuser());
			     news.setNtype(1);
			     news.setNcontent(ncontent);
			 
			     newsDao.insert(news);
				 }
			}
			activityDao.updateCurr(pact);
			return 1;
		}
		return 0;
	
	}



	/** 
	 * 函数名称:      toComment
	 * 函数描述 :     根据活动编号取消发布活动
	 * @param：             aid 活动编号
	 * @return       Activities：活动对象
	 * @Author:      李东池 
	 * @Create Date: 18/05/2015 
	 */ 
	@Override
	public boolean cancelActivity(int aid) {
		// TODO Auto-generated method stub
		
		return  this.participateDao.deleteByAid(aid)?true:false;
	}



	/** 
	 * 函数名称:      toComment
	 * 函数描述 :     根据活动编号和用户账号取消参加活动
	 * @param：             aid 活动编号
	 * @return       Activities：活动对象
	 * @Author:      李东池 
	 * @Create Date: 18/05/2015 
	 */ 
	@Override
	public boolean cancelUser(String uccid, int aid) {
		// TODO Auto-generated method stub
		if(participateDao.deleteByOthers(uccid,aid)&&activityDao.minusCurr(aid)>0)
			return true;
		return false;
	}

	/** 
	 * 函数名称:      toComment
	 * 函数描述 :     根据参加对象分享活动
	 * @param：            aid 活动编号
	 * @return       Activities：活动对象
	 * @Author:      李东池 
	 * @Create Date: 18/05/2015 
	 */ 
	@Override
	public int toShare(Participate participate) {
		// TODO Auto-generated method stub
		
		int pact = participate.getPact();
		String puser = participate.getPuser();
		List<Participate> lstAct = participateDao.selectAct(pact);
		for(Participate p:lstAct){
		if(p.getPuser().equals(puser))
			return -1;
		}
		if(participateDao.insert(participate)>0){
			activityDao.updateShare(pact);
			return 1;
		}
		return 0;
	}
}
