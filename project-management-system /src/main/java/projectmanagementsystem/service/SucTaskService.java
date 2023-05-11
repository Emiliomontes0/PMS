package projectmanagementsystem.service;
import projectmanagementsystem.entity.SucTask;

import java.util.List;

public interface SucTaskService {
    List<SucTask> getAllTasks();
    SucTask saveTasks(SucTask task);
    SucTask getTaskById(Long id);
    SucTask updateTask(SucTask task);
    void deleteTaskById(Long id);
    List<SucTask> getAllTasksById(Long id);
}
