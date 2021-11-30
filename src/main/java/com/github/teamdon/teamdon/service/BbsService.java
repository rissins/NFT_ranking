package com.github.teamdon.teamdon.service;

import com.github.teamdon.teamdon.domain.Bbs;
import com.github.teamdon.teamdon.repository.BbsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BbsService {

	@Autowired
	private final BbsRepository bbsRepository;

	public void save(Bbs bbs) {
		bbsRepository.save(bbs);
	}

	public void delete(Bbs id) {
		bbsRepository.delete(id);
	}

	public List<Bbs> findAll() {
		return bbsRepository.findAll();
	}

	public Optional<Bbs> findById(Long searchId) {
		return bbsRepository.findById(searchId);
	}
}
