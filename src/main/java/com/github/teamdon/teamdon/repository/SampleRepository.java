package com.github.teamdon.teamdon.repository;

import com.github.teamdon.teamdon.domain.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Long> {
}
