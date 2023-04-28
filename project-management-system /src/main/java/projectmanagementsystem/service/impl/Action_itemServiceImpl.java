package projectmanagementsystem.service.impl;

import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Action_item;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.repository.ProjectRepository;
import projectmanagementsystem.repository.Action_itemRepository;
import projectmanagementsystem.service.Action_itemService;

import java.util.List;
@Service
public class Action_itemServiceImpl implements Action_itemService{
    private Action_itemRepository action_itemRepository;
    private ProjectRepository projectRepository;

    public Action_itemServiceImpl(Action_itemRepository action_itemRepository, ProjectRepository projectRepository) {
        super();
        this.action_itemRepository = action_itemRepository;
        this.projectRepository = projectRepository;
    }
    @Override
    public List<Action_item> getAllAction_items(){
        return action_itemRepository.findAll();
    }
    @Override
    public Action_item saveAction_items(Action_item action_item){
        return action_itemRepository.save(action_item);
    }
    @Override
    public Action_item getAction_itemById(Long id){
        return action_itemRepository.findById(id).get();
    }
    public Action_item updateAction_item(Action_item action_item){
        return action_itemRepository.save(action_item);
    }
    @Override
    public void deleteAction_itemById(Long id){
        action_itemRepository.deleteById(id);
    }
    @Override
    public List<Action_item> getAllAction_itemsById(Long id){//this is how to display relational requirements
        Project project = projectRepository.getById(id);
        List<Action_item> assign = project.getAssignAction_item();
        return assign;
    }
}
