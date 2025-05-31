package com.self.learn.TaskTracer.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.self.learn.TaskTracer.model.Task;
import com.self.learn.TaskTracer.utility.Constants;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskTrackerRepositoryImpl implements TaskTrackerRepo {

    public boolean saveToJson(List<Task> allTasks){
        boolean status = false;
        try(FileWriter file = new FileWriter(Constants.FILE_PATH)){
            file.write(new Gson().toJson(allTasks));
            file.flush();
            status = true;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return status;
    }

    public List<Task> loadFromJson(){
        List<Task> allTasks = new ArrayList<>();
        try {
            String json = Files.readString(Path.of(Constants.FILE_PATH));
            allTasks =  new Gson().fromJson(json, new TypeToken<List<Task>>() {}.getType());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return allTasks;
    }
}
