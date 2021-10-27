package br.com.harley.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.harley.project.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
