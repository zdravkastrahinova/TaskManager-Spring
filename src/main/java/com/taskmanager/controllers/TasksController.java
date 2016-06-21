package com.taskmanager.controllers;

import com.taskmanager.models.Task;
import com.taskmanager.services.AuthenticationService;
import com.taskmanager.services.modelServices.TasksService;
import com.taskmanager.viewModels.tasksVM.TasksEditVM;
import com.taskmanager.viewModels.tasksVM.TasksListVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("tasks")
public class TasksController {
    @Autowired
    TasksService tasksService;

    @RequestMapping("list")
    public ModelAndView list() {
        if (AuthenticationService.getLoggedUser() == null) {
            return new ModelAndView("redirect:/account/login");
        }

        TasksListVM model = new TasksListVM();
        model.setTasks(tasksService.getByUserId(AuthenticationService.getLoggedUser().getId()));

        return new ModelAndView("tasks/list");
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView edit(Integer id) {
        TasksEditVM model = new TasksEditVM();

        Task task;
        if (id == null) {
            task = new Task();

        } else {
            task = tasksService.getById(id);
            if (task == null) {
                return new ModelAndView("redirect:list");
            }
        }

        model.setId(task.getId());
        model.setTitle(task.getTitle());
        model.setContent(task.getContent());
        model.setStatus(task.getStatus());
        model.setUserId(AuthenticationService.getLoggedUser().getId());

        return new ModelAndView("tasks/edit");
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("model") @Valid TasksEditVM model, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("tasks/edit");
        }

        Task task;
        if (model.getId() == 0) {
            task = new Task();
        } else {
            task = tasksService.getById(model.getId());
            if (task == null) {
                return new ModelAndView("redirect:list");
            }
        }

        task.setId(model.getId());
        task.setTitle(model.getTitle());
        task.setContent(model.getContent());
        task.setStatus(model.getStatus());
        task.setUser(AuthenticationService.getLoggedUser());

        tasksService.save(task);

        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        if (id != null) {
            Task task = tasksService.getById(id);

            if (task != null && task.getUser().getId() == AuthenticationService.getLoggedUser().getId()) {
                tasksService.delete(id);
            }
        }

        return new ModelAndView("redirect:list");
    }
}