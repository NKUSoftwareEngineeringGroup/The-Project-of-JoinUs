/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IParticipateBiz.java
 *作者:	         李东池
 *日期:	    17/05/2015
 *文件描述:   对参加发布的活动进行操作
 *修改历史:
           日期1 17/05/2015  李东池	   创建.
           日期2 17/05/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.biz;

import edu.newdesign.joinus.po.Activities;
import edu.newdesign.joinus.po.Participate;

public interface IParticipateBiz {
	/**
	*接口目的：                     根据参加对象增加一个新的参加记录
	*@Author:      李东池
	*@Create Date: 17/05/2015*/
	public abstract boolean participate(final Participate participate); 
	/**
	*接口目的：                     根据活动对象找到它的活动编号
	*@Author:      李东池
	*@Create Date: 17/05/2015*/
	public abstract int selectAid(final Activities activity);
	/**
	*接口目的：                    根据参加对象判断它是否已经是活动中的一员
	*@Author:      李东池
	*@Create Date: 17/05/2015*/
	public abstract int participateIndex(final Participate participate);
	/**
	*接口目的：                     根据活动编号取消发布活动
	*@Author:      李宛恒
	*@Create Date: 17/05/2015*/
	public abstract boolean cancelActivity(final int aid);
	/**
	*接口目的：                     根据活动编号和用户账号取消参加活动
	*@Author:      李宛恒
	*@Create Date: 17/05/2015*/
	public abstract boolean cancelUser(final String uccid,final int aid);
	/**
	*接口目的：                     根据参加对象分享活动
	*@Author:      李东池
	*@Create Date: 17/05/2015*/
    public abstract int  toShare(final Participate participate);
}
