/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowUsersNewsDao.java
 *作者:	  Pu Meng
 *日期:	   27/5/2015
 *文件描述: 对数据库的shownewsusers表进行增删改查
 *修改历史:
           日期1 27/5/2015 Pu Meng	   创建
           
 */
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.vo.ShowUsersNews;

/**
*接口目的：数据库的shownewsusers表增删改查
* @Author:       ghc 
* @Create:    Date: 2008-07-02
*/
public interface IShowUsersNewsDao {
	
	//根据用户id查询数据库中shownewsusers表中数据
	public abstract List<ShowUsersNews> selectById(final String uccid);
}
