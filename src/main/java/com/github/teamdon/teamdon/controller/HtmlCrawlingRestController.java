package com.github.teamdon.teamdon.controller;

import com.github.teamdon.teamdon.domain.Keyword;
import com.github.teamdon.teamdon.service.CrawlingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HtmlCrawlingRestController {

	private final CrawlingService crawlingService;

	// @PostMapping("/crawling")
	// public void saveCrawlingKeywordAndType(String keyword, Integer count) {
	// Keyword buildKeyword = Keyword.builder()
	// .word(keyword)
	// .count(count)
	// .build();
	// crawlingService.save(buildKeyword);
	// log.info("CrawlingData Save Success");
	// }
	@GetMapping("/crawling/find")
	public List<Keyword> view() {
		return crawlingService.findAll();
	}
}
