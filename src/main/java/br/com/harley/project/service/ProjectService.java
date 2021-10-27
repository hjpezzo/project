package br.com.harley.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.harley.project.dto.AddProjectRequest;
import br.com.harley.project.entity.Project;
import br.com.harley.project.repository.ProjectRepository;

@Service
public class ProjectService {

	ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public Project addProject(AddProjectRequest addProjectRequest) {
		return projectRepository.save(addProjectRequest.toEntity());
	}

	public List<Project> listProjects() {
		return projectRepository.findAll();
	}
	
	public Optional<Project> getProject(Long projectId) {
		return projectRepository.findById(projectId);
	}

}
