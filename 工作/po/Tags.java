/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    Tags.java
 *作者:	  Pu Meng
 *日期:	  30/5/2015
 *文件描述:   对应数据库的Tags表，表明标签这一实体
 *修改历史:
           日期1 30/5/2015 Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Tags implements Serializable {
	//对应Tags表的数据字段
	private int tid;
	private String tname;
	public Tags(){
		super();
	}
	public Tags(int tid,String tname){
		super();
		this.tid=tid;
		this.tname=tname;
	}
	//对属性值的存取操作
	public int getTid(){
		return tid;
	}
	public void setTid(int tid){
		this.tid=tid;
	}
	public String getTname(){
		return tname;
	}
	public void setTname(String tname){
		this.tname=tname;
	}
	public String toString(){
		return"Tags[tid="+ tid +",tname="+ tname +"]";
	}

}
