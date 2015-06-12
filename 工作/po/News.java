package com.icode.chengcheng.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class News implements Serializable {
	private int nid;
	private String nuser;
	private String nfrom;
	private int ntype;
	private String ncontent;
	private Date ndate;

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(int nid, String nuser, String nfrom, int ntype,
			String ncontent, Date ndate) {
		super();
		this.nid = nid;
		this.nuser = nuser;
		this.nfrom = nfrom;
		this.ntype = ntype;
		this.ncontent = ncontent;
		this.ndate = ndate;
	}

	/**
	 * @return the nid
	 */
	public int getNid() {
		return nid;
	}

	/**
	 * @param nid
	 *            the nid to set
	 */
	public void setNid(int nid) {
		this.nid = nid;
	}

	/**
	 * @return the nuser
	 */
	public String getNuser() {
		return nuser;
	}

	/**
	 * @param nuser
	 *            the nuser to set
	 */
	public void setNuser(String nuser) {
		this.nuser = nuser;
	}

	/**
	 * @return the nfrom
	 */
	public String getNfrom() {
		return nfrom;
	}

	/**
	 * @param nfrom
	 *            the nfrom to set
	 */
	public void setNfrom(String nfrom) {
		this.nfrom = nfrom;
	}

	/**
	 * @return the ntype
	 */
	public int getNtype() {
		return ntype;
	}

	/**
	 * @param ntype
	 *            the ntype to set
	 */
	public void setNtype(int ntype) {
		this.ntype = ntype;
	}

	/**
	 * @return the ncontent
	 */
	public String getNcontent() {
		return ncontent;
	}

	/**
	 * @param ncontent
	 *            the ncontent to set
	 */
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	/**
	 * @return the ndate
	 */
	public Date getNdate() {
		return ndate;
	}

	/**
	 * @param ndate
	 *            the ndate to set
	 */
	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "News [nid=" + nid + ", nuser=" + nuser + ", nfrom=" + nfrom
				+ ", ntype=" + ntype + ", ncontent=" + ncontent + ", ndate="
				+ ndate + "]";
	}

}
