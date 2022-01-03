package com.github.teamdon.teamdon.utils;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import org.springframework.stereotype.Component;

@Component
public class KomoranBuilder {

	public final Komoran komoran;

	public KomoranBuilder() {
		komoran = initKomoran();
	}

	public Komoran initKomoran() {
		return new Komoran(DEFAULT_MODEL.LIGHT);
	}
}
