package com.github.teamdon.teamdon.repository;

import com.github.teamdon.teamdon.domain.Bbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsRepository extends JpaRepository<Bbs, Long> {
}
