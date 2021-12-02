//package com.github.teamdon.teamdon.repository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.github.teamdon.teamdon.domain.Sample;
//import java.util.Optional;
//import java.util.stream.IntStream;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class SampleRepositoryTest {
//
//	@Autowired
//	SampleRepository sampleRepository;
//
//	@Test
//	@DisplayName("Mysql Create Test")
//	void creat() {
//		IntStream.rangeClosed(1, 200).forEach(i -> {
//			Sample sample1 = Sample.builder().sample("Sample..." + i).build();
//			sampleRepository.save(sample1);
//		});
//	}
//
//	@Test
//	@DisplayName("Mysql Read Test")
//	void read() {
//
//		Long id = 10L;
//
//		Optional<Sample> result = sampleRepository.findById(id);
//
//		if (result.isPresent()) {
//			Sample sample = result.get();
//			System.out.println("sample = " + sample);
//		}
//	}
//
//	@Test
//	@DisplayName("Mysql Update Test")
//	void update() {
//
//		Sample sample = Sample.builder().id(10L).sample("Update Line").build();
//		sampleRepository.save(sample);
//	}
//
//	@Test
//	@DisplayName("Mysql Delete Test")
//	void delete() {
//
//		Long id = 10L;
//
//		sampleRepository.deleteById(id);
//	}
//}
