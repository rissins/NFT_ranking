package com.github.teamdon.teamdon.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "bbs")
@EntityListeners(AuditingEntityListener.class)
public class Bbs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;


	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@CreatedDate
	private LocalDateTime creatDate;

	@LastModifiedDate
	private LocalDateTime lastModifyData;


}
