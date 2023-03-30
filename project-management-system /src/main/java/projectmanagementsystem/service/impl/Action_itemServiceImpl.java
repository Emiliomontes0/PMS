package projectmanagementsystem.service.impl;

import projectmanagementsystem.entity.Action_item;
import projectmanagementsystem.repository.Action_itemRepository;
import projectmanagementsystem.service.Action_itemService;

import java.util.List;

public class Action_itemServiceImpl implements Action_itemService{
    private Action_itemRepository action_itemRepository;

    public Action_itemServiceImpl(Action_itemRepository action_itemRepository) {
        super();
        this.action_itemRepository = action_itemRepository;
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
}
