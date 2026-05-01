package com.data.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.data.Repository.ProjectRepository;
import com.data.Repository.UserRepository;
import com.data.model.Project;
import com.data.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public Project createProject(Project project, String email) {

        // 🔥 get logged-in user
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔥 set createdBy
        project.setCreatedBy(user);

        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}