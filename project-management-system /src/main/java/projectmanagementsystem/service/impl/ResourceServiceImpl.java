package projectmanagementsystem.service.impl;
import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Resource;
import projectmanagementsystem.repository.ResourceRepository;
import projectmanagementsystem.service.ResourceService;

import java.util.List;
@Service
public class ResourceServiceImpl implements ResourceService{
    private ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        super();
        this.resourceRepository = resourceRepository;
    }
    @Override
    public List<Resource> getAllResources(){
        return resourceRepository.findAll();
    }
    @Override
    public Resource saveResources(Resource task){
        return resourceRepository.save(task);
    }
    @Override
    public Resource getResourceById(Long id){
        return resourceRepository.findById(id).get();
    }
    public Resource updateResource(Resource task){
        return resourceRepository.save(task);
    }
    @Override
    public void deleteResourceById(Long id){
        resourceRepository.deleteById(id);
    }
}
