package com.self.learn.TaskTracer.service;

import com.self.learn.TaskTracer.model.Task;
import com.self.learn.TaskTracer.repository.TaskTrackerRepositoryImpl;
import com.self.learn.TaskTracer.utility.Constants;
import com.self.learn.TaskTracer.utility.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TaskTrackerServiceImpl implements TaskTrackerService {

    @Autowired
    private TaskTrackerRepositoryImpl repo;
    private List<Task> allTasksList;


    private void loadData(){
        allTasksList = repo.loadFromJson();
        if(allTasksList == null){
            allTasksList = new ArrayList<>();
        }
    }
    private boolean dumpData(){
         return repo.saveToJson(allTasksList);
    }

    public String addUserTask(String task) {
        loadData();
        try {
            Optional<Task> checkIfTaskExists = allTasksList.stream().filter(t -> t.getDescription().equals(task)).findFirst();
            if (checkIfTaskExists.isPresent()) {
                return Constants.TASK_ALREADY_EXISTS;
            } else {
                int newtaskId = allTasksList.size()+1;
                Task newTask = Task.builder().description(task).status(Status.TODO).id(newtaskId).build();
                allTasksList.add(newTask);
                return String.format(Constants.TASK_ADDED, newtaskId);
            }
        }
        finally {
            dumpData();
        }
    }

    public String updateUserTask(int taskId, String task) {
        loadData();
        try {
            if (allTasksList.size() >= taskId) {
                allTasksList.get(taskId-1).setDescription(task);
                return Constants.TASK_UPDATED;
            } else {
                return Constants.TASK_DO_NOT_EXIST;
            }
        }finally {
            dumpData();
        }
    }

    public String deleteUserTask(int taskId) {
        loadData();
        try {
            if (allTasksList.size() >= taskId) {
                allTasksList.remove(taskId-1);
                return Constants.TASK_DELETED;
            } else {
                return Constants.TASK_DO_NOT_EXIST;
            }
        }
        finally {
            dumpData();
        }
    }

    public String markTaskInProgress(int taskId) {
        loadData();
        try {
            if (allTasksList.size() >= taskId) {
                allTasksList.get(taskId-1).setStatus(Status.IN_PROGRESS);
                return Constants.MARK_IN_PROGRESS;
            } else {
                return Constants.TASK_DO_NOT_EXIST;
            }
        }finally {
            dumpData();
        }
    }

    public String markTaskAsDone(int taskId) {
        loadData();
        try {
            if (allTasksList.size() >= taskId) {
                allTasksList.get(taskId-1).setStatus(Status.DONE);
                return Constants.MARK_COMPLETED;
            } else {
                return Constants.TASK_DO_NOT_EXIST;
            }
        }
        finally {
            dumpData();
        }
    }

    public List<Task> getAllTasks() {
        loadData();
        return allTasksList;
    }

    public List<Task> getAllCompletedTasks() {
        loadData();
        return allTasksList.stream().filter(t -> t.getStatus() == Status.DONE).collect(Collectors.toList());
    }

    public List<Task> getAllTodoTasks() {
        loadData();
        return allTasksList.stream().filter(t -> t.getStatus() == Status.TODO).collect(Collectors.toList());
    }

    public List<Task> getAllInProgressTasks() {
        loadData();
        return allTasksList.stream().filter(t -> t.getStatus() == Status.IN_PROGRESS).collect(Collectors.toList());
    }
}
