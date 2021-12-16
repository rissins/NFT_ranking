package com.github.teamdon.teamdon.utils.htmlcrawling;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class DCCrawler implements Crawler {

	@Override
	public List<String> getWords() {
		List<String> crawlingTexts = new ArrayList<>();

		try {
			for (int i = 1; i < 11; i++) {
				log.info("DC Crawling Page = {}", i);
				Connection conn = Jsoup.connect(Site.DC.getUrl() + i + "/sort/latest/q/nft");
				Document html = conn.get();
				Elements newsTitleElements = html.getElementsByClass(Site.DC.getTitleClassName());
				Elements newsContentElements = html.getElementsByClass(Site.DC.getContentClassName()).not(".dsc_sub");

				for (Element element : newsTitleElements) {
					crawlingTexts.add(element.text());
				}

				for (Element element : newsContentElements) {
					crawlingTexts.add(element.text());
				}
				Thread.sleep(500);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return crawlingTexts;
	}
}
