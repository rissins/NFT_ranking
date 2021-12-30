package com.github.teamdon.teamdon.controller;

import com.github.teamdon.teamdon.domain.Keyword;
import com.github.teamdon.teamdon.dto.KeywordResponse;
import com.github.teamdon.teamdon.service.CrawlingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HtmlCrawlingRestController {

	private final CrawlingService crawlingService;

	@GetMapping("/crawling/find")
	public List<Keyword> view() {
		return crawlingService.findAll();
	}

	@GetMapping("/crawling/data")
	public List<KeywordResponse> findByMysqlPerHour(@RequestParam(defaultValue = "30") int count) {
		return crawlingService.findRecentPerHour(count);
	}
}
