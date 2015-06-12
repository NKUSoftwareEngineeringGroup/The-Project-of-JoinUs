package com.icode.chengcheng.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Participate implements Serializable {
	private int pid;
	private String puser;
	private int pact;
	private int ptype;
	private Date pdate;

	public Participate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Participate(int pid, String puser, int pact, int ptype, Date pdate) {
		super();
		this.pid = pid;
		this.puser = puser;
		this.pact = pact;
		this.ptype = ptype;
		this.pdate = pdate;
	}

	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * @param pid
	 *            the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * @return the puser
	 */
	public String getPuser() {
		return puser;
	}

	/**
	 * @param puser
	 *            the puser to set
	 */
	public void setPuser(String puser) {
		this.puser = puser;
	}

	/**
	 * @return the pact
	 */
	public int getPact() {
		return pact;
	}

	/**
	 * @param pact
	 *            the pact to set
	 */
	public void setPact(int pact) {
		this.pact = pact;
	}

	/**
	 * @return the ptype
	 */
	public int getPtype() {
		return ptype;
	}

	/**
	 * @param ptype
	 *            the ptype to set
	 */
	public void setPtype(int ptype) {
		this.ptype = ptype;
	}

	/**
	 * @return the pdate
	 */
	public Date getPdate() {
		return pdate;
	}

	/**
	 * @param pdate
	 *            the pdate to set
	 */
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Participate [pid=" + pid + ", puser=" + puser + ", pact="
				+ pact + ", ptype=" + ptype + ", pdate=" + pdate + "]";
	}

}
