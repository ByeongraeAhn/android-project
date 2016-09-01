package com.ldcc.android.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class VoteVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idx;
	private String teamname;
	private String title;
	private int votecount;
	
  public int getIdx() {
    return idx;
  }
  public void setIdx(int idx) {
    this.idx = idx;
  }
  public String getTeamname() {
    return teamname;
  }
  public void setTeamname(String teamname) {
    this.teamname = teamname;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public int getVotecount() {
    return votecount;
  }
  public void setVotecount(int votecount) {
    this.votecount = votecount;
  }
	


}
