/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    Hobbies.java
 *作者:	   Pu Meng
 *日期:	   28/5/2015
 *文件描述:   对应数据库的Hobbies表，表明用户拥有标签这一关系
 *修改历史:
           日期1 28/5/2015 Pu Meng	   创建.
          
 ************************************************/
package edu.newdesign.joinus.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Hobbies implements Serializable {
	//对应Hobbies表的数据字段
	private int hid;
	private int htag;
	private String huser;
	public Hobbies(){
		super();
	}
	public Hobbies(int hid,int htag,String huser){
		super();
		this.hid=hid;
		this.htag=htag;
		this.huser=huser;		
	}
	//对属性值的存取操作
	public int getHid(){
		return hid;
	}
	public void setHid(int hid){
		this.hid=hid;
	}
	public int getHtag(){
		return htag;
	}
	public void setHtag(int htag){
		this.htag=htag;
	}
	public String getHuser(){
		return huser;
	}
	public void setHuser(String huser){
		this.huser=huser;
	}
	public String toString(){
		return "Hobbies[hid="+ hid +",htag="+ htag +",huser="+ huser +"]";
	}
}
