/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IHobbiesBiz.java
 *作者:	       李宛恒
 *日期:	    May 19, 2015
 *文件描述: 对用户拥有标签的关系进行操作
 *修改历史:
            日期1 19/5/2015  李宛恒  创建
            日期2 27/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.biz;

import edu.newdesign.joinus.po.Hobbies;

public interface IHobbiesBiz {
	/**
	*接口目的：                     根据爱好对象添加用户拥有标签这一关系
	*@Author:      李宛恒
	*@Create Date: 19/5/2015*/
	public abstract boolean add(final Hobbies hobby);
	/**
	*接口目的：                     根据用户账号删除标签
	*@Author:      李宛恒 
	*@Create Date: 19/5/2015*/
	public abstract boolean premodify(final String uccid);
	
}
