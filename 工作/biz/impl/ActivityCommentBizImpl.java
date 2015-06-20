/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ActivityCommentBizImpl.java
 *作者:	   李东池
 *日期:	  18/05/2015
 *文件描述:   对活动的评论进行操作
 *修改历史:
           日期1 18/05/2015  李东池	   创建.
           日期2 18/05/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.biz.impl;


import edu.newdesign.joinus.biz.IActivityCommentBiz;
import edu.newdesign.joinus.dao.IActivitiesDao;
import edu.newdesign.joinus.dao.ICommentsDao;
import edu.newdesign.joinus.dao.INewsDao;
import edu.newdesign.joinus.dao.IUsersDao;
import edu.newdesign.joinus.dao.impl.ActivitiesDaoImpl;
import edu.newdesign.joinus.dao.impl.CommentsDaoImpl;
import edu.newdesign.joinus.dao.impl.NewsDaoImpl;
import edu.newdesign.joinus.dao.impl.UsersDaoImpl;
import edu.newdesign.joinus.po.Activities;
import edu.newdesign.joinus.po.Comments;
import edu.newdesign.joinus.po.News;
import edu.newdesign.joinus.po.Users;

public class ActivityCommentBizImpl implements IActivityCommentBiz {
     IActivitiesDao iActivitiesDao;
     IUsersDao usersDao;
     INewsDao newsDao ;
     ICommentsDao commentsDao;
     
	public ActivityCommentBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		iActivitiesDao =new ActivitiesDaoImpl();
		this.usersDao = new UsersDaoImpl();
		this.newsDao = new NewsDaoImpl();
		this.commentsDao = new CommentsDaoImpl();
	}
	/** 
	 * 函数名称:      toComment
	 * 函数描述 :     根据活动编号返回活动信息
	 * @param：            aid 活动编号
	 * @return       Activities：活动对象
	 * @Author:      李东池 
	 * @Create Date: 18/05/2015 
	 */ 
	@Override
	public Activities toComment(int aid) {
		// TODO Auto-generated method stub
		return iActivitiesDao.selectById(aid);
	}
	/** 
	 * 函数名称:      tozan
	 * 函数描述 :     根据活动编号增加赞
	 * @param：            aid 活动编号
	 * @return       boolean：操作成功返回true，失败返回false
	 * @Author:      李东池 
	 * @Create Date: 18/05/2015 
	 */ 
	@Override
	public boolean tozan(int aid) {
		// TODO Auto-generated method stub
		return this.iActivitiesDao.updatezan(aid)>0?true:false;
	}
	/** 
	 * 函数名称:      insert
	 * 函数描述 :     根据活动编号增加评论数
	 * @param：            aid 活动编号
	 * @return       boolean：操作成功返回true，失败返回false
	 * @Author:      李东池 
	 * @Create Date: 18/05/2015 
	 */ 
	@Override
	public boolean tocom(int aid) {
		// TODO Auto-generated method stub
		return this.iActivitiesDao.updatecom_num(aid)>0?true:false;
	}
	/** 
	 * 函数名称:      toYourActivity
	 * 函数描述 :     用户发布的活动收到来自他人的评论，将其插入News表
	 * @param：            aid 活动编号 fromuccid 来自用户账号
	 * @return       boolean：操作成功返回true，失败返回false
	 * @Author:      李东池 
	 * @Create Date: 18/05/2015 
	 */ 
	@Override
	public boolean toYourActivity(int aid, String fromuccid) {
		// TODO Auto-generated method stub
		String owner_id = iActivitiesDao.findPub(aid);
		if(!owner_id.equals(fromuccid)){
		    Users user =  usersDao.selectById(fromuccid);
	     	Activities act = iActivitiesDao.selectById(aid);
		 
		     String ncontent = user.getUccid()+"/"+user.getUname()+"/"+user.getUphoto()+"/"+act.getAid()+"/"+act.getAname();
		     News news = new News();
		     news.setNfrom("小诚");
		     news.setNuser(owner_id);
		     news.setNtype(2);
		     news.setNcontent(ncontent);
		  
		   
		 if( newsDao.insert(news)>0)
			 return true;
		return false;}
		return true;
	}
	/** 
	 * 函数名称:      toYou
	 * 函数描述 :     用户收到回复给自己发布的评论，将其插入News表
	 * @param：            aid 活动编号 fromuccid 来自用户账号 touccid 发往用户账号
	 * @return       boolean：操作成功返回true，失败返回false
	 * @Author:      李东池 
	 * @Create Date: 18/05/2015 
	 */ 
	@Override
	public boolean toYou(int aid, String fromuccid, int touccid) {
		// TODO Auto-generated method stub
		 Comments com = commentsDao.selectById(touccid);
		    String uccid = com.getCuser_from();
		   	Users user =  usersDao.selectById(fromuccid);
			Activities act = iActivitiesDao.selectById(aid);
			 if(!uccid.equals(fromuccid)){  
			     String ncontent = user.getUccid()+"/"+user.getUname()+"/"+user.getUphoto()+"/"+act.getAid()+"/"+act.getAname();
			     News news = new News();
			     news.setNfrom("小诚");
			     news.setNuser(uccid);
			     news.setNtype(3);
			     news.setNcontent(ncontent);

		
			 if( newsDao.insert(news)>0)
				 return true;
			return false;}
			 return true;
		}
	}

