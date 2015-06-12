package com.icode.chengcheng.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ShowUserFriend implements Serializable {
      private String uccid;
      private String fccid;
      private String fname;
      private String fgender;
      private String fphoto;
	public ShowUserFriend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowUserFriend(String uccid, String fccid, String fname,
			String fgender, String fphoto) {
		super();
		this.uccid = uccid;
		this.fccid = fccid;
		this.fname = fname;
		this.fgender = fgender;
		this.fphoto = fphoto;
	}
	public String getUccid() {
		return uccid;
	}
	public void setUccid(String uccid) {
		this.uccid = uccid;
	}
	public String getFccid() {
		return fccid;
	}
	public void setFccid(String fccid) {
		this.fccid = fccid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFgender() {
		return fgender;
	}
	public void setFgender(String fgender) {
		this.fgender = fgender;
	}
	public String getFphoto() {
		return fphoto;
	}
	public void setFphoto(String fphoto) {
		this.fphoto = fphoto;
	}
	@Override
	public String toString() {
		return "ShowUserFriend [uccid=" + uccid + ", fccid=" + fccid
				+ ", fname=" + fname + ", fgender=" + fgender + ", fphoto="
				+ fphoto + "]";
	}
      
}
