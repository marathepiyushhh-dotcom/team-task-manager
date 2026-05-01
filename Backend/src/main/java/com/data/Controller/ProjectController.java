package com.data.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.DTO.ProjectDTO;
import com.data.Service.ProjectService;
import com.data.model.Project;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    // ✅ CREATE PROJECT
    @PostMapping
    public Project createProject(@RequestBody Project project,
                                Authentication authentication) {

        String email = authentication.getName();
        return projectService.createProject(project, email);
    }

    // ✅ GET PROJECTS (FIXED)
    @GetMapping
    public List<ProjectDTO> getProjects() {
        return projectService.getAllProjects()
                .stream()
                .map(p -> {
                    ProjectDTO dto = new ProjectDTO();
                    dto.setId(p.getId());
                    dto.setName(p.getName());
                    dto.setDescription(p.getDescription());

                    if (p.getCreatedBy() != null) {
                        dto.setCreatedById(p.getCreatedBy().getId());
                        dto.setCreatedByName(p.getCreatedBy().getName());
                    }

                    dto.setCreatedAt(p.getCreatedAt());

                    return dto;
                })
                .collect(Collectors.toList());
    }
}