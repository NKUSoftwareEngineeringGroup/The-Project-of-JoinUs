/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IUsersDao.java
 *作者:	          金悦
 *日期:	   2015-05-15
 *文件描述: 对数据库的users表进行增删改查
 *修改历史:
               日期1 2015-05-15     金悦	   创建.
                日期2 2015-05-17     金悦	   修改.
 */
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.po.Users;

/**
*接口目的：数据库的users表增删改查
* @Author:    金悦
* @Create:    Date: 2015-05-15
*/
public interface IUsersDao {
	
	//数据库中users表中插入数据
	public abstract int insert(final Users users);
	//返回数据库中users表中所有数据
	public abstract List<Users> selectAll();
	//根据用户id删除数据库中users表中数据
	public abstract int deleteById(final int uccid);
	//根据用户id查询数据库中users表中数据
	public abstract Users selectById(final String uccid);
	//根据用户id更新数据库中users表中数据
	public abstract int update(final Users users);
	//根据用户id、用户密码查询数据库中users表中数据
	public abstract Users selectByObject(final String uccid, final String upwd);
	//根据用户id查询数据库，返回用户列表
	public abstract List<Users> selectByUccid(final String uccid);
	//根据用户名称模糊查询数据库，返回用户列表
	public abstract List<Users> selectByKey(final String uname);
}
