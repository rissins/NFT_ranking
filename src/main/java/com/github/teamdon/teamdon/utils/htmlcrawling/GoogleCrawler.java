package com.github.teamdon.teamdon.utils.htmlcrawling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoogleCrawler implements Crawler {

	@Override
	public List<String> getWords(int page) {
		return List.of("구글", "구글", "구글", "구글", "구글", "구글", "구글");
	}
}
