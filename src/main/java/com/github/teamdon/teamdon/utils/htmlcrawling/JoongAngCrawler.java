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
public class JoongAngCrawler implements Crawler {

	@Override
	public List<String> getWords(int page) throws InterruptedException {
		List<String> crawlingTexts = new ArrayList<>();

		ChromeDriver driver = ChromeDriverBuilder.chromeDriver;

		String URL = Site.JOONGANG.getUrl();
		driver.get(URL);

		Thread.sleep(1500);

		List<WebElement> storyCards = driver.findElement(By.className("story_list")).findElements(By.className("card"));

		for (WebElement storyCard : storyCards) {
			WebElement title = storyCard.findElement(By.className("headline"));
			WebElement content = storyCard.findElement(By.className("description"));
			crawlingTexts.add(title.getText());
			crawlingTexts.add(content.getText());
		}

		return crawlingTexts;
	}
}
