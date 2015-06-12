/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IResourcesDao.java
 *作者:	   Ji Jin
 *日期:	   January 8, 1999
 *文件描述: 对数据库的Resources表进行增删改查
 *修改历史:
           日期1 1/8/1999 Ji Jin	   创建
           日期2 11/2000  Li Zhinxin  修改
 */
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.po.Resources;

/**
*接口目的：数据库的Resources表增删改查
* @Author:       ghc 
* @Create:    Date: 2008-07-02
*/
public interface IResourcesDao {

	//数据库中资源表中插入数据
	public abstract int insert(final Resources resourse);
	//返回数据库中资源表中所有数据
	public abstract List<Resources> selectAll();
	//根据资源id删除数据库中资源表中数据
	public abstract int deleteById(final int resid);
	//根据资源id查询数据库中资源表中数据
	public abstract Resources selectById(final int resid);
}
