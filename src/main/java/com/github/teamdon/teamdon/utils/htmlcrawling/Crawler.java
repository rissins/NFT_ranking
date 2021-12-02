package com.github.teamdon.teamdon.utils.htmlcrawling;

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
public class Crawler {

	public List<String> crawlingByUrl(String url, HtmlElementByClassName htmlElementByClassName) {

		List<String> crawlingTexts = new ArrayList<>();
		htmlElementByClassName.naverNewsElementByClass();

		try {
			Connection conn = Jsoup.connect(url);
			Document html = conn.get();
			Elements newsTitleElements = html.getElementsByClass(htmlElementByClassName.getTitleClassName());
			Elements newsContentElements = html.getElementsByClass(htmlElementByClassName.getContentClassName());

			for (Element element : newsTitleElements) {
				crawlingTexts.add(element.text());
			}

			for (Element element : newsContentElements) {
				crawlingTexts.add(element.text());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return crawlingTexts;
	}

}
