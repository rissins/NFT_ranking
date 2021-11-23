package com.github.teamdon.teamdon.domain;

import javax.persistence.*;

@Entity
public class Sample {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private String sample = "";
}
