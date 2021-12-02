package com.github.teamdon.teamdon.utils.htmlcrawling;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HtmlElementByClassName {

	private String titleClassName;
	private String contentClassName;

	public void naverNewsElementByClass() {
		titleClassName =  "news_tit";
		contentClassName = "news_dsc";
	}
	public void googleElementByClass() {
		titleClassName =  "LC20lb MBeuO DKV0Md";
		contentClassName = "IsZvec";
	}
}
