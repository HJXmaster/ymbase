package com.hjx.entity;

public class News {

	private Integer newsId;
	private String newsTitle;
	private String newsPublisher;
	private String newsPublishTime;
	private String newsContext;
	private String newsPic;
	
	
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsTitle=" + newsTitle
				+ ", newsPublisher=" + newsPublisher + ", newsPublishTime="
				+ newsPublishTime + ", newsContext=" + newsContext
				+ ", newsPic=" + newsPic + "]";
	}
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsPublisher() {
		return newsPublisher;
	}
	public void setNewsPublisher(String newsPublisher) {
		this.newsPublisher = newsPublisher;
	}
	public String getNewsPublishTime() {
		return newsPublishTime;
	}
	public void setNewsPublishTime(String newsPublishTime) {
		this.newsPublishTime = newsPublishTime;
	}
	public String getNewsContext() {
		return newsContext;
	}
	public void setNewsContext(String newsContext) {
		this.newsContext = newsContext;
	}
	public String getNewsPic() {
		return newsPic;
	}
	public void setNewsPic(String newsPic) {
		this.newsPic = newsPic;
	}
	
}
