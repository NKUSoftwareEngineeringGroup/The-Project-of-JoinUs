/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IPublishActivityBiz.java
 *作者:	   李东池
 *日期:	   16/05/2015
 *文件描述: 发布活动业务逻辑
 *修改历史:
           日期1 16/05/2015    李东池	   创建
 */

package edu.newdesign.joinus.biz;

import edu.newdesign.joinus.po.Activities;

/**
*接口目的：发布活动
* @Author:   李东池
* @Create:    Date: 16/05/2015
*/
public interface IPublishActivityBiz {

	//添加具体活动信息，发布活动
	public abstract boolean publish(final Activities activity); 
}
