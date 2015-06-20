/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowUsersActDao.java
 *作者:	     李东池
 *日期:	   14/05/2015
 *文件描述: 对数据库的showusersact表进行增删改查
 *修改历史:
           日期1 14/05/2015  李东池	   创建
 */
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.vo.ShowUsersAct;

/**
*接口目的：数据库的showusersact表增删改查
* @Author:    李东池 
* @Create:    Date: 2015-05-14
*/
public interface IShowUsersActDao {
	
	//根据用户id查询数据库中showusersact表中数据
	public abstract List<ShowUsersAct> selectByUccid(final String uccid);
	//根据用户id查询数据库中showusersact表中数据
	public abstract List<ShowUsersAct> selectByAid(final int aid);
}
