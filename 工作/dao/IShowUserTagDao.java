/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowUserTagDao.java
 *作者:	   Pu Meng
 *日期:	   27/5/2015
 *文件描述: 对数据库的showusertag表进行增删改查
 *修改历史:
           日期1 27/5/2015 Pu Meng	   创建
           
 */
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.vo.ShowUserTag;

/**
*接口目的：数据库的showusertag表增删改查
* @Author:       ghc 
* @Create:    Date: 2008-07-02
*/
public interface IShowUserTagDao {
	//根据用户id查询数据库中showusertag表中数据
	public abstract List<ShowUserTag> selectByTname(final String tname);
	//根据标签名称查询数据库中showusertag表中数据
	public abstract List<ShowUserTag> selectById(final String uccid);
}
