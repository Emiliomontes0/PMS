package projectmanagementsystem.service;
import projectmanagementsystem.entity.Requirement;
import projectmanagementsystem.entity.Resource;

import java.util.List;

public interface ResourceService {
    List<Resource> getAllResources();
    Resource saveResources(Resource resource);
    Resource getResourceById(Long id);
    Resource updateResource(Resource resource);
    void deleteResourceById(Long id);
    List<Resource> getAllResourcesById(Long id);
}
