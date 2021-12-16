package com.github.teamdon.teamdon.controller;

import com.github.teamdon.teamdon.dto.KeywordResponse;
import com.github.teamdon.teamdon.utils.htmlcrawling.Crawler;
import com.github.teamdon.teamdon.utils.htmlcrawling.NaturalLanguageProcessing;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HtmlCrawlingController {

	private final List<Crawler> crawlers;
	private final NaturalLanguageProcessing naturalLanguageProcessing;

	@GetMapping("/crawling")
	public List<KeywordResponse> viewCrawling() throws InterruptedException {
		long start = System.currentTimeMillis();
		List<String> words = new ArrayList<>();

		// 사이트에서 문장 가져오기
		for (Crawler crawler : crawlers) {
			long startCrawler = System.currentTimeMillis();
			List<String> crawlerWords = crawler.getWords();
			log.info(crawler.getClass().getSimpleName() + " 크롤링된 문장 수 = " + crawlerWords.size() + "개");

			words.addAll(crawlerWords);
			long endCrawler = System.currentTimeMillis();
			log.info(crawler.getClass().getSimpleName() + " 크롤링 걸린 시간 = " + (endCrawler - startCrawler) + "ms");
		}

		// 명사 토큰 분리
		List<String> tokenizedWords = naturalLanguageProcessing.analyseKorean(String.join(",", words));

		// List -> Map
		Map<String, Integer> wordAndCount = new HashMap<>();
		for (String str : tokenizedWords) {
			wordAndCount.merge(str, 1, Integer::sum);
		}

		// count 정렬
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(wordAndCount.entrySet());
		entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

		// 정렬된 map dto로 바꾸기
		List<KeywordResponse> keywordResponses = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : entryList) {
			keywordResponses.add(new KeywordResponse(entry.getKey(), entry.getValue()));
		}

		// json 형태로 출력
		long end = System.currentTimeMillis();

		log.info("크롤링 총 걸린 시간 = " + (end - start) + "ms");
		return keywordResponses;
	}
}
