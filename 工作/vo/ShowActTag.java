package com.icode.chengcheng.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 51ibm
 *
 */
@SuppressWarnings("serial")
public class ShowActTag implements Serializable {
	
	private String owner_id;
	private String uname;
	private String uphoto;
	private int aid;
	private String aname;
	private Date adate;
	private String aaddress;
	private int tid;
	private String tname;
	private String acontent;
	private String atopic;
	public ShowActTag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowActTag(String owner_id, String uname, String uphoto, int aid,
			String aname, Date adate, String aaddress, int tid, String tname,
			String acontent, String atopic) {
		super();
		this.owner_id = owner_id;
		this.uname = uname;
		this.uphoto = uphoto;
		this.aid = aid;
		this.aname = aname;
		this.adate = adate;
		this.aaddress = aaddress;
		this.tid = tid;
		this.tname = tname;
		this.acontent = acontent;
		this.atopic = atopic;
	}
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUphoto() {
		return uphoto;
	}
	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Date getAdate() {
		return adate;
	}
	public void setAdate(Date adate) {
		this.adate = adate;
	}
	public String getAaddress() {
		return aaddress;
	}
	public void setAaddress(String aaddress) {
		this.aaddress = aaddress;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getAtopic() {
		return atopic;
	}
	public void setAtopic(String atopic) {
		this.atopic = atopic;
	}
	@Override
	public String toString() {
		return "ShowActTag [owner_id=" + owner_id + ", uname=" + uname
				+ ", uphoto=" + uphoto + ", aid=" + aid + ", aname=" + aname
				+ ", adate=" + adate + ", aaddress=" + aaddress + ", tid="
				+ tid + ", tname=" + tname + ", acontent=" + acontent
				+ ", atopic=" + atopic + ", getOwner_id()=" + getOwner_id()
				+ ", getUname()=" + getUname() + ", getUphoto()=" + getUphoto()
				+ ", getAid()=" + getAid() + ", getAname()=" + getAname()
				+ ", getAdate()=" + getAdate() + ", getAaddress()="
				+ getAaddress() + ", getTid()=" + getTid() + ", getTname()="
				+ getTname() + ", getAcontent()=" + getAcontent()
				+ ", getAtopic()=" + getAtopic() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
	

}
