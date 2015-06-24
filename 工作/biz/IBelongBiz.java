/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    IBelongBiz.java
 *作者:	        李宛恒
 *日期:	     May 19, 2015
 *文件描述:  实现活动标签的添加与删除
 *修改历史:
             日期1 19/5/2015  李宛恒  创建
             日期2 27/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.biz;

import edu.newdesign.joinus.po.Belong;

public interface IBelongBiz {
	   /**
	 	*接口目的：                     根据属于对象实现添加标签的功能
	 	*@Author:      李宛恒
	 	*@Create Date: 19/5/2015*/
	public abstract boolean add(final Belong belong);
	   /**
	 	*接口目的：                     根据活动编号实现删除标签功能
	 	*@Author:      李宛恒
	 	*@Create Date: 19/5/2015*/
	public abstract boolean delete(final int aid);

}
