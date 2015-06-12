package com.icode.chengcheng.biz.impl;

import com.icode.chengcheng.biz.ILoginBiz;
import com.icode.chengcheng.dao.IUsersDao;
import com.icode.chengcheng.dao.impl.UsersDaoImpl;
import com.icode.chengcheng.po.Users;



public class LoginBizImpl implements ILoginBiz {

	private IUsersDao usersDao;
	
	public LoginBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersDao = new UsersDaoImpl();
	}

	@Override
	public Users isLogin(String account, String password) {
		// TODO Auto-generated method stub
		return this.usersDao.selectByObject(account, password);
	}

}
