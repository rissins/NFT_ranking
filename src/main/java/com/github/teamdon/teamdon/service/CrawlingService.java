package com.github.teamdon.teamdon.service;

import com.github.teamdon.teamdon.domain.Keyword;
import com.github.teamdon.teamdon.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CrawlingService {

	private final KeywordRepository keywordRepository;

	public LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
		List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
		Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

		LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : entries) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	public List<Keyword> findAll() {
		return keywordRepository.findAll();
	}

	public void save(Map<String, Integer> map) {
		for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
			keywordRepository.save(
					Keyword.builder().word(stringIntegerEntry.getKey()).count(stringIntegerEntry.getValue()).build());
		}
	}
}
