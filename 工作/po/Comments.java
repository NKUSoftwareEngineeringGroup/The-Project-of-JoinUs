/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    Comments.java
 *作者:	   Pu Meng
 *日期:	   28/5/2015
 *文件描述:   对应数据库的Comments表，表明评论这一实体
 *修改历史:
           日期1 28/5/2015 Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Comments implements Serializable {
	//对应Comments表的数据字段
	private int cid;
	private int cact;
	private String cuser_from;
	private String ccontent;
	private Date cdate;
	private int cuser_to;

	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comments(int cid, int cact, String cuser_from, String ccontent,
			Date cdate, int cuser_to) {
		super();
		this.cid = cid;
		this.cact = cact;
		this.cuser_from = cuser_from;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.cuser_to = cuser_to;
	}
	//对属性值的存取操作
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCact() {
		return cact;
	}

	public void setCact(int cact) {
		this.cact = cact;
	}

	public String getCuser_from() {
		return cuser_from;
	}

	public void setCuser_from(String cuser_from) {
		this.cuser_from = cuser_from;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public int getCuser_to() {
		return cuser_to;
	}

	public void setCuser_to(int cuser_to) {
		this.cuser_to = cuser_to;
	}

	@Override
	public String toString() {
		return "Comments [cid=" + cid + ", cact=" + cact + ", cuser_from="
				+ cuser_from + ", ccontent=" + ccontent + ", cdate=" + cdate
				+ ", cuser_to=" + cuser_to + "]";
	}
	
}
