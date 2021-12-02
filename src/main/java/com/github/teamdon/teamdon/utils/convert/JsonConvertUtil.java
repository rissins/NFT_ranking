package com.github.teamdon.teamdon.utils.convert;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JsonConvertUtil {

	public void MapToJson(Map<String, Integer> map) {
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(map);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("word", jsonArray);
	}

	public void JsonToMap(JSONObject jsonObject) {
		JSONArray o = (JSONArray) jsonObject.get("word");
		HashMap<String, Integer> jsonObject1 = (HashMap<String, Integer>) o.get(0);
	}
}
