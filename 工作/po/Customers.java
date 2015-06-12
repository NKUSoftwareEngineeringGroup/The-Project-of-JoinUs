package edu.newdesign.joinus.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Customers implements Serializable {

	private int cusid;
	private String cusaccount;
	private String cuspassword;
	private String cusemail;
	private Date regdate;
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customers(int cusid, String cusaccount, String cuspassword,
			String cusemail, Date regdate) {
		super();
		this.cusid = cusid;
		this.cusaccount = cusaccount;
		this.cuspassword = cuspassword;
		this.cusemail = cusemail;
		this.regdate = regdate;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public String getCusaccount() {
		return cusaccount;
	}
	public void setCusaccount(String cusaccount) {
		this.cusaccount = cusaccount;
	}
	public String getCuspassword() {
		return cuspassword;
	}
	public void setCuspassword(String cuspassword) {
		this.cuspassword = cuspassword;
	}
	public String getCusemail() {
		return cusemail;
	}
	public void setCusemail(String cusemail) {
		this.cusemail = cusemail;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Customers [cusid=" + cusid + ", cusaccount=" + cusaccount
				+ ", cuspassword=" + cuspassword + ", cusemail=" + cusemail
				+ ", regdate=" + regdate + "]";
	}
	
	
}
