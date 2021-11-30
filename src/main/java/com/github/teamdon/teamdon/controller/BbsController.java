package com.github.teamdon.teamdon.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BbsController {

	@GetMapping("/bbs/write")
	public String writeForm() {
		return "/bbs/bbsWrite";
	}
}
