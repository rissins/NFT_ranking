package com.github.teamdon.teamdon.controller;

import com.github.teamdon.teamdon.domain.Bbs;
import com.github.teamdon.teamdon.service.BbsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/bbs")
public class BbsRestController {

	@Autowired
	private BbsService bbsService;

	@GetMapping
	public List<Bbs> jsonBbs() {
		log.info("Bbs List Loading Success");
		return bbsService.findAll();
	}

	@GetMapping("/{searchId}")
	public Bbs searchBbs(@PathVariable Long searchId) {
		log.info("Bbs Search Success");
		return bbsService.findById(searchId).get();
	}

	@PostMapping
	public void writeBbs(String title, String content) {
		final Bbs bbsContent = Bbs.builder()
				.title(title)
				.content(content)
				.build();
		bbsService.save(bbsContent);
		log.info("Bbs write success");
	}

	@DeleteMapping("/{id}")
	public void deleteBbs(@PathVariable Bbs id) {
		bbsService.delete(id);
		log.info("Bbs Delete Success");
	}


}
