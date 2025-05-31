package com.self.learn.TaskTracer.commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.learn.TaskTracer.service.TaskTrackerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;


@Command(description = "Task Tracker Commands")
public class TaskTrackerCommands {

    @Autowired
    private TaskTrackerServiceImpl service;

    @Autowired
    private ObjectMapper objectMapper;

    @Command(command = "add", description = "Add a user defined task", group = "Task CRUD command")
    public String addTask(@Option(description = "Describe the task", required = true) String task) {
        return service.addUserTask(task);
    }

    @Command(command = "update", description = "Update the user defined task", group = "Task CRUD command")
    public String updateTask(@Option(description = "Task id to be updated", required = true) int id, @Option(description = "Task description to be updated", required = true) String task) {
        return service.updateUserTask(id, task);
    }


    @Command(command = "delete", description = "Delete the user defined task", group = "Task CRUD command")
    public String deleteTask(@Option int id) {
        return service.deleteUserTask(id);
    }

    @Command(command = "mark-in-progress", description = "Mark the task in progress", group = "Task progress command")
    public String markInProgress(@Option int id) {
        return service.markTaskInProgress(id);
    }

    @Command(command = "mark-done", description = "Mark the task as done", group = "Task progress command")
    public String markAsDone(@Option int id) {
        return service.markTaskAsDone(id);
    }

    @Command(command = "list", description = "List all Tasks", group = "Task list command")
    public String getAllTasks() {
        try{
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(service.getAllTasks());
        }
        catch (JsonProcessingException e){
            return "";
        }

    }

    @Command(command = "list done", description = "List all completed tasks", group = "Task list command")
    public String getAllCompletedTasks() {
        try{
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(service.getAllCompletedTasks());
        }
        catch (JsonProcessingException e){
            return "";
        }
    }

    @Command(command = "list todo", description = "List all todo tasks", group = "Task list command")
    public String getAllTodoTasks() {
        try{
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(service.getAllTodoTasks());
        }
        catch (JsonProcessingException e){
            return "";
        }
    }

    @Command(command = "list in-progress", description = "List all in progress tasks", group = "Task list command")
    public String getAllInprogressTasks() {
        try{
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(service.getAllInProgressTasks());
        }
        catch (JsonProcessingException e){
            return "";
        }
    }
}
