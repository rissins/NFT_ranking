package com.github.teamdon.teamdon.controller;

import com.github.teamdon.teamdon.repository.SampleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

	private SampleRepository sampleRepository;

	@GetMapping
	public String test(Model model) {
		model.addAttribute("text", "world");
		System.out.println("SampleController.test");
		return "index";
	}

}
