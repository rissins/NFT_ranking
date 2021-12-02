package com.github.teamdon.teamdon.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "test")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sample {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "sample")
	private String sample = "";
}
