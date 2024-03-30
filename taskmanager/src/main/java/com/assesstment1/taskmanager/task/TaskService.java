package com.assesstment1.taskmanager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public ResponseEntity<Object> newTask(Task task) {
        taskRepository.save(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    public List<Task> getTasks(){
        return this.taskRepository.findAll();
    }

    public ResponseEntity<Object> getTaskById(Integer id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (!taskOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Task task = taskOptional.get();
        return ResponseEntity.ok(task);
    }

    public ResponseEntity<Object> updateTaskById(Integer id, Task updatedTask) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (!taskOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        updatedTask.setId(id); // Set the ID of the updated task
        taskRepository.save(updatedTask);
        return ResponseEntity.ok(updatedTask);
    }

    public ResponseEntity<Object> deleteTaskById(Integer id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (!taskOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
