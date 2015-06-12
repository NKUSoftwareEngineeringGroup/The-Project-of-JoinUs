package com.icode.chengcheng.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Users implements Serializable {

	private String uccid;
	private String uname;
	private String upwd;
	private String ugender;
	private String uorg;
	private String uphoto;
	private Date ubirth;
	private String utele;
	private String uqq;
	private String ucity;
	private String uadd;
	private int ustate;
	private Date udate;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String uccid, String uname, String upwd, String ugender,
			String uorg, String uphoto, Date ubirth, String utele, String uqq,
			String ucity, String uadd, int ustate, Date udate) {
		super();
		this.uccid = uccid;
		this.uname = uname;
		this.upwd = upwd;
		this.ugender = ugender;
		this.uorg = uorg;
		this.uphoto = uphoto;
		this.ubirth = ubirth;
		this.utele = utele;
		this.uqq = uqq;
		this.ucity = ucity;
		this.uadd = uadd;
		this.ustate = ustate;
		this.udate = udate;
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
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public String getUorg() {
		return uorg;
	}
	public void setUorg(String uorg) {
		this.uorg = uorg;
	}
	public String getUphoto() {
		return uphoto;
	}
	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}
	public Date getUbirth() {
		return ubirth;
	}
	public void setUbirth(Date ubirth) {
		this.ubirth = ubirth;
	}
	public String getUtele() {
		return utele;
	}
	public void setUtele(String utele) {
		this.utele = utele;
	}
	public String getUqq() {
		return uqq;
	}
	public void setUqq(String uqq) {
		this.uqq = uqq;
	}
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	public String getUadd() {
		return uadd;
	}
	public void setUadd(String uadd) {
		this.uadd = uadd;
	}
	public int getUstate() {
		return ustate;
	}
	public void setUstate(int ustate) {
		this.ustate = ustate;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	@Override
	public String toString() {
		return "Users [uccid=" + uccid + ", uname=" + uname + ", upwd=" + upwd
				+ ", ugender=" + ugender + ", uorg=" + uorg + ", uphoto="
				+ uphoto + ", ubirth=" + ubirth + ", utele=" + utele + ", uqq="
				+ uqq + ", ucity=" + ucity + ", uadd=" + uadd + ", ustate="
				+ ustate + ", udate=" + udate + ", getUccid()=" + getUccid()
				+ ", getUname()=" + getUname() + ", getUpwd()=" + getUpwd()
				+ ", getUgender()=" + getUgender() + ", getUorg()=" + getUorg()
				+ ", getUphoto()=" + getUphoto() + ", getUbirth()="
				+ getUbirth() + ", getUtele()=" + getUtele() + ", getUqq()="
				+ getUqq() + ", getUcity()=" + getUcity() + ", getUadd()="
				+ getUadd() + ", getUstate()=" + getUstate() + ", getUdate()="
				+ getUdate() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	@Override
    public boolean equals(Object o){
		if(o==this)
			return true;
		if(!(o instanceof Users))
			return false;
		Users user = (Users)o;
		return  user.getUccid().equals(this.getUccid());
	}
	@Override
	public int hashCode(){
		return this.ugender.hashCode()*17+this.uccid.hashCode()*37+this.uname.hashCode()*97;
		
	}
	
	
}
