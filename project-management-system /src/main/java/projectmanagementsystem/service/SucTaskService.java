package projectmanagementsystem.service;
import projectmanagementsystem.entity.SucTask;

import java.util.List;
//THE PURPOSE OF THIS FILE IS TO CREATE FUNCTIONS THAT ARE USE BETWEEN THE USER AND MIDDLEWARE FOR BETTER CONTROL OF INFORMATION
//THIS FILE CAN ALSO BE USE TO CREATE NEW METHOD THAT ARE NEED AND AREN'T AUTO GENERATED THROUGH LIBRARYS
public interface SucTaskService {
    List<SucTask> getAllTasks();
    SucTask saveTasks(SucTask task);
    SucTask getTaskById(Long id);
    SucTask updateTask(SucTask task);
    void deleteTaskById(Long id);
    List<SucTask> getAllTasksById(Long id);
}
