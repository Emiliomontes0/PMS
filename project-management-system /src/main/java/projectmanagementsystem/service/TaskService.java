package projectmanagementsystem.service;
import projectmanagementsystem.entity.Requirement;
import projectmanagementsystem.entity.Task;

import java.util.List;
//THE PURPOSE OF THIS FILE IS TO CREATE FUNCTIONS THAT ARE USE BETWEEN THE USER AND MIDDLEWARE FOR BETTER CONTROL OF INFORMATION
//THIS FILE CAN ALSO BE USE TO CREATE NEW METHOD THAT ARE NEED AND AREN'T AUTO GENERATED THROUGH LIBRARYS
public interface TaskService {
    List<Task> getAllTasks();
    Task saveTasks(Task task);
    Task getTaskById(Long id);
    Task updateTask(Task task);
    void deleteTaskById(Long id);
    List<Task> getAllTasksById(Long id);
}
