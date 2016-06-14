package com.jikexueyuan.news.model;

public class News {
	
	private String title;
	private String desc;

	
	public News(String title, String desc){
		setTitle(title);
		setDesc(desc);

	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
