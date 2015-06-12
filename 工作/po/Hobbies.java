package com.icode.chengcheng.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Hobbies implements Serializable {
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
