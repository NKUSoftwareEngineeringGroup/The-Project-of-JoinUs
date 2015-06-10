/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowActInIndexBiz.java
 *作者:	          金悦
 *日期:	   2015-05-18
 *文件描述: 查询个人主页活动所需信息的业务逻辑
 *修改历史:
          日期1 2015-05-18     金悦	   创建.
           日期2 2015-05-20  金悦      修改
 */
package edu.newdesign.joinus.biz;

import java.util.List;

import edu.newdesign.joinus.vo.ShowActInIndex;

public interface IShowActInPersonalBiz {
	//根据用户id，查询用户相关活动信息,并按日期排序
    public abstract List<ShowActInIndex> selectAct(final String uccid);
	//根据活动id查询活动信息，并按日期排序显示
    public abstract List<ShowActInIndex> selectAct1(final String uccid);
}
