package projectmanagementsystem.service;
import projectmanagementsystem.entity.PreTask;

import java.util.List;
//THE PURPOSE OF THIS FILE IS TO CREATE FUNCTIONS THAT ARE USE BETWEEN THE USER AND MIDDLEWARE FOR BETTER CONTROL OF INFORMATION
//THIS FILE CAN ALSO BE USE TO CREATE NEW METHOD THAT ARE NEED AND AREN'T AUTO GENERATED THROUGH LIBRARYS
public interface PreTaskService {
    List<PreTask> getAllTasks();
    PreTask saveTasks(PreTask task);
    PreTask getTaskById(Long id);
    PreTask updateTask(PreTask task);
    void deleteTaskById(Long id);
    List<PreTask> getAllTasksById(Long id);
}
