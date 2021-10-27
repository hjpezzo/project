package br.com.harley.project.dto;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.BeanUtils;

import br.com.harley.project.entity.Project;
import br.com.harley.project.enums.Folder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddProjectRequest {

	@NotBlank
	@NotEmpty
	@ApiModelProperty(value = "Id da Secretaria", name = "secretariatId", dataType = "Long", example = "1")
	private Long secretariatId;

	@NotBlank
	@NotEmpty
	@ApiModelProperty(value = "Custo do Projeto", name = "cost", dataType = "BigDecimal", example = "10.0")
	private BigDecimal cost;

	@NotBlank
	@NotEmpty
	@ApiModelProperty(value = "Título", name = "title", dataType = "String", example = "Reforma do Posto de Saúde")
	private String title;

	@Lob
	@NotBlank
	@NotEmpty
	@ApiModelProperty(value = "Descrição", name = "description", dataType = "Lob (Texto livre)", example = "Reforma do posto situado à Avenida Brasil, para construção de 2 novos consultórios.")
	private String description;

	@Enumerated(EnumType.STRING)
	@NotBlank
	@NotEmpty
	@ApiModelProperty(value = "Pasta", name = "folder", dataType = "Enum: ex. HEALTH, SPORTS", example = "HEALTH")
	private Folder folder;
	
	public Project toEntity() {
		Project project = new Project();
		BeanUtils.copyProperties(this, project);
		return project;
	}
}
