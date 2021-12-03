package com.github.teamdon.teamdon.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class NFTController {

	@GetMapping("/keyword")
	public String keyword() {
		return "keyword";
	}
}
