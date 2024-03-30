package com.assesstment1.taskmanager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public ResponseEntity<Object> createTask(@RequestBody Task task) {
        return taskService.newTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}") // New mapping for getting a task by ID
    public ResponseEntity<Object> getTaskById(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTaskById(@PathVariable Integer id, @RequestBody Task updatedTask) {
        return taskService.updateTaskById(id, updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTaskById(@PathVariable Integer id) {
        return taskService.deleteTaskById(id);
    }
}
