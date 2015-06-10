/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    CommentsBizImpl.java
 *作者:	          金悦
 *日期:	   2015-05-18
 *文件描述:   对评论进行增加与删除
 *修改历史:
          日期1 2015-05-18     金悦	   创建.
 
 ************************************************/
package edu.newdesign.joinus.biz;

import edu.newdesign.joinus.po.Comments;

public interface ICommentsBiz {
	/**
	*接口目的：                     根据评论对象 增加一条新评论
	*@Author:      金悦
	*@Create Date: 2015-05-18*/
	public abstract boolean comments(final Comments comments);
	/**
	*接口目的：                     根据活动编号删除一条评论
	*@Author:      金悦
	*@Create Date: 2015-05-18*/
	public abstract boolean deleteComments(final int aid);
}
