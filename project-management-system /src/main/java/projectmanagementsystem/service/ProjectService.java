package projectmanagementsystem.service;

import projectmanagementsystem.entity.Project;
import projectmanagementsystem.entity.Requirement;

import java.util.List;
//THE PURPOSE OF THIS FILE IS TO CREATE FUNCTIONS THAT ARE USE BETWEEN THE USER AND MIDDLEWARE FOR BETTER CONTROL OF INFORMATION
//THIS FILE CAN ALSO BE USE TO CREATE NEW METHOD THAT ARE NEED AND AREN'T AUTO GENERATED THROUGH LIBRARYS
public interface ProjectService {
    List<Project> getAllProjects();
    Project saveProjects(Project project);
    Project getProjectById(Long id);
    Project updateProject(Project project);
    void deleteProjectById(Long id);
}
