//package com.self.learn.TaskTracer.commands;
//
//import com.self.learn.TaskTracer.model.Task;
//import com.self.learn.TaskTracer.service.TaskTrackerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.shell.standard.ShellComponent;
//import org.springframework.shell.standard.ShellMethod;
//import org.springframework.shell.standard.ShellOption;
//
//import java.util.List;
//
//@ShellComponent
//public class TaskTrackerCommandsLegacy {
//
//    @Autowired
//    TaskTrackerService service;
//
//    @ShellMethod(key = "add", value = "Add a user defined task")
//    public String addTask(@ShellOption String task) {
//        return service.addUserTask(task);
//    }
//
//    @ShellMethod(key = "update", value = "Update the user defined task")
//    public String updateTask(@ShellOption int id, @ShellOption String task) {
//        return service.updateUserTask(id, task);
//    }
//
//
//    @ShellMethod(key = "delete", value = "Delete the user defined task")
//    public String deleteTask(@ShellOption int id) {
//        return service.deleteUserTask(id);
//    }
//
//    @ShellMethod(key = "mark-in-progress", value = "Mark the task in progress")
//    public String markInProgress(@ShellOption int id) {
//        return service.markTaskInProgress(id);
//    }
//
//    @ShellMethod(key = "mark-done", value = "Mark the task as done")
//    public String markAsDone(@ShellOption int id) {
//        return service.markTaskAsDone(id);
//    }
//
//    @ShellMethod(key = "list", value = "List all Tasks")
//    public List<Task> getAllTasks() {
//        return service.getAllTasks();
//    }
//
//    @ShellMethod(key = "list done", value = "List all completed tasks")
//    public List<Task> getAllCompletedTasks() {
//        return service.getAllCompletedTasks();
//    }
//
//    @ShellMethod(key = "list todo", value = "List all todo tasks")
//    public List<Task> getAllTodoTasks() {
//        return service.getAllTodoTasks();
//    }
//
//    @ShellMethod(key = "list in-progress", value = "List all in progress tasks")
//    public List<Task> getAllInprogressTasks() {
//        return service.getAllInProgressTasks();
//    }
//}
