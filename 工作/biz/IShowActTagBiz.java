/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowActTagBiz.java
 *作者:	   Pu Meng
 *日期:	   27/5/2015
 *文件描述: 显示活动业务逻辑
 *修改历史:
           日期1 27/5/2015 Pu Meng	   创建
           
 */

package edu.newdesign.joinus.biz;

import java.util.List;

import edu.newdesign.joinus.po.Tags;
import edu.newdesign.joinus.vo.ShowActTag;

/**
*接口目的：显示活动
* @Author:       ghc 
* @Create:    Date: 2008-07-02
*/
public interface IShowActTagBiz {

	 //根据用户id查找用户爱好，根据爱好推荐活动，按日期排序
	 public abstract List<ShowActTag> selectAct(final String uccid);
	//用户爱好活动，再根据分享量（热度）重新进行进行排序
	 public abstract List<Tags> selectHobby(final String uccid);
	//用户爱好活动，再根据评论量重新进行进行排序
	 public abstract List<ShowActTag> selectActByheat(final String uccid);
	//用户爱好活动，再根据参与人数重新进行进行排序
	 public abstract List<ShowActTag> selectActBycomm(final String uccid);
	//通过用户id显示出用户爱好
	 public abstract List<ShowActTag> selectActBycurr(final String uccid);
	//通过活动标签id，列出对应活动
	 public abstract List<ShowActTag> selectActByhobby(final List<Integer> lstTid);
	//通过活动id显示对应活动
	 public abstract List<ShowActTag> selectActByaid(final List<Integer> lstAid);
}
