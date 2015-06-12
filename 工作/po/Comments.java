package com.icode.chengcheng.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Comments implements Serializable {
	private int cid;
	private int cact;
	private String cuser_from;
	private String ccontent;
	private Date cdate;
	private int cuser_to;

	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comments(int cid, int cact, String cuser_from, String ccontent,
			Date cdate, int cuser_to) {
		super();
		this.cid = cid;
		this.cact = cact;
		this.cuser_from = cuser_from;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.cuser_to = cuser_to;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCact() {
		return cact;
	}

	public void setCact(int cact) {
		this.cact = cact;
	}

	public String getCuser_from() {
		return cuser_from;
	}

	public void setCuser_from(String cuser_from) {
		this.cuser_from = cuser_from;
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

	public int getCuser_to() {
		return cuser_to;
	}

	public void setCuser_to(int cuser_to) {
		this.cuser_to = cuser_to;
	}

	@Override
	public String toString() {
		return "Comments [cid=" + cid + ", cact=" + cact + ", cuser_from="
				+ cuser_from + ", ccontent=" + ccontent + ", cdate=" + cdate
				+ ", cuser_to=" + cuser_to + "]";
	}
	
}
