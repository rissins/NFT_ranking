package com.github.teamdon.teamdon.utils.htmlcrawling;

import java.util.*;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;
import org.springframework.stereotype.Component;

@Component
public class NaturalLanguageProcessing {

	private final List<String> NNs = new ArrayList<>();

	public List<String> analyseKorean(String context) {
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		KomoranResult analyzeResultList = komoran.analyze(context);
		List<Token> tokenList = analyzeResultList.getTokenList();
		for (Token token : tokenList) {
			// 명사일 경우만 return
			if (token.getPos().equals("NNG") || token.getPos().equals("NNP")) {
				NNs.add(token.getMorph());
				// System.out.format("(%2d, %2d) %s/%s\n", token.getBeginIndex(),
				// token.getEndIndex(), token.getMorph(), token.getPos());
			}
		}
		return NNs;
	}
}
