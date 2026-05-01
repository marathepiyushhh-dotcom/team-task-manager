package com.data.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.data.model.Project;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private Long id;

    @NotBlank(message = "Project name is required")
    private String name;

    private String description;

    private Project.Status status;

    private Long createdById;
    private String createdByName;

    private LocalDateTime createdAt;

    private int memberCount;
    private int taskCount;

    private List<MemberInfo> members;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberInfo {
        private Long userId;
        private String name;
        private String email;
        private String role;
    }
}
