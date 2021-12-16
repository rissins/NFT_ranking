package com.github.teamdon.teamdon.config;

import com.github.teamdon.teamdon.service.CrawlingService;
import com.github.teamdon.teamdon.utils.scheduler.RestTemplateEx;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class SchedulingConfiguration {
	// cron값 계산 : http://www.cronmaker.com/

	private int REPEAT_NUMBER = 1;
	private final RestTemplateEx templateEx;
	private final CrawlingService crawlingService;

	@Scheduled(cron = "* */5 * * * ?") // 5분마다 반복
	public void testSchedule() throws ParseException {
		log.info("repeatNumber = {} START", REPEAT_NUMBER);
		Map<String, Integer> jsonToMap = templateEx.test();
		crawlingService.save(jsonToMap);
		REPEAT_NUMBER++;
		log.info("repeatNumber = {} END", REPEAT_NUMBER);
	}

}
