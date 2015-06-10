/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IShowActByAdminBiz.java
 *作者:	          金悦
 *日期:	   2015-05-16
 *文件描述: 显示活动信息业务逻辑
 *修改历史:
         日期1 2015-05-16     金悦	   创建.
          
 */

package edu.newdesign.joinus.biz;

import java.util.List;

import edu.newdesign.joinus.vo.ShowActInIndex;

//根据用户id查找并显示出其相应活动信息
public interface IShowActByAdminBiz {
	public abstract List<ShowActInIndex> selectAct(final String uccid);
}
