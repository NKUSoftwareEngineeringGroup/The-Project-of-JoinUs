package com.icode.chengcheng.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Friends implements Serializable {

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
