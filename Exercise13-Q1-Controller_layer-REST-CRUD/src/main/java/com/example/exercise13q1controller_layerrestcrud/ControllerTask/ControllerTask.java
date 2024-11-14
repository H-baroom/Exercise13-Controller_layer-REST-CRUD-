package com.example.exercise13q1controller_layerrestcrud.ControllerTask;

import com.example.exercise13q1controller_layerrestcrud.ApiResponse.ApiResponse;
import com.example.exercise13q1controller_layerrestcrud.Tracker_System.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Task")
public class ControllerTask {
    ArrayList<Task> tasks = new ArrayList();

    @PostMapping("/add")
    public ApiResponse addTask(@RequestBody Task task) {
        tasks.add(task);
        return new ApiResponse("Task added successfully");
    }

    @GetMapping("/displayAllTasks")
    public ArrayList<Task>  displayAllTasks() {
        return  tasks;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@RequestBody Task task,@PathVariable int index) {
        tasks.set(index, task);
        return new ApiResponse ("Task updated");
    }

    @PutMapping("/changeStatus/{index}")
    public ApiResponse changeStatus(@PathVariable int index){
        if(!(tasks.get(index).getStatus().equalsIgnoreCase("Done"))) {
            tasks.get(index).setStatus("Done");
        }
        return new ApiResponse("Task Change Status");
    }

    @GetMapping("/searchTaskByTitle/{title}")
    public Task searchTaskByTitle(@PathVariable String title){
        for(Task task : tasks) {
            if(task.getTitle().equalsIgnoreCase(title)) {
                return task;
            }
        }
        return null;
    }




}
