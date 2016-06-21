package com.taskmanager.viewModels.tasksVM;

import com.taskmanager.models.Task;

import java.util.List;

public class TasksListVM {
    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
