package com.icode.chengcheng.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Attend implements Serializable{
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