/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowUserCommActDao.java
 *作者:	     李宛恒
 *日期:	   May 16, 2015
 *文件描述: 对数据库的showuserscommact表进行增删改查的实现
 * 修改历史:
           日期1 16/5/2015  李宛恒  创建
           日期2 26/5/2015  李宛恒  修改
 */
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.vo.ShowUserCommAct;

/**
*接口目的：数据库的showuserscommact表增删改查
* @Author:       李宛恒
* @Create:    Date: 16/5/2015
*/
public interface IShowUserCommActDao {

	//根据标签名称查询数据库中showuserscommact表中数据
	public abstract List<ShowUserCommAct> selectByAname(final String aname);
	//根据活动id查询数据库中showuserscommact表中数据
	public abstract List<ShowUserCommAct> selectByAid(final int aid);
	
}
