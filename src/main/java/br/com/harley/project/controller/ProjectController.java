package br.com.harley.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.harley.project.dto.AddProjectRequest;
import br.com.harley.project.entity.Project;
import br.com.harley.project.service.ProjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Adicionar projeto", notes="Esse método adiciona um novo projeto")
    @ApiResponses(value = {
    		@ApiResponse(code = 201, message="Projeto criado"),
    		@ApiResponse(code = 500, message="Internal error")
    })
    public Project addProject(@RequestBody AddProjectRequest project) {
        return projectService.addProject(project);
    }

    @GetMapping
    public List<Project> listProjects() {
    	return projectService.listProjects();
    }
    
    @GetMapping(path = "/{id}")
    public Optional<Project> getProject(@PathVariable Long id) {
    	return projectService.getProject(id);
    }
   
}
