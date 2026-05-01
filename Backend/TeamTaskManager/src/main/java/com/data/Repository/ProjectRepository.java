package com.data.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.data.model.Project;
import com.data.model.User;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    // All projects where this user is a member (via ProjectMember join)
    @Query("SELECT p FROM Project p JOIN p.members pm WHERE pm.user = :user")
    List<Project> findAllByMember(@Param("user") User user);

    // Projects created by user
    List<Project> findByCreatedBy(User createdBy);
}