package com.ldcc.android.domain;

import java.io.Serializable;
import java.sql.Date;




public class MemberVo implements Serializable{
	
	private static final long serialVersionUID = 289783421L;
	private int mid;
	private String mname;
	private String mpwd;
	private String mloc;
	private Date mdate;
	private int mgrade;
	
	public MemberVo(){}
	
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMloc() {
		return mloc;
	}

	public void setMloc(String mloc) {
		this.mloc = mloc;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public int getMgrade() {
		return mgrade;
	}

	public void setMgrade(int mgrade) {
		this.mgrade = mgrade;
	}

	
}




