package com.icode.chengcheng.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ShowUsersAct implements Serializable {
	private String uccid;
	private String uname;
	private String aname;
	private int ptype;
	private Date pdate;
	
	public ShowUsersAct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowUsersAct(String uccid, String uname, String aname, int ptype,
			Date pdate) {
		super();
		this.uccid = uccid;
		this.uname = uname;
		this.aname = aname;
		this.ptype = ptype;
		this.pdate = pdate;
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

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public int getPtype() {
		return ptype;
	}

	public void setPtype(int ptype) {
		this.ptype = ptype;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	@Override
	public String toString() {
		return "ShowUsersAct [uccid=" + uccid + ", uname=" + uname + ", aname="
				+ aname + ", ptype=" + ptype + ", pdate=" + pdate + "]";
	}
}
