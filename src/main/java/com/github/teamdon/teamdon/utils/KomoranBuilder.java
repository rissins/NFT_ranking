package com.github.teamdon.teamdon.utils;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import org.springframework.stereotype.Component;

@Component
public class KomoranBuilder {

	public final Komoran komoran;

	private KomoranBuilder() {
		komoran = initKomoran();
	}

	private Komoran initKomoran() {
		return new Komoran(DEFAULT_MODEL.LIGHT);
	}
}
