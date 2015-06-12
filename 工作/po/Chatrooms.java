/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    Chatrooms.java
 *作者:	  Pu Meng
 *日期:	   28/5/2015
 *文件描述:   对应数据库的Chatrooms表，表明聊天室这一实体
 *修改历史:
           日期1 28/5/2015 Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.po;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Chatrooms implements Serializable {
	//对应chatrooms表的数据字段
	private int rid;
	private String rname;
	private Date rdate;
	private int rtype;
	public Chatrooms(){
		super();
}
	public Chatrooms(int rid, String rname,Date rdate,int rtype){
		super();
		this.rid=rid;
		this.rname=rname;
		this.rdate=rdate;
		this.rtype=rtype;
	}
	//对属性值的存取操作
	public int getRid(){
		return rid;
	}
	public void setRid(int rid){
		this.rid=rid;
	}
	public String getRname(){
		return rname;
	}
	public void setRname(String rname){
		this.rname=rname;
	}
	public Date getRdate(){
		return rdate;
	}
	public void setRdate(Date rdate){
		this.rdate=rdate;
	}
	public int getRtype(){
		return rtype;
	}
	public void setRtype(int rtype){
		this.rtype=rtype;
	}
	public String toString(){
		return "Chatrooms[rid="+ rid +",rname="+ rname +",rdate="+ rdate +",rtype="+ rtype +",]";
	}

}
