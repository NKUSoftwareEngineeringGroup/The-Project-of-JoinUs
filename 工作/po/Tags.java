package com.icode.chengcheng.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Tags implements Serializable {
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
