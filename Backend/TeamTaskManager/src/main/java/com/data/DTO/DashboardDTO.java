package com.data.DTO;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDTO {
    private long totalProjects;
    private long totalTasks;
    private Map<String, Long> tasksByStatus;  // TODO / IN_PROGRESS / DONE counts
    private long overdueTasks;
    private List<TaskDTO> myAssignedTasks;
}
