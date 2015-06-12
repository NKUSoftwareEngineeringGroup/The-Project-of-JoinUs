package com.icode.chengcheng.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ShowUserCommAct implements Serializable {

	private String uname;
	private String photo;
	private int cid;
	private String cuser_from;
	private int cuser_to;
	private String ccontent;
	private Date cdate;
	private int aid;
	public ShowUserCommAct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowUserCommAct(String uname, String photo, int cid,
			String cuser_from, int cuser_to, String ccontent, Date cdate,
			int aid) {
		super();
		this.uname = uname;
		this.photo = photo;
		this.cid = cid;
		this.cuser_from = cuser_from;
		this.cuser_to = cuser_to;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.aid = aid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCuser_from() {
		return cuser_from;
	}
	public void setCuser_from(String cuser_from) {
		this.cuser_from = cuser_from;
	}
	public int getCuser_to() {
		return cuser_to;
	}
	public void setCuser_to(int cuser_to) {
		this.cuser_to = cuser_to;
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
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	@Override
	public String toString() {
		return "ShowUserCommAct [uname=" + uname + ", photo=" + photo
				+ ", cid=" + cid + ", cuser_from=" + cuser_from + ", cuser_to="
				+ cuser_to + ", ccontent=" + ccontent + ", cdate=" + cdate
				+ ", aid=" + aid + "]";
	}
	
		
}
