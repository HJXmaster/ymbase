package com.hjx.crawler.matchUtil;

public class Param {

	private String startTime;
	private String endTime;
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String toString(){
		return "startTime="+startTime+"&endTime="+endTime;
	}
	public Param(String startTime, String endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
}
