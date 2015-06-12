/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:     Activities.java
 *作者:	   Pu Meng
 *日期:	   28/5/2015
 *文件描述:   对应数据库的activities表，代表活动
 *修改历史:
           日期1 28/5/2015 Pu Meng	   创建.
           
 ************************************************/
package edu.newdesign.joinus.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Activities implements Serializable {
	//对应activities表的数据字段
	private int aid;
	private String owner_id;
	private Date adeadline;
	private Date adate;
	private String aaddress;
	private int amax_num;
	private int amin_num;
	private int acurr_num;
	private String acontent;
	private String atopic;
	private String astate;
	private String aresid;
	private int aproise_num;
	private int ashare_num;
	private int acomm_num;
	private int atype;
	private String aname;
	private int avisit_num;
	
	public Activities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activities(int aid, String owner_id, Date adeadline, Date adate,
			String aaddress, int amax_num, int amin_num, int acurr_num,
			String acontent, String atopic, String astate, String aresid,
			int aproise_num, int ashare_num, int acomm_num, int atype,
			String aname, int avisit_num) {
		super();
		this.aid = aid;
		this.owner_id = owner_id;
		this.adeadline = adeadline;
		this.adate = adate;
		this.aaddress = aaddress;
		this.amax_num = amax_num;
		this.amin_num = amin_num;
		this.acurr_num = acurr_num;
		this.acontent = acontent;
		this.atopic = atopic;
		this.astate = astate;
		this.aresid = aresid;
		this.aproise_num = aproise_num;
		this.ashare_num = ashare_num;
		this.acomm_num = acomm_num;
		this.atype = atype;
		this.aname = aname;
		this.avisit_num = avisit_num;
	}
    //对属性值的存取操作
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

	public Date getAdeadline() {
		return adeadline;
	}

	public void setAdeadline(Date adeadline) {
		this.adeadline = adeadline;
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

	public int getAmax_num() {
		return amax_num;
	}

	public void setAmax_num(int amax_num) {
		this.amax_num = amax_num;
	}

	public int getAmin_num() {
		return amin_num;
	}

	public void setAmin_num(int amin_num) {
		this.amin_num = amin_num;
	}

	public int getAcurr_num() {
		return acurr_num;
	}

	public void setAcurr_num(int acurr_num) {
		this.acurr_num = acurr_num;
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

	public String getAstate() {
		return astate;
	}

	public void setAstate(String astate) {
		this.astate = astate;
	}

	public String getAresid() {
		return aresid;
	}

	public void setAresid(String aresid) {
		this.aresid = aresid;
	}

	public int getAproise_num() {
		return aproise_num;
	}

	public void setAproise_num(int aproise_num) {
		this.aproise_num = aproise_num;
	}

	public int getAshare_num() {
		return ashare_num;
	}

	public void setAshare_num(int ashare_num) {
		this.ashare_num = ashare_num;
	}

	public int getAcomm_num() {
		return acomm_num;
	}

	public void setAcomm_num(int acomm_num) {
		this.acomm_num = acomm_num;
	}

	public int getAtype() {
		return atype;
	}

	public void setAtype(int atype) {
		this.atype = atype;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public int getAvisit_num() {
		return avisit_num;
	}

	public void setAvisit_num(int avisit_num) {
		this.avisit_num = avisit_num;
	}

	@Override
	public String toString() {
		return "Activities [aid=" + aid + ", owner_id=" + owner_id
				+ ", adeadline=" + adeadline + ", adate=" + adate
				+ ", aaddress=" + aaddress + ", amax_num=" + amax_num
				+ ", amin_num=" + amin_num + ", acurr_num=" + acurr_num
				+ ", acontent=" + acontent + ", atopic=" + atopic + ", astate="
				+ astate + ", aresid=" + aresid + ", aproise_num="
				+ aproise_num + ", ashare_num=" + ashare_num + ", acomm_num="
				+ acomm_num + ", atype=" + atype + ", aname=" + aname
				+ ", avisit_num=" + avisit_num + "]";
	}

	
}
