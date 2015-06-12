package com.icode.chengcheng.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Belong implements Serializable {
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
