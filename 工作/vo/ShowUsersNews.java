package com.icode.chengcheng.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ShowUsersNews implements Serializable {
	
	private String uccid;
	private String uname;
	private String nuser;
	private String ncontent;
	private Date ndate;
	private int ntype;
	
	public ShowUsersNews() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ShowUsersNews(String uccid, String uname, String nuser,
			String ncontent, Date ndate, int ntype) {
		super();
		this.uccid = uccid;
		this.uname = uname;
		this.nuser = nuser;
		this.ncontent = ncontent;
		this.ndate = ndate;
		this.ntype = ntype;
	}
	
	public String getUccid() {
		return uccid;
	}
	public void setUccid(String uccid) {
		this.uccid = uccid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getNuser() {
		return nuser;
	}
	public void setNuser(String nuser) {
		this.nuser = nuser;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Date getNdate() {
		return ndate;
	}
	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}
	public int getNtype() {
		return ntype;
	}
	public void setNtype(int ntype) {
		this.ntype = ntype;
	}
	
	@Override
	public String toString() {
		return "ShowUsersNews [uccid=" + uccid + ", uname=" + uname
				+ ", nuser=" + nuser + ", ncontent=" + ncontent + ", ndate="
				+ ndate + ", ntype=" + ntype + "]";
	}
}
