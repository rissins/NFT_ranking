package com.github.teamdon.teamdon.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "keyword")
@EntityListeners(AuditingEntityListener.class)
public class Keyword {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "word")
	@NotNull
	private String word;

	@Column(name = "count")
	@NotNull
	private Integer count;

	@CreatedDate
	private LocalDateTime createdDate;
}
