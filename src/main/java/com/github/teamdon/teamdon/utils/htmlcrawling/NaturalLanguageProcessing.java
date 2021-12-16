package com.github.teamdon.teamdon.utils.htmlcrawling;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaturalLanguageProcessing {

	public List<String> analyseKorean(List<String> context) {

		List<String> result = new ArrayList<>();

		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		for (String sentence : context) {
			KomoranResult analyzeResultList = komoran.analyze(sentence);
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
