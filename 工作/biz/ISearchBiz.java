/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ISearchBiz.java
 *作者:	     李东池
 *日期:	   16/05/2015  
 *文件描述: 查找活动业务逻辑
 *修改历史:
           日期1 16/05/2015   李东池	   创建
           日期2 17/05/2015   金悦  修改
 */

package edu.newdesign.joinus.biz;

import java.io.Serializable;
import java.util.List;

import edu.newdesign.joinus.po.Activities;

/**
*接口目的：按照不同字段查找活动
* @Author:    李东池 
* @Create:    Date: 16/05/2015  
*/
public interface ISearchBiz extends Serializable {
	
	//根据活动名称查找活动
	public abstract List<Activities> search(final String searchcont);
	//根据活动主题查找活动
	public abstract List<Activities> searchBytopic(final String searchcont);
	//根据活动内容查找活动
	public abstract List<Activities> searchBycontent(final String searchcont);
	

}
