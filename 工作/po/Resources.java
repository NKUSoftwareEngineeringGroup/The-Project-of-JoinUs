/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    Resources.java
 *作者:	   Pu Meng
 *日期:	   30/5/2015
 *文件描述:   对应数据库的Resources表，表明资源这一实体
 *修改历史:
           日期1 30/5/2015 Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Resources implements Serializable {
	//对应Resources表的数据字段
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
	//对属性值的存取操作
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
