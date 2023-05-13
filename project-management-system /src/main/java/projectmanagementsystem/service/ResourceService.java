package projectmanagementsystem.service;
import projectmanagementsystem.entity.Requirement;
import projectmanagementsystem.entity.Resource;

import java.util.List;
//THE PURPOSE OF THIS FILE IS TO CREATE FUNCTIONS THAT ARE USE BETWEEN THE USER AND MIDDLEWARE FOR BETTER CONTROL OF INFORMATION
//THIS FILE CAN ALSO BE USE TO CREATE NEW METHOD THAT ARE NEED AND AREN'T AUTO GENERATED THROUGH LIBRARYS
public interface ResourceService {
    List<Resource> getAllResources();
    Resource saveResources(Resource resource);
    Resource getResourceById(Long id);
    Resource updateResource(Resource resource);
    void deleteResourceById(Long id);
    List<Resource> getAllResourcesById(Long id);
}
