package com.github.teamdon.teamdon.utils.htmlcrawling;

import lombok.Getter;

@Getter
public enum Site {

	NAVER("https://search.naver.com/search.naver?where=news&sm=tab_pge&query=nft&start=", "news_tit", "news_dsc"),
	GOOGLE("google.com", "LC20lb MBeuO DKV0Md", "IsZvec"),
	CHOSUN("https://www.chosun.com/nsearch/?query=nft&siteid=&sort=1&date_period=all&date_start=&date_end=&writer=&field=&emd_word=&expt_word=&opt_chk=false&app_check=0&website=www,chosun&category=&page=", "story-card-wrapper", ""),
	JOONGANG("https://www.joongang.co.kr/search/news?keyword=nft", "story-card-wrapper", ""),
	DC("https://search.dcinside.com/post/p/", "tit_txt", "link_dsc_txt"),
	FM_KOREA("https://www.fmkorea.com/index.php?act=IS&is_keyword=nft&mid=home&where=document&page=", "searchResult", "");

	private String url;
	private String titleClassName;
	private String contentClassName;

	Site(String url, String titleClassName, String contentClassName) {
		this.url = url;
		this.titleClassName = titleClassName;
		this.contentClassName = contentClassName;
	}
}
