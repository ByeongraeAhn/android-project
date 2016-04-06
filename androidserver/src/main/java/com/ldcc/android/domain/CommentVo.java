package com.ldcc.android.domain;

import java.io.Serializable;
import java.sql.Date;

public class CommentVo implements Serializable{
	private static final long serialVersionUID = 122L;
	private int cidx;
	private int mid;
	private int bidx;
	private String ccontent;
	private Date cdate;
	
	private MemberVo onemember;
	
  public CommentVo(){}

	public int getCidx() {
		return cidx;
	}

	public void setCidx(int cidx) {
		this.cidx = cidx;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getBidx() {
		return bidx;
	}

	public void setBidx(int bidx) {
		this.bidx = bidx;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	
  public MemberVo getOnemember() {
    return onemember;
  }

  public void setOnemember(MemberVo onemember) {
    this.onemember = onemember;
  }
	
}
