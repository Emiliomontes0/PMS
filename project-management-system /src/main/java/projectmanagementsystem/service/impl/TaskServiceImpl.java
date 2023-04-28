package projectmanagementsystem.service.impl;
import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.entity.Requirement;
import projectmanagementsystem.entity.Task;
import projectmanagementsystem.repository.ProjectRepository;
import projectmanagementsystem.repository.TaskRepository;
import projectmanagementsystem.service.TaskService;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService{
    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;

    public TaskServiceImpl(TaskRepository taskRepository, ProjectRepository projectRepository) {
        super();
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }
    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    @Override
    public Task saveTasks(Task task){
        return taskRepository.save(task);
    }
    @Override
    public Task getTaskById(Long id){
        return taskRepository.findById(id).get();
    }
    public Task updateTask(Task task){
        return taskRepository.save(task);
    }
    @Override
    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }
    @Override
    public List<Task> getAllTasksById(Long id){//this is how to display relational requirements
        Project project = projectRepository.getById(id);
        List<Task> assign = project.getAssignTask();
        return assign;
    }
}
