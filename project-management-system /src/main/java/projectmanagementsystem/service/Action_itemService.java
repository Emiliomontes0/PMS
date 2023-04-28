package projectmanagementsystem.service;
import projectmanagementsystem.entity.Action_item;
import projectmanagementsystem.entity.Requirement;

import java.util.List;

public interface Action_itemService {
    List<Action_item> getAllAction_items();
    Action_item saveAction_items(Action_item action_item);
    Action_item getAction_itemById(Long id);
    Action_item updateAction_item(Action_item task);
    void deleteAction_itemById(Long id);
    List<Action_item> getAllAction_itemsById(Long id);
}
