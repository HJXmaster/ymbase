package com.hjx.entity;

import java.util.Date;

/**
 * 
 * @author pc
 * 赛事表，主队客队的比赛信息
 */
public class Game {

	private int gameId;
	private Date time;
	private int homeTeam;
	private int visitTeam;
	private int homeScore;
	private int visitScore;
	private String liveAddress;
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(int homeTeam) {
		this.homeTeam = homeTeam;
	}
	public int getVisitTeam() {
		return visitTeam;
	}
	public void setVisitTeam(int visitTeam) {
		this.visitTeam = visitTeam;
	}
	public int getHomeScore() {
		return homeScore;
	}
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	public int getVisitScore() {
		return visitScore;
	}
	public void setVisitScore(int visitScore) {
		this.visitScore = visitScore;
	}
	public String getLiveAddress() {
		return liveAddress;
	}
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	
}
