package com.github.teamdon.teamdon.utils.htmlcrawling;

import com.github.teamdon.teamdon.utils.ChromeDriverBuilder;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChosunCrawler implements Crawler {

	@Override
	public List<String> getWords(int page) throws InterruptedException {
		List<String> crawlingTexts = new ArrayList<>();

		ChromeDriver driver = ChromeDriverBuilder.chromeDriver;

		String URL = Site.CHOSUN.getUrl() + page;
		driver.get(URL);

		Thread.sleep(1500);

		List<WebElement> storyCards = driver.findElements(By.className("story-card-wrapper"));

		for (WebElement storyCard : storyCards) {
			WebElement title = storyCard.findElement(By.className("story-card__headline-container"));
			WebElement content = storyCard.findElement(By.className("story-card__deck"));
			crawlingTexts.add(title.getText());
			crawlingTexts.add(content.getText());
		}
		return crawlingTexts;
	}
}
