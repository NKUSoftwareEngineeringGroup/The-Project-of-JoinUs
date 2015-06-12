/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IRegisterBiz.java
 *作者:	   Pu Meng
 *日期:	   26/5/2015
 *文件描述: 用户注册业务逻辑
 *修改历史:
           日期26/5/2015 Pu Meng	   创建
           
 */
package edu.newdesign.joinus.biz;

import java.util.List;

import edu.newdesign.joinus.po.Users;

/**
*接口目的：用户注册
* @Author:       ghc 
* @Create:    Date: 2008-07-02
*/
public interface IRegisterBiz {

	//填写用户信息，注册
	public abstract boolean register(final Users user); 
	//显示用户信息
	public abstract List<Users> showUsers();
	//检查用户id是否重复
	public abstract Users checkUser(String uccid);
	//检查两次输入密码是否一致
	public abstract boolean checkUpwd(String uccid,String upwd);
	//修改用户信息
	public abstract boolean modify(final Users user);
}
