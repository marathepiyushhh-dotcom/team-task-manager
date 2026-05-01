package com.data.Service;

import org.springframework.stereotype.Service;

import com.data.Repository.TaskRepository;
import com.data.model.Task;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
}
