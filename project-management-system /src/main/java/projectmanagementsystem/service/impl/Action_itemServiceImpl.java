package projectmanagementsystem.service.impl;

import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Action_item;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.repository.ProjectRepository;
import projectmanagementsystem.repository.Action_itemRepository;
import projectmanagementsystem.service.Action_itemService;

import java.util.List;
//THIS FILE FUNCTION AS THE CREATION FOR THE METHODS DEFINED IN SERVICE CLASSES
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
    }//USES REPOSITORY TO GRAB DATA FROM DATABASE
    @Override
    public Action_item saveAction_items(Action_item action_item){
        return action_itemRepository.save(action_item);
    }//USES REPOSITORY TO SAVE OBJECT INTO DATABASE

    @Override
    public Action_item getAction_itemById(Long id){
        return action_itemRepository.findById(id).get();
    }//USES REPOSITORY TO GRAB FROM DATABASE BY AN ID
    public Action_item updateAction_item(Action_item action_item){
        return action_itemRepository.save(action_item);
    }//USES REPOSITORY TO SAVE A OBJECT THAT HAS BEEN MODIFIED BY THE USERS
    @Override
    public void deleteAction_itemById(Long id){
        action_itemRepository.deleteById(id);
    }//USES REPOSITORY TO DELETE OBJECT IN DATA BASE WITH ID
    @Override
    public List<Action_item> getAllAction_itemsById(Long id){//CREATES A METHOD THAT ALLOWS GIVE RELATIONS BETWEEN OTHER OBJECT
        Project project = projectRepository.getById(id);//FIND THE RELATED PROJECT BY ID
        List<Action_item> assign = project.getAssignAction_item();//CREATES A LIST AND RETURNS THE LIST BACK TO WHERE METHOD IS CALLED
        return assign;
    }
}
