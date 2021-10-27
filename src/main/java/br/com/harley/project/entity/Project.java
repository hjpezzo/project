package br.com.harley.project.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.harley.project.enums.Folder;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Long secretariatId;

	@Column(nullable = false)
	private BigDecimal cost;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	@Lob
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Folder folder;
	
}
