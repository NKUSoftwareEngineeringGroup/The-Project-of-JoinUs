/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowUserChatroomsDao.java
 *作者:	          金悦
 *日期:	   2015-05-25
 *文件描述: 对数据库的showuserchatrooms表进行增删改查
 *修改历史:
           日期1 2015-05-25     金悦	   创建.
 */
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.vo.ShowUserChatrooms;

/**
*接口目的：数据库的showuserchatrooms表增删改查
* @Author:       金悦
* @Create:    Date: 2015-05-25
*/
public interface IShowUserChatroomsDao {

	//根据用户id查询数据库中showuserchatrooms表中数据
	public abstract List<ShowUserChatrooms> selectById(final String uccid);
	
}
