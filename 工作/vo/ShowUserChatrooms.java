/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ShowUserChatrooms.java
 *作者:	   Pu Meng
 *日期:	   5/6/2015 
 *文件描述:   对应Users和Chatrooms的表连接
 *修改历史:
           日期1 5/6/2015 Pu Meng   创建.
           
 ************************************************/
package edu.newdesign.joinus.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ShowUserChatrooms implements Serializable {
    //用户账号，用户姓名，讨论组名称
	private String uccid;
	private String uname;
	private String rname;
	public ShowUserChatrooms() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowUserChatrooms(String uccid, String uname, String rname) {
		super();
		this.uccid = uccid;
		this.uname = uname;
		this.rname = rname;
	}
    //对属性值的存取操作
	public String getUccid() {
		return uccid;
	}
	public void setUccid(String uccid) {
		this.uccid = uccid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "ShowUserChatrooms [uccid=" + uccid + ", uname=" + uname
				+ ", rname=" + rname + ", getUccid()=" + getUccid()
				+ ", getUname()=" + getUname() + ", getRname()=" + getRname()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
