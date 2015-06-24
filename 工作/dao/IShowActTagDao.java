/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowActTagDao.java
 *作者:	     李东池
 *日期:    14/05/2015      	
 *文件描述: 对数据库的showacttag表进行增删改查
 *修改历史:
           日期1 14/05/2015      李东池	   创建
           日期2 16/05/2015  蒲孟     修改
 */
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.vo.ShowActTag;

public interface IShowActTagDao {
	//根据活动id查询数据库中ShowActTag表中数据
	public abstract List<ShowActTag> selectByTname(final int tname);
	//根据标签名称查询数据库中ShowActTag表中数据
	public abstract List<ShowActTag> selectAll();
	//查询数据库中ShowActTag表中所有数据
	public abstract List<ShowActTag> selectById(int aid);
	//根据资标签id查询数据库中ShowActTag表中数据
	public abstract  List<ShowActTag> selectByTag(int tid);
}
