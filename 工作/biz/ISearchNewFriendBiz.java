/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  ISearchNewFriendBiz.java
 *作者:	    李宛恒
 *日期:	   May 19, 2015
 *文件描述: 查询新好友业务逻辑
 *修改历史:
          日期1 19/5/2015  李宛恒  创建
          日期2 27/5/2015  李宛恒  修改
 */

package edu.newdesign.joinus.biz;

import java.util.List;

import edu.newdesign.joinus.po.Users;

/**
*接口目的：查找好友
* @Author:    李宛恒
* @Create:    Date: 19/5/2015
*/
public interface ISearchNewFriendBiz {
	//根据用户名模糊查询，显示非好友的其他用户
      public abstract List<Users> addNew(String uccid,String keyword);
}
