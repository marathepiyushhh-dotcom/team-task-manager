package com.data.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.data.model.Project;
import com.data.model.Task;
import com.data.model.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByProject(Project project);

    List<Task> findByAssignedTo(User user);

    List<Task> findByProjectAndStatus(Project project, Task.Status status);

    // Overdue tasks for a user's projects
    @Query("""
        SELECT t FROM Task t
        JOIN t.project p
        JOIN p.members pm
        WHERE pm.user = :user
          AND t.dueDate < :today
          AND t.status != 'DONE'
        """)
    List<Task> findOverdueTasksForUser(@Param("user") User user,
                                       @Param("today") LocalDate today);

    // Count tasks by status for a given project
    long countByProjectAndStatus(Project project, Task.Status status);

    // All tasks across user's projects for dashboard
    @Query("""
        SELECT t FROM Task t
        JOIN t.project p
        JOIN p.members pm
        WHERE pm.user = :user
        ORDER BY t.createdAt DESC
        """)
    List<Task> findAllTasksForUser(@Param("user") User user);
}