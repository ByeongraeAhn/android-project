package com.ldcc.android.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class VoteVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idx;
	private String teamname;
	private String title;
	private int votecount;
	private String name;
	private int question;
	private int selected;
	private int delay;
	private int correct;
	private int delaysum;
	private int correctsum;
	private String incorrect;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public int getDelaysum() {
		return delaysum;
	}

	public void setDelaysum(int delaysum) {
		this.delaysum = delaysum;
	}

	public int getCorrectsum() {
		return correctsum;
	}

	public void setCorrectsum(int correctsum) {
		this.correctsum = correctsum;
	}

	public String getIncorrect() {
		return incorrect;
	}

	public void setIncorrect(String incorrect) {
		this.incorrect = incorrect;
	}

}
