package projectmanagementsystem.service.impl;

import projectmanagementsystem.entity.Task;
import projectmanagementsystem.repository.TaskRepository;
import projectmanagementsystem.service.TaskService;

import java.util.List;

public class ResourceServiceImpl implements TaskService{
    private TaskRepository taskRepository;

    public ResourceServiceImpl(TaskRepository taskRepository) {
        super();
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
}
