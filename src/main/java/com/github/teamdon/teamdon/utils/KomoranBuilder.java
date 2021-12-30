package com.github.teamdon.teamdon.utils;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;

public class KomoranBuilder {

	public static final Komoran komoran = initKomoran();

	public static Komoran initKomoran() {
		return new Komoran(DEFAULT_MODEL.FULL);
	}
}
