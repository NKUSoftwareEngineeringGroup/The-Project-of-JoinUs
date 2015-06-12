package com.icode.chengcheng.biz.impl;

import com.icode.chengcheng.biz.IWantFriendBiz;
import com.icode.chengcheng.dao.INewsDao;
import com.icode.chengcheng.dao.IUsersDao;
import com.icode.chengcheng.dao.impl.NewsDaoImpl;
import com.icode.chengcheng.dao.impl.UsersDaoImpl;
import com.icode.chengcheng.po.News;
import com.icode.chengcheng.po.Users;

public class WantFriendBizImpl implements IWantFriendBiz {
    IUsersDao usersDao;
    INewsDao newsDao;
    
	public WantFriendBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		usersDao = new UsersDaoImpl();
		newsDao = new NewsDaoImpl();
	}


	@Override
	public boolean wantToMakeFriend(String from, String to) {
		// TODO Auto-generated method stub
		Users user = usersDao.selectById(from);
		News news = new News();
		
		news.setNcontent(user.getUname()+"/"+user.getUphoto());
	
		news.setNfrom(from);
		news.setNuser(to);
		news.setNtype(4);
		if(newsDao.insert(news)>0)
		    return true;
		return false;
	}

	@Override
	public boolean agreeToMakeFriend(String from, String to) {
		// TODO Auto-generated method stub
		Users user = usersDao.selectById(from);
		News news = new News();
		
		news.setNcontent(user.getUname()+"/"+user.getUphoto());
	
		news.setNfrom(from);
		news.setNuser(to);
		news.setNtype(5);
		if(newsDao.insert(news)>0)
		    return true;
		return false;
	}

	@Override
	public boolean refuseToMakeFriend(String from, String to) {
		// TODO Auto-generated method stub
		Users user = usersDao.selectById(from);
		News news = new News();
		
		news.setNcontent(user.getUname()+"/"+user.getUphoto());
	
		news.setNfrom(from);
		news.setNuser(to);
		news.setNtype(6);
		if(newsDao.insert(news)>0)
		    return true;
		return false;
	}

}
