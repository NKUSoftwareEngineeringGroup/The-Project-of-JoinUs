package com.icode.chengcheng.biz.impl;

import java.util.List;

import com.icode.chengcheng.biz.IShowInMeBiz;
import com.icode.chengcheng.dao.INewsDao;
import com.icode.chengcheng.dao.impl.NewsDaoImpl;
import com.icode.chengcheng.po.News;

public class ShowInMeBizImpl implements IShowInMeBiz {
     INewsDao newsDao;
     
	public ShowInMeBizImpl() {
		super();
		// TODO Auto-generated constructor stub
	  this.newsDao = new NewsDaoImpl();
	}

	@Override
	public List<News> showInMe(String uccid) {
		// TODO Auto-generated method stub
		return newsDao.selectByUccid(uccid);
	}

}
