package com.github.teamdon.teamdon.controller;

import com.github.teamdon.teamdon.service.CrawlingServiceImpl;
import com.github.teamdon.teamdon.utils.htmlcrawling.Crawler;
import com.github.teamdon.teamdon.utils.htmlcrawling.HtmlElementByClassName;
import com.github.teamdon.teamdon.utils.htmlcrawling.NaturalLanguageProcessing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HtmlCrawlingController {

	@GetMapping("/crawling")
	public String viewCrawling() {
		NaturalLanguageProcessing naturalLanguageProcessing = new NaturalLanguageProcessing();
		HtmlElementByClassName htmlElementByClassName = new HtmlElementByClassName();
		CrawlingServiceImpl crawlingService = new CrawlingServiceImpl();
		Map<String, Integer> map = new HashMap<>();
		Crawler crawler = new Crawler();
		Map<String, Integer> result = new HashMap<>();

		htmlElementByClassName.naverNewsElementByClass();


		for (int i = 1; i < 401; i += 10) {

			List<String> strings = crawler.crawlingByUrl("https://search.naver.com/search.naver?where=news&sm=tab_pge&query=nft&start="+i, htmlElementByClassName);

			//모든단어들 List에 추가
			List<String> strings1 = naturalLanguageProcessing.analyseKorean(strings.toString());


			for (String str : strings1) {
				map.merge(str, 1, Integer::sum);
			}
			// Map 출력
//        for (String key : map.keySet()) {
//            System.out.println(key + " : " + map.get(key));
//        }

			result = crawlingService.sortMapByValue(map);
		}


		return result.toString();
	}


}
