package com.self.learn.TaskTracer.service;

import com.self.learn.TaskTracer.model.Task;

import java.util.List;

public interface TaskTrackerService {
    String addUserTask(String task);
    String updateUserTask(int taskId, String task);
    String deleteUserTask(int taskId);
    String markTaskInProgress(int taskId);
    String markTaskAsDone(int taskId);
    List<Task> getAllTasks();
    List<Task> getAllCompletedTasks();
    List<Task> getAllTodoTasks();
    List<Task> getAllInProgressTasks();
}
