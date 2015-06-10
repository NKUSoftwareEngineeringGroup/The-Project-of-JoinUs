/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ICommentsBiz.java
 *作者:	          金悦
 *日期:	   2015-05-18
 *文件描述:   对评论进行增加与删除
 *修改历史:
         日期1 2015-05-18     金悦	   创建.
      
 ************************************************/
package edu.newdesign.joinus.biz.impl;

import edu.newdesign.joinus.biz.ICommentsBiz;
import edu.newdesign.joinus.dao.ICommentsDao;
import edu.newdesign.joinus.dao.impl.CommentsDaoImpl;
import edu.newdesign.joinus.po.Comments;

public class CommentsBizImpl implements ICommentsBiz {
	
	private ICommentsDao commentsDao;
	
	public CommentsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.commentsDao = new CommentsDaoImpl();
	}

	/** 
	 * 函数名称:       comments
	 * 函数描述 :       根据评论对象 增加一条新评论
	 * @param：                    comments 活评论对象 
	 * @return       boolean：增加评论成功返回true，失败false
	 * @Author:      金悦
	 * @Create Date: 2015-05-18 
	 */ 
	@Override
	public boolean comments(Comments comments) {
		// TODO Auto-generated method stub
		return this.commentsDao.insert(comments)>0?true:false;
	}

	/** 
	 * 函数名称:       deleteComments
	 * 函数描述 :       根据活动编号删除一条评论
	 * @param：                    aid 活动编号
	 * @return       boolean：增加评论成功返回true，失败false
	 * @Author:      金悦
	 * @Create Date: 2015-05-18 
	 */ 
	@Override
	public boolean deleteComments(final int aid) {
		// TODO Auto-generated method stub
		return this.commentsDao.deleteByAid(aid);
	}

}
