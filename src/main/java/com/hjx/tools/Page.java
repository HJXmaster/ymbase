package com.hjx.tools;

public class Page {

	private Integer start;
	private Integer num=20;
	private Integer id;
	
	@Override
	public String toString() {
		return "Page [start=" + start + ", num=" + num + ", id=" + id + "]";
	}
	public Page(){
		
	}
	public Page(Integer start,Integer id) {
		super();
		this.start = start;
		this.id = id;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
