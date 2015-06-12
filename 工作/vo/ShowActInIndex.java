package com.icode.chengcheng.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ShowActInIndex implements Serializable {
     
      private String uccid;
      private String uname;
      private String uphoto;
      private int aid;
      private String owner_id;
      private String aname;
      private String atopic;
      private Date pdate;
      private int ptype;
      private String acontent;
      private Date adate;
      private Date adeadline;
	  public ShowActInIndex() {
		super();
		// TODO Auto-generated constructor stub
	 }
	public ShowActInIndex(String uccid, String uname, String uphoto, int aid,
			String owner_id, String aname, String atopic, Date pdate,
			int ptype, String acontent, Date adate, Date adeadline) {
		super();
		this.uccid = uccid;
		this.uname = uname;
		this.uphoto = uphoto;
		this.aid = aid;
		this.owner_id = owner_id;
		this.aname = aname;
		this.atopic = atopic;
		this.pdate = pdate;
		this.ptype = ptype;
		this.acontent = acontent;
		this.adate = adate;
		this.adeadline = adeadline;
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
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAtopic() {
		return atopic;
	}
	public void setAtopic(String atopic) {
		this.atopic = atopic;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getPtype() {
		return ptype;
	}
	public void setPtype(int ptype) {
		this.ptype = ptype;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public Date getAdate() {
		return adate;
	}
	public void setAdate(Date adate) {
		this.adate = adate;
	}
	public Date getAdeadline() {
		return adeadline;
	}
	public void setAdeadline(Date adeadline) {
		this.adeadline = adeadline;
	}
	@Override
	public String toString() {
		return "ShowActInIndex [uccid=" + uccid + ", uname=" + uname
				+ ", uphoto=" + uphoto + ", aid=" + aid + ", owner_id="
				+ owner_id + ", aname=" + aname + ", atopic=" + atopic
				+ ", pdate=" + pdate + ", ptype=" + ptype + ", acontent="
				+ acontent + ", adate=" + adate + ", adeadline=" + adeadline
				+ "]";
	}
	
	
}
