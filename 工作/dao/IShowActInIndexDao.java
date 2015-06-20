/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowActInIndexDao.java
 *作者:	     李东池
 *日期:	   14/05/2015
 *文件描述: 对数据库的showactinindex表进行增删改查
 *修改历史:
           日期1 14/05/2015  李东池   创建
           日期2 16/05/2015  蒲孟       修改
 */
package edu.newdesign.joinus.dao;

import java.util.List;

import edu.newdesign.joinus.vo.ShowActInIndex;

public interface IShowActInIndexDao {
		//根据用户id查询数据库中showactinindex表中数据
         public abstract List<ShowActInIndex> selectById(final String uccid);
         //根据活动id查询数据库中showactinindex表中数据
         public abstract List<ShowActInIndex> selectByAId(final int aid);
}
