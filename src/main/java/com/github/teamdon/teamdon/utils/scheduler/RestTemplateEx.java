package com.github.teamdon.teamdon.utils.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class RestTemplateEx {

	public Map<String, Integer> test() throws ParseException {
		log.info("RestTemplate Start");

		String url = "http://localhost:8081/crawling";
		Map<String, Integer> store = new HashMap<>();

		RestTemplate restTemplate = new RestTemplate();
		String responseEntity = restTemplate.getForObject(url, String.class);

		JSONParser jsonParser = new JSONParser();
		Object jsonObject = jsonParser.parse(responseEntity);
		JSONArray jsonArray = (JSONArray) jsonObject;

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
			store.put(String.valueOf(jsonObject1.get("word")),
					Integer.parseInt(String.valueOf(jsonObject1.get("count"))));
		}

		for (Map.Entry<String, Integer> stringIntegerEntry : store.entrySet()) {
			System.out.println("stringIntegerEntry = " + stringIntegerEntry.getKey());
			System.out.println("stringIntegerEntry = " + stringIntegerEntry.getValue());
		}
		log.info("RestTemplate End");
		return store;

	}

	public static void main(String[] args) throws ParseException {
		RestTemplateEx restTemplateEx = new RestTemplateEx();
		restTemplateEx.test();
	}

}
