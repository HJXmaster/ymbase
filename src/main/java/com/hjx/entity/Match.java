package com.hjx.entity;

import java.util.Date;

/**
 * 
 * @author pc
 * 赛事表，主队客队的比赛信息
 */
public class Match {

	private int matchId;
	private String matchDesc;
	private int leftId;
	private int leftGoal;
	private int rightId;
	private int rightGoal;
	private String startTime;
	private String quarter;
	private String quarterTime;
	private String ifEnd;
	
	private Team leftTeam;
	private Team rightTeam;
	
	
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public String getMatchDesc() {
		return matchDesc;
	}
	public void setMatchDesc(String matchDesc) {
		this.matchDesc = matchDesc;
	}
	public int getLeftId() {
		return leftId;
	}
	public void setLeftId(int leftId) {
		this.leftId = leftId;
	}
	public int getLeftGoal() {
		return leftGoal;
	}
	public void setLeftGoal(int leftGoal) {
		this.leftGoal = leftGoal;
	}
	public int getRightId() {
		return rightId;
	}
	public void setRightId(int rightId) {
		this.rightId = rightId;
	}
	public int getRightGoal() {
		return rightGoal;
	}
	public void setRightGoal(int rightGoal) {
		this.rightGoal = rightGoal;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getQuarterTime() {
		return quarterTime;
	}
	public void setQuarterTime(String quarterTime) {
		this.quarterTime = quarterTime;
	}
	public Team getLeftTeam() {
		return leftTeam;
	}
	public void setLeftTeam(Team leftTeam) {
		this.leftTeam = leftTeam;
	}
	public Team getRightTeam() {
		return rightTeam;
	}
	public void setRightTeam(Team rightTeam) {
		this.rightTeam = rightTeam;
	}
	public String getIfEnd() {
		return ifEnd;
	}
	public void setIfEnd(String ifEnd) {
		this.ifEnd = ifEnd;
	}
}
