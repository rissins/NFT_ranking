package com.github.teamdon.teamdon.utils.htmlcrawling;

import com.github.teamdon.teamdon.utils.KomoranBuilder;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaturalLanguageProcessing {


	public List<String> analyseKorean(List<String> context) {

		List<String> result = new ArrayList<>();

		for (String sentence : context) {
			if(sentence.isBlank()) continue;
			KomoranResult analyzeResultList = KomoranBuilder.komoran.analyze(sentence);
			List<Token> tokenList = analyzeResultList.getTokenList();
			for (Token token : tokenList) {
				// 명사일 경우만 return NNG : 일반명사 , NNP : 고유명사, SL : 외국어
				if (token.getPos().equals("NNG") || token.getPos().equals("NNP") || token.getPos().equals("SL")) {
					// 소문자 -> 대문자
					result.add(token.getMorph().toUpperCase());
					// System.out.format("(%2d, %2d) %s/%s\n", token.getBeginIndex(),
					// token.getEndIndex(), token.getMorph(), token.getPos());
				}
			}
		}
		return result;
	}
}
