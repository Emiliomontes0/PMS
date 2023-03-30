package projectmanagementsystem.service;
import projectmanagementsystem.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task saveTasks(Task task);
    Task getTaskById(Long id);
    Task updateTask(Task task);
    void deleteTaskById(Long id);
}
