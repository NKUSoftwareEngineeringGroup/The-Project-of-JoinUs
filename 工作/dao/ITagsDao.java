/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ITagsDao.java
 *作者:	   蒲孟
 *日期:	   27/5/2015
 *文件描述: 对数据库的tags表进行增删改查
 *修改历史:
           日期1 27/5/2015 蒲孟	   创建
           
 */
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.po.Tags;


/**
*接口目的：数据库的tags表增删改查
* @Author:       ghc 
* @Create:    Date: 2008-07-02
*/
public interface ITagsDao {
	//数据库中tags表中插入数据
	public abstract int insert(final Tags tags);
	//返回数据库中tags表中所有数据
	public abstract List<Tags> selectAll();
	//根据标签id删除数据库中tags表中数据
	public abstract int deleteById(final int tid);
	//根据标签id查询数据库中tags表中数据
	public abstract Tags selectById(final int tid);
	//根据标签查询数据库中资源表中数据
	public abstract int update(final Tags tags);

}
