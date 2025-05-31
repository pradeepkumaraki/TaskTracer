package com.self.learn.TaskTracer.repository;

import com.self.learn.TaskTracer.model.Task;

import java.util.List;

public interface TaskTrackerRepo {
    boolean saveToJson(List<Task> allTasks);

    List<Task> loadFromJson();
}
