/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    INewsBiz.java
 *作者:	          金悦
 *日期:	   2015-05-19
 *文件描述:   对消息进行删除
 *修改历史:
              日期1 2015-05-19     金悦	   创建.
 ************************************************/
package edu.newdesign.joinus.biz;

public interface INewsBiz {
	/**
	*接口目的：                     根据消息编号进行删除
	*@Author:      金悦
	*@Create Date: 2015-05-19*/
     public abstract int delete(final int nid);
 	/**
 	*接口目的：                     根据用户账号进行删除
 	*@Author:      金悦
 	*@Create Date: 2015-05-19*/
     public abstract int deleteFri(final String Uccid);
}
