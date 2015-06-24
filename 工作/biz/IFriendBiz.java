/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    FriendBizImpl.java
 *作者:	         李宛恒
 *日期:	     May 19, 2015
 *文件描述:  列出全部或特定好友信息
 *修改历史:
           日期1 19/5/2015  李宛恒  创建
            日期2 27/5/2015  李宛恒  修改
 ************************************************/
package edu.newdesign.joinus.biz;

import java.util.List;

import edu.newdesign.joinus.vo.ShowUserFriend;

public interface IFriendBiz {
	/**
	*接口目的：                    列出全部好友信息
	*@Author:      李宛恒
	*@Create Date: 19/5/2015*/
	public abstract List<ShowUserFriend> showFriend(final String uccid);
	/**
	*接口目的：                    列出特定好友信息
	*@Author:      李宛恒
	*@Create Date: 19/5/2015*/
	public abstract List<ShowUserFriend> searchFriend(final String uccid,final String keyword);
}
