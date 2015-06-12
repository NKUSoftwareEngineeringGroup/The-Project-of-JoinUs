/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    ShowActInIndex.java
 *作者:	  Pu Meng
 *日期:	  5/6/2015
 *文件描述:   对应Users和Activities表连接，显示用户发起的或参与的活动
 *修改历史:
           日期1 5/6/2015 Pu Meng	   创建.
          
 ************************************************/
package edu.newdesign.joinus.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ShowActInIndex implements Serializable {
     //用户账号，姓名，头像，活动编号，发起人账号，活动名称，活动主题，活动发布日期，活动类型，活动内容，活动日期，活动截止日期
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
	  //对属性值的存取操作
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
