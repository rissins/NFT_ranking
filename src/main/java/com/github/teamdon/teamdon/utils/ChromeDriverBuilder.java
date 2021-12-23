package com.github.teamdon.teamdon.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ChromeDriverBuilder {

//	public static final ChromeDriver chromeDriver = getChromeDriver();
//
//	private static ChromeDriver getChromeDriver() {
//		Path path = Paths.get("chromedriver");  // 현재 package의
//		System.setProperty("webdriver.chrome.driver", path.toString());
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-popup-blocking");    // 팝업 무시
//		options.addArguments("--disable-default-apps");     // 기본앱 사용안함
//		options.addArguments("--disable-gpu");
//		options.addArguments("headless");
//
//		options.addArguments("--disable-extensions");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--incognito");
//		options.addArguments("--disable-application-cache");
//		options.addArguments("--disable-dev-shm-usage");
//
//		options.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 11_1_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.96 Safari/537.36");
//
//		ChromeDriver driver = new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
//		return driver;
//	}
}
