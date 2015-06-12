/**************************************************
 *Copyright (c) 2015 NewDesign, All Rights Reserved.
 *文件名:    Belong.java
 *作者:	   Pu Meng
 *日期:	   28/5/2015
 *文件描述:   对应数据库的Belong表，表明活动拥有的表现这一关系
 *修改历史:
           日期1 28/5/2015 PU Meng创建.
           
 ************************************************/
package edu.newdesign.joinus.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Belong implements Serializable {
	//对应Belong表的数据字段
	private int bid;
	private int bact;
	private int btag;

	public Belong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Belong(int bid, int bact, int btag) {
		super();
		this.bid = bid;
		this.bact = bact;
		this.btag = btag;
	}
	//对属性值的存取操作
	/**
	 * @return the bid
	 */
	public int getBid() {
		return bid;
	}

	/**
	 * @param bid
	 *            the bid to set
	 */
	public void setBid(int bid) {
		this.bid = bid;
	}

	/**
	 * @return the bact
	 */
	public int getBact() {
		return bact;
	}

	/**
	 * @param bact
	 *            the bact to set
	 */
	public void setBact(int bact) {
		this.bact = bact;
	}

	/**
	 * @return the btag
	 */
	public int getBtag() {
		return btag;
	}

	/**
	 * @param btag
	 *            the btag to set
	 */
	public void setBtag(int btag) {
		this.btag = btag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Belong [bid=" + bid + ", bact=" + bact + ", btag=" + btag + "]";
	}

}
