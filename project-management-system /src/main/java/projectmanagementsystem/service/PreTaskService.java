package projectmanagementsystem.service;
import projectmanagementsystem.entity.PreTask;

import java.util.List;

public interface PreTaskService {
    List<PreTask> getAllTasks();
    PreTask saveTasks(PreTask task);
    PreTask getTaskById(Long id);
    PreTask updateTask(PreTask task);
    void deleteTaskById(Long id);
    List<PreTask> getAllTasksById(Long id);
}
