package com.github.teamdon.teamdon.service;

import java.util.LinkedHashMap;
import java.util.Map;

public interface CrawlingService {

	LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map);
}
