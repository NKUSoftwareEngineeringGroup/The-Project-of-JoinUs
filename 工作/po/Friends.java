/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    Friends.java
 *作者:	   Pu Meng
 *日期:	   28/5/2015
 *文件描述:   对应数据库的Friends表，表明好友这一关系
 *修改历史:
           日期1 28/5/2015 Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Friends implements Serializable {
	//对应Friends表的数据字段
	private int relid;
	private String fuser;
	private String fuserfri;
	
	public Friends() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Friends(int relid, String fuser, String fuserfri) {
		super();
		this.relid = relid;
		this.fuser = fuser;
		this.fuserfri = fuserfri;
	}
	//对属性值的存取操作
	public int getRelid() {
		return relid;
	}
	public void setRelid(int relid) {
		this.relid = relid;
	}
	public String getFuser() {
		return fuser;
	}
	public void setFuser(String fuser) {
		this.fuser = fuser;
	}
	public String getFuserfri() {
		return fuserfri;
	}
	public void setFuserfri(String fuserfri) {
		this.fuserfri = fuserfri;
	}
	
	@Override
	public String toString() {
		return "Friends [relid=" + relid + ", fuser=" + fuser + ", fuserfri="
				+ fuserfri + "]";
	}
}
