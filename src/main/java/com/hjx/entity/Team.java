package com.hjx.entity;

public class Team {

	private int teamId;
	private String teamName;
	private String teamEnName;
	private String teamBadge;
	private String teamRegion;
	private int win;
	private int fail;
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamEnName() {
		return teamEnName;
	}
	public void setTeamEnName(String teamEnName) {
		this.teamEnName = teamEnName;
	}
	public String getTeamBadge() {
		return teamBadge;
	}
	public void setTeamBadge(String teamBadge) {
		this.teamBadge = teamBadge;
	}
	public String getTeamRegion() {
		return teamRegion;
	}
	public void setTeamRegion(String teamRegion) {
		this.teamRegion = teamRegion;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = fail;
	}
}
