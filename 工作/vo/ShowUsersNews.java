/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ShowUsersNews.java
 *作者:	   Pu Meng
 *日期:	   6/6/2015
 *文件描述:   对应Users和News表连接
 *修改历史:
           日期1 6/6/2015  Pu Meng	   创建.
          
 ************************************************/
package edu.newdesign.joinus.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ShowUsersNews implements Serializable {
	//用户账号，用户姓名，发消息人账号，消息内容，发送日期，消息类型
	private String uccid;
	private String uname;
	private String nuser;
	private String ncontent;
	private Date ndate;
	private int ntype;
	
	public ShowUsersNews() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ShowUsersNews(String uccid, String uname, String nuser,
			String ncontent, Date ndate, int ntype) {
		super();
		this.uccid = uccid;
		this.uname = uname;
		this.nuser = nuser;
		this.ncontent = ncontent;
		this.ndate = ndate;
		this.ntype = ntype;
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
	public String getNuser() {
		return nuser;
	}
	public void setNuser(String nuser) {
		this.nuser = nuser;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Date getNdate() {
		return ndate;
	}
	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}
	public int getNtype() {
		return ntype;
	}
	public void setNtype(int ntype) {
		this.ntype = ntype;
	}
	
	@Override
	public String toString() {
		return "ShowUsersNews [uccid=" + uccid + ", uname=" + uname
				+ ", nuser=" + nuser + ", ncontent=" + ncontent + ", ndate="
				+ ndate + ", ntype=" + ntype + "]";
	}
}
