package ru.kolomiets.SpringDataHW.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kolomiets.SpringDataHW.models.Task;
import ru.kolomiets.SpringDataHW.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public void addTask(Task task){
        repository.save(task);
    }

    public List<Task> findAllTasks(){
        return repository.findAll().stream().toList();
    }

    public List<Task> findTaskByStatus(String status){
        return repository.findAll().stream().filter(
                task -> task.getStatus().equals(status)).toList();
    }

    public void deleteTask(Long id){
        repository.deleteById(id);
    }

    public void updateStatus(String status, Long id){
        Optional<Task> oldtask = repository.findById(id);
        if(oldtask.isPresent()){
            Task task = oldtask.get();
            task.setStatus(status);
            repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }
}
