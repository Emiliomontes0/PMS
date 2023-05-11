package projectmanagementsystem.service.impl;

import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.SucTask;
import projectmanagementsystem.entity.Task;
import projectmanagementsystem.repository.SucTaskRepository;
import projectmanagementsystem.repository.TaskRepository;
import projectmanagementsystem.service.SucTaskService;

import java.util.List;

@Service
public class SucTaskServiceImpl implements SucTaskService{
    private SucTaskRepository suctaskRepository;
    private TaskRepository taskRepository;

    public SucTaskServiceImpl(SucTaskRepository suctaskRepository, TaskRepository taskRepository) {
        super();
        this.taskRepository = taskRepository;
        this.suctaskRepository = suctaskRepository;
    }
    @Override
    public List<SucTask> getAllTasks(){
        return suctaskRepository.findAll();
    }
    @Override
    public SucTask saveTasks(SucTask task){
        return suctaskRepository.save(task);
    }
    @Override
    public SucTask getTaskById(Long id){
        return suctaskRepository.findById(id).get();
    }
    public SucTask updateTask(SucTask task){
        return suctaskRepository.save(task);
    }
    @Override
    public void deleteTaskById(Long id){
        suctaskRepository.deleteById(id);
    }
    @Override
    public List<SucTask> getAllTasksById(Long id){//this is how to display relational requirements
        Task task = taskRepository.getById(id);
        List<SucTask> assign = task.getSucTask();
        return assign;
    }
}
