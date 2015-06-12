package com.icode.chengcheng.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ShowUserChatrooms implements Serializable {

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
