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
public class FmCrawler implements Crawler {

	@Override
	public List<String> getWords() throws InterruptedException {
		List<String> crawlingTexts = new ArrayList<>();

		try {
			for (int i = 1; i <= 10; i++) {
				log.info("FM_KOREA Crawling Page = {}", i);
				Connection conn = Jsoup.connect(Site.FM_KOREA.getUrl() + i);
				Document html = conn.get();
				Elements newsTitleElements = html.getElementsByClass(Site.FM_KOREA.getTitleClassName())
						.select("li dl dt");
				Elements newsContentElements = html.getElementsByClass(Site.FM_KOREA.getTitleClassName())
						.select("li dl dd");

				for (Element element : newsTitleElements) {
					String s = element.text().replace("\n", "").replace("\t", "").replace("\r", "")
							.replaceAll("\\[(.*?)\\]", "");
					crawlingTexts.add(s);
				}
				for (Element element : newsContentElements) {
					crawlingTexts.add(element.text());
				}
				Thread.sleep(1000);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return crawlingTexts;
	}
}
