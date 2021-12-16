package com.github.teamdon.teamdon.repository;

import com.github.teamdon.teamdon.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {
	List<Keyword> findByWord(String word);
}
