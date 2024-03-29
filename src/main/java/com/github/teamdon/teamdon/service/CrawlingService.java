package com.github.teamdon.teamdon.service;

import com.github.teamdon.teamdon.domain.Keyword;
import com.github.teamdon.teamdon.dto.KeywordResponse;
import com.github.teamdon.teamdon.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
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

	public List<KeywordResponse> findRecentPerHour(int count, int hour) {
		LocalDateTime startDate = LocalDateTime.now().minusHours(hour + 1);
		LocalDateTime endDate = LocalDateTime.now().minusHours(hour);
		List<Keyword> byCreatDateBetween = keywordRepository.findByCreatedDateBetween(startDate, endDate);
		byCreatDateBetween.sort(Comparator.comparing(Keyword::getCount).reversed());
		Map<String, Integer> keywordMap = new HashMap<>();

		// 중복값 카운트 더하기
		for (Keyword keyword : byCreatDateBetween) {
			if (!keywordMap.containsKey(keyword.getWord())) {
				keywordMap.put(keyword.getWord(), keyword.getCount());
			} else {
				keywordMap.replace(keyword.getWord(), keyword.getCount() + keywordMap.get(keyword.getWord()));
			}
		}

		// 더한 값들 Map -> List
		List<KeywordResponse> keywordResponses = new ArrayList<>();
		KeywordResponse keywordResponse;
		for (Map.Entry<String, Integer> stringIntegerEntry : keywordMap.entrySet()) {
			switch (stringIntegerEntry.getKey()) {
				case "코":
					keywordResponse = new KeywordResponse("코인", stringIntegerEntry.getValue());
					break;
				case "메타":
					keywordResponse = new KeywordResponse("메타버스", stringIntegerEntry.getValue());
					break;
				case "버스":
				case "체인":
				case "HTTPS":
				case "KR":
					continue;
				case "블록":
					keywordResponse = new KeywordResponse("블록체인", stringIntegerEntry.getValue());
					break;
				default:
					keywordResponse = new KeywordResponse(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
					break;
			}
			if (stringIntegerEntry.getKey().length() == 1 && !stringIntegerEntry.getKey().equals("돈")) continue;
			keywordResponses.add(keywordResponse);
		}
		log.info("MAX_INDEX = {}", keywordResponses.size());
		keywordResponses.sort(Comparator.comparing(KeywordResponse::getCount).reversed());
		// count개 출력
		return keywordResponses.subList(0, count);
	}
}
