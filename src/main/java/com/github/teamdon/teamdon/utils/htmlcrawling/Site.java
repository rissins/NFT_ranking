package com.github.teamdon.teamdon.utils.htmlcrawling;

import lombok.Getter;

@Getter
public enum Site {

	NAVER("https://search.naver.com/search.naver?where=news&sm=tab_pge&query=nft&start=", "news_tit", "news_dsc"),
	GOOGLE("google.com", "LC20lb MBeuO DKV0Md", "IsZvec");

	private String url;
	private String titleClassName;
	private String contentClassName;

	Site(String url, String titleClassName, String contentClassName) {
		this.url = url;
		this.titleClassName = titleClassName;
		this.contentClassName = contentClassName;
	}
}
