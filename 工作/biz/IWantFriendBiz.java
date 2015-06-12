/**
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:  IWantFriendBiz.java
 *作者:	   Pu Meng
 *日期:	   27/5/2015
 *文件描述: 好友相关业务逻辑
 *修改历史:
           日期1 27/5/2015 Pu Meng	   创建
          
 */

package edu.newdesign.joinus.biz;

/**
*接口目的：好友申请，添加删除
* @Author:       ghc 
* @Create:    Date: 2008-07-02
*/
public interface IWantFriendBiz {
	//申请添加好友，发送相应消息
	public abstract boolean wantToMakeFriend(final String from,final String to);
	//同意添加好友
    public abstract boolean agreeToMakeFriend(final String from,final String to);
   //拒绝添加好友
    public abstract boolean refuseToMakeFriend(final String from,final String to);
}
