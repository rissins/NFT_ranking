package com.github.teamdon.teamdon.service;

import com.github.teamdon.teamdon.domain.Keyword;
import com.github.teamdon.teamdon.dto.KeywordResponse;
import com.github.teamdon.teamdon.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

	public List<KeywordResponse> findRecentPerHour() {
		LocalDateTime startDate = LocalDateTime.now().minusHours(1);
		LocalDateTime endDate = LocalDateTime.now();
		List<Keyword> byCreatDateBetween = keywordRepository.findByCreatDateBetween(startDate, endDate);
		byCreatDateBetween.sort(Comparator.comparing(Keyword::getCount).reversed());
		Map<String, Integer> keywordMap = new HashMap<>();
		for (Keyword keyword : byCreatDateBetween) {
			if (!keywordMap.containsKey(keyword.getWord())) {
				keywordMap.put(keyword.getWord(), keyword.getCount());
			} else {
				keywordMap.replace(keyword.getWord(), keyword.getCount() + keywordMap.get(keyword.getWord()));
			}
		}

		List<KeywordResponse> keywordResponses = new ArrayList<>();
		for (Map.Entry<String, Integer> stringIntegerEntry : keywordMap.entrySet()) {
			KeywordResponse keywordResponse = new KeywordResponse(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
			keywordResponses.add(keywordResponse);
		}

		return keywordResponses;
	}
}
