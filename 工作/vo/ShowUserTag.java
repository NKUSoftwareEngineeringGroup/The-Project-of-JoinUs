/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ShowUserTag.java
 *作者:	   Pu Meng
 *日期:	   6/6/2015
 *文件描述:   对应Users和Tags表连接
 *修改历史:
           日期1 6/6/2015 Pu Meng   创建.
       
 ************************************************/
package edu.newdesign.joinus.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ShowUserTag implements Serializable {
	//用户账号，用户姓名，标签名称
	private String uccid;
	private String uname;
	private String tname;

	public ShowUserTag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowUserTag(String uccid, String uname, String tname) {
		super();
		this.uccid = uccid;
		this.uname = uname;
		this.tname = tname;
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
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "showUserTag [uccid=" + uccid + ", uname=" + uname + ", tname="
				+ tname + "]";
	}
    
}
