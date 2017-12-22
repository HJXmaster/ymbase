package com.hjx.entity;

public class NewsReply {
	private Integer nrId;
	private Integer newsId;
	private String nrUid;
	private Integer nrReplyId;
	private String nrTime;
	private String nrContext;
	private Integer nrSupport;
	private String username;
	private String title;
	
	public Integer getNrId() {
		return nrId;
	}
	public void setNrId(Integer nrId) {
		this.nrId = nrId;
	}
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public String getNrUid() {
		return nrUid;
	}
	public void setNrUid(String nrUid) {
		this.nrUid = nrUid;
	}
	public Integer getNrReplyId() {
		return nrReplyId;
	}
	public void setNrReplyId(Integer nrReplyId) {
		this.nrReplyId = nrReplyId;
	}
	public String getNrTime() {
		return nrTime;
	}
	public void setNrTime(String nrTime) {
		this.nrTime = nrTime;
	}
	public String getNrContext() {
		return nrContext;
	}
	public void setNrContext(String nrContext) {
		this.nrContext = nrContext;
	}
	public Integer getNrSupport() {
		return nrSupport;
	}
	public void setNrSupport(Integer nrSupport) {
		this.nrSupport = nrSupport;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
