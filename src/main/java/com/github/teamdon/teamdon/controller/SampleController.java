package com.github.teamdon.teamdon.controller;

import com.github.teamdon.teamdon.repository.SampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class SampleController {

	private SampleRepository sampleRepository;

	@GetMapping
	public String test(Model model) {
		model.addAttribute("text", "world");
		log.info("index.html Loading Success");
		return "index";
	}
}
