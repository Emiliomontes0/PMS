package projectmanagementsystem.service.impl;
import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Task;
import projectmanagementsystem.entity.PreTask;
import projectmanagementsystem.repository.TaskRepository;
import projectmanagementsystem.repository.PreTaskRepository;
import projectmanagementsystem.service.PreTaskService;

import java.util.List;

@Service
public class PreTaskServiceImpl implements PreTaskService{
    private PreTaskRepository pretaskRepository;
    private TaskRepository taskRepository;

    public PreTaskServiceImpl(PreTaskRepository pretaskRepository, TaskRepository taskRepository) {
        super();
        this.taskRepository = taskRepository;
        this.pretaskRepository = pretaskRepository;
    }
    @Override
    public List<PreTask> getAllTasks(){
        return pretaskRepository.findAll();
    }
    @Override
    public PreTask saveTasks(PreTask task){
        return pretaskRepository.save(task);
    }
    @Override
    public PreTask getTaskById(Long id){
        return pretaskRepository.findById(id).get();
    }
    public PreTask updateTask(PreTask task){
        return pretaskRepository.save(task);
    }
    @Override
    public void deleteTaskById(Long id){
        pretaskRepository.deleteById(id);
    }
    @Override
    public List<PreTask> getAllTasksById(Long id){//this is how to display relational requirements
        Task task = taskRepository.getById(id);
        List<PreTask> assign = task.getPreTask();
        return assign;
    }
}
