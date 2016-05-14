package com.dianzishangwu.yihunli.domain.article;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Resource  implements Serializable{

	 private String url;
	 
	 private String type;  //图片，视频
	 
	 private String introduce;

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
