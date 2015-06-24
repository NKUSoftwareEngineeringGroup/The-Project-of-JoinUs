/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IActivityCommentBiz.java
 *作者:	   李东池
 *日期:	   17/05/2015
 *文件描述:   对活动的评论进行操作
 *修改历史:
           日期1 17/05/2015  李东池      创建
           日期2 17/05/2015  金悦          修改
 ************************************************/
package edu.newdesign.joinus.biz;
import edu.newdesign.joinus.po.Activities;

public interface IActivityCommentBiz {
	/**
	*接口目的：                     根据活动编号返回活动信息
	*@Author:      李东池
	*@Create Date: 17/05/2015*/
     public abstract Activities toComment(final int aid);
     /**
 	*接口目的：                     根据活动编号增加赞
 	*@Author:      李东池
 	*@Create Date: 17/05/2015*/
     public abstract boolean tozan(final int aid);
     /**
 	*接口目的：                     根据活动编号增加评论数
 	*@Author:      金悦
 	*@Create Date: 17/05/2015*/
     public abstract boolean tocom(final int aid);
     /**
 	*接口目的：                     用户发布的活动收到来自他人的评论，将其插入News表
 	*@Author:      金悦
 	*@Create Date: 17/05/2015*/
     public abstract boolean toYourActivity(final int aid,final String fromuccid);
     /**
 	*接口目的：                     用户收到回复给自己发布的评论，将其插入News表
 	*@Author:      金悦
 	*@Create Date: 17/05/2015*/
     public abstract boolean toYou(final int aid,final String fromuccid,final int touccid);
}
