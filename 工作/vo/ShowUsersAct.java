/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ShowUsersAct.java
 *作者:	  Pu Meng
 *日期:	   6/6/2015
 *文件描述:   对应Users和Activities表连接，显示用户发起的活动
 *修改历史:
           日期1 6/6/2015 Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ShowUsersAct implements Serializable {
	//用户账号，用户姓名，活动名称，活动类型，发布日期
	private String uccid;
	private String uname;
	private String aname;
	private int ptype;
	private Date pdate;
	
	public ShowUsersAct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowUsersAct(String uccid, String uname, String aname, int ptype,
			Date pdate) {
		super();
		this.uccid = uccid;
		this.uname = uname;
		this.aname = aname;
		this.ptype = ptype;
		this.pdate = pdate;
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

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public int getPtype() {
		return ptype;
	}

	public void setPtype(int ptype) {
		this.ptype = ptype;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	@Override
	public String toString() {
		return "ShowUsersAct [uccid=" + uccid + ", uname=" + uname + ", aname="
				+ aname + ", ptype=" + ptype + ", pdate=" + pdate + "]";
	}
}
