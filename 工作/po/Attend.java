/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    Attend.java
 *作者:	   Pu Meng
 *日期:	   28/5/2015
 *文件描述:   对应数据库的Attend表，代表用户参与聊天室这一关系
 *修改历史:
           日期128/5/2015 Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Attend implements Serializable{
	//对应attend表的数据字段
	private int jid;
	private String juser;
	private int jroom;
	public Attend() {
		super();
	}


public Attend(int jid,String juser,int jroom){
	super();
	this.jid=jid;
	this.juser=juser;
	this.jroom=jroom;
}
//对属性值的存取操作
public int getJid(){
	return jid;
}
public void setJid(int jid){
	this.jid=jid;
}
public String getJuser(){
	return juser;
}
public void setJuser(String juser){
	this.juser=juser;
}
public int getJroom(){
	return jroom;
}
public void setJroom(int jroom){
	this.jroom=jroom;
}

public String toString(){
	return "Attend[jid="+ jid +",juser="+ juser +",jroom="+ jroom +"]";
}

}