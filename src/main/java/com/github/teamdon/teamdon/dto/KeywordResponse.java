package com.github.teamdon.teamdon.dto;

import lombok.Data;

@Data
public class KeywordResponse {
	private String word;
	private Integer count;

	public KeywordResponse(String word, Integer count) {
		this.word = word;
		this.count = count;
	}
}
