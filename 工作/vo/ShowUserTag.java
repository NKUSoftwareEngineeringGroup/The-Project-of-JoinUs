package com.icode.chengcheng.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ShowUserTag implements Serializable {
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
