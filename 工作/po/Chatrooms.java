package com.icode.chengcheng.po;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Chatrooms implements Serializable {
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
