/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ILoginBiz.java
 *作者:	   Pu Meng
 *日期:	   26/5/2015
 *文件描述:   实现用户登录
 *修改历史:
           日期1 26/5/2015	蒲孟   创建.
           
 ************************************************/
package edu.newdesign.joinus.biz;

import edu.newdesign.joinus.po.Users;


public interface ILoginBiz {
	/**
	*接口目的：                     根据所给账号和密码判断是否是合法用户并返回用户信息
	*@Author:      ghc 
	*@Create Date: 2008-07-02*/
	public abstract Users isLogin(final String account, final String password);
}
