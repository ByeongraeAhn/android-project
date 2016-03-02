package com.ldcc.android.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class BoardVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int bidx;
	private int mid;
	private Date bdate;
	private String btitle;
	private String bcontent;
	private int recommend;
	private int bhits;

	private List<CommentVo> comments;
	
	public BoardVo(){}

	public int getBidx() {
		return bidx;
	}
	public void setBidx(int bidx) {
		this.bidx = bidx;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getBhits() {
		return bhits;
	}
	public void setBhits(int bhits) {
		this.bhits = bhits;
	}

	public List<CommentVo> getComments() {
		return comments;
	}

	public void setComments(List<CommentVo> comments) {
		this.comments = comments;
	}


}
