package com.icode.chengcheng.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Resources implements Serializable {
	
	private int resid;
	private int restype;
	private String resurl;
	public Resources() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Resources(int resid, int restype, String resurl) {
		super();
		this.resid = resid;
		this.restype = restype;
		this.resurl = resurl;
	}
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public int getRestype() {
		return restype;
	}
	public void setRestype(int restype) {
		this.restype = restype;
	}
	public String getResurl() {
		return resurl;
	}
	public void setResurl(String resurl) {
		this.resurl = resurl;
	}
	@Override
	public String toString() {
		return "resources [resid=" + resid + ", restype=" + restype
				+ ", resurl=" + resurl + ", getResid()=" + getResid()
				+ ", getRestype()=" + getRestype() + ", getResurl()="
				+ getResurl() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
