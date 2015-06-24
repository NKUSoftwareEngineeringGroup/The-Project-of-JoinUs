/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:   IShowUserFriendDao.java
 *作者:	       李宛恒
 *日期:	    May 16, 2015
 *文件描述: 对数据库的showuserfriend表进行增删改查
 * 修改历史:
           日期1 16/5/2015  李宛恒  创建
           日期2 26/5/2015  李宛恒  修改
 */
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.vo.ShowUserFriend;

/**
*接口目的：数据库的showuserfriend表进行增删改查
* @Author:       李宛恒 
* @Create:    Date: 16/5/2015
*/
public interface IShowUserFriendDao {
	//根据用户id查询数据库中showuserfriend表中数据
	public abstract List<ShowUserFriend> selectByUser(final String uccid);
	//根据用户id、及关键字模糊查询数据库中表showuserfriend中数据
	public abstract List<ShowUserFriend> selectByKey(String uccid,final String keyword);
}
