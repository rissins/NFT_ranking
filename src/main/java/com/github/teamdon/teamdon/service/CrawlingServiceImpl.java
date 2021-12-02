package com.github.teamdon.teamdon.service;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class CrawlingServiceImpl implements CrawlingService {

	@Override
	public LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
		List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
		Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

		LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : entries) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
