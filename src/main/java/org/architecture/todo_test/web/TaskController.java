package org.architecture.todo_test.web;

import org.architecture.todo_test.service.ITaskService;
import org.architecture.todo_test.web.dtos.request.TaskRequest;
import org.architecture.todo_test.web.dtos.response.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping
    public String viewHome(){
        return "home";
    }

    @GetMapping("/tasks")
    public String viewTasks(Model model){
        List<TaskResponse> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/add")
    public String createTask(){
        return "addTask";
    }

    @PostMapping("task/add")
    public String createTask(@ModelAttribute("taskRequest") TaskRequest taskRequest, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error", "Ha ocurrido un error en la solicitud");
            return "addTask";
        }
        taskService.create(taskRequest);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        taskService.delete(id);
        return "redirect:/tasks";
    }
}
