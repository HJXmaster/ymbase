package com.hjx.entity;

public class Topic {

	private Integer topicId;
	private String topicTitle;
	private String topicPublisher;
	private String topicPublishTime;
	private String topicContext;
	private Integer topicReplyNum;
	private Integer topicReadNum;
	private String topicReplyTime;
	private String username;
	
	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicTitle=" + topicTitle
				+ ", topicPublisher=" + topicPublisher + ", topicPublishTime="
				+ topicPublishTime + ", topicContext=" + topicContext
				+ ", topicReplyNum=" + topicReplyNum + ", topicReadNum="
				+ topicReadNum + ", topicReplyTime=" + topicReplyTime + "]";
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getTopicTitle() {
		return topicTitle;
	}
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
	public String getTopicPublisher() {
		return topicPublisher;
	}
	public void setTopicPublisher(String topicPublisher) {
		this.topicPublisher = topicPublisher;
	}
	public String getTopicPublishTime() {
		return topicPublishTime;
	}
	public void setTopicPublishTime(String topicPublishTime) {
		this.topicPublishTime = topicPublishTime;
	}
	public String getTopicContext() {
		return topicContext;
	}
	public void setTopicContext(String topicContext) {
		this.topicContext = topicContext;
	}
	public Integer getTopicReplyNum() {
		return topicReplyNum;
	}
	public void setTopicReplyNum(Integer topicReplyNum) {
		this.topicReplyNum = topicReplyNum;
	}
	public Integer getTopicReadNum() {
		return topicReadNum;
	}
	public void setTopicReadNum(Integer topicReadNum) {
		this.topicReadNum = topicReadNum;
	}
	public String getTopicReplyTime() {
		return topicReplyTime;
	}
	public void setTopicReplyTime(String topicReplyTime) {
		this.topicReplyTime = topicReplyTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
