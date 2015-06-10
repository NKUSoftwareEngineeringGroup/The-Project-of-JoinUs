/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowActInIndexBiz.java
 *作者:	          金悦
 *日期:	   2015-05-17
 *文件描述: 查询首页活动所需信息的业务逻辑
 *修改历史:
                日期1 2015-05-17     金悦	   创建.
 */

package edu.newdesign.joinus.biz;

import java.util.List;

import edu.newdesign.joinus.vo.ShowActInIndex;

/**
*接口目的：查询首页活动所需信息
* @Author:       金悦
* @Create:    Date: 2015-05-17
*/
public interface IShowActInIndexBiz {
	//根据用户id，查询用户及其朋友相关活动信息
    public abstract List<ShowActInIndex> selectAct(final String uccid);
    //根据活动id查询活动信息，并按日期排序显示
    public abstract List<ShowActInIndex> selectActByAid(final int aid);
}
