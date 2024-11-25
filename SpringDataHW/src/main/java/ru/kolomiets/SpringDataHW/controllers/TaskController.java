package ru.kolomiets.SpringDataHW.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kolomiets.SpringDataHW.models.Task;
import ru.kolomiets.SpringDataHW.services.TaskService;

import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public String addTask(@RequestBody Task task){
        taskService.addTask(task);
        return "Task add to list";
    }

    @GetMapping()
    public List<Task> findAllTasks(){
        return taskService.findAllTasks();
    }

    @GetMapping("/status")
    public List<Task> findTaskByStatus(@RequestParam String status){
        return taskService.findTaskByStatus(status);
    }

    @PostMapping("/delete")
    public String deleteTask(@RequestParam Long id){
        taskService.deleteTask(id);
        return "Task delete from list";
    }

    @PutMapping("/update")
    public String updateStatus(@RequestParam String status,@RequestParam Long id){
        taskService.updateStatus(status, id);
        return "task update";
    }
}
