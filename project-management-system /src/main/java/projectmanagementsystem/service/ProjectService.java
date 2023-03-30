package projectmanagementsystem.service;

import projectmanagementsystem.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();
    Project saveProjects(Project project);
    Project getProjectById(Long id);
    Project updateProject(Project project);
    void deleteProjectById(Long id);
}
