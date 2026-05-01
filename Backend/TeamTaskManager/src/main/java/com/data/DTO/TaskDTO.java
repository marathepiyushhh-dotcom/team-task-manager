package com.data.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.data.model.Task;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private Long id;

    @NotBlank(message = "Task title is required")
    private String title;

    private String description;

    private Task.Status status;

    private Task.Priority priority;

    // For request: accept IDs
    private Long projectId;
    private Long assignedToId;

    // For response: include names
    private String projectName;
    private String assignedToName;
    private String createdByName;

    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private boolean overdue;
}

