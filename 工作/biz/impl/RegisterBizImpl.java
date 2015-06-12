package com.icode.chengcheng.biz.impl;

import java.util.List;

import com.icode.chengcheng.biz.IRegisterBiz;
import com.icode.chengcheng.dao.IUsersDao;
import com.icode.chengcheng.dao.impl.UsersDaoImpl;
import com.icode.chengcheng.po.Users;



public class RegisterBizImpl implements IRegisterBiz {

	private IUsersDao usersDao;
	
	
	
	public RegisterBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersDao = new UsersDaoImpl();
	}



	@Override
	public boolean register(Users user) {
		// TODO Auto-generated method stub
		return this.usersDao.insert(user)>0?true:false;
	}

	

	@Override
	public List<Users> showUsers() {
		// TODO Auto-generated method stub
		return this.usersDao.selectAll();
	}



	@Override
	public Users checkUser(String uccid) {
		// TODO Auto-generated method stub
		return this.usersDao.selectById(uccid);
	}



	@Override
	public boolean checkUpwd(String uccid, String upwdformer) {
		// TODO Auto-generated method stub
		String pwd1=this.usersDao.selectById(uccid).getUpwd();
		String pwd2=upwdformer;
		//System.out.println("我要测试一下原来的"+pwd1);	
		//System.out.println("我要测试一下改了的"+pwd2);
		
		if(pwd1.equals(pwd2))
		{
			return true;
		}
		else return false;
	}



	@Override
	public boolean modify(Users user) {
		// TODO Auto-generated method stub
		return this.usersDao.update(user)>0?true:false;
	}

}
