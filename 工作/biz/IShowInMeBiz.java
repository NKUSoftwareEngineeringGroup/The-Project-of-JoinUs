/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowInMeBiz.java
 *作者:	   Ji Jin
 *日期:	   27/5/2015
 *文件描述: 我的消息业务逻辑
 *修改历史:
           日期1 27/5/2015 Pu Meng	   创建
           
 */

package edu.newdesign.joinus.biz;

import java.util.List;

import edu.newdesign.joinus.po.News;


public interface IShowInMeBiz {
	   //显示用户消息
       public abstract List<News> showInMe(final String uccid);
}
