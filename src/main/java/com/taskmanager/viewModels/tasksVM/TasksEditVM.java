package com.taskmanager.viewModels.tasksVM;

import com.taskmanager.enums.TaskStatusEnum;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TasksEditVM {
    private int id;

    @NotEmpty(message = "Title is required.")
    @Size(min = 2, max = 50, message = "Title should contains between 2 and 50 characters.")
    @Pattern(regexp = "^([A-z-_. 0-9])+$", message = "Title should not consist any special chars.")
    private String title;

    @NotEmpty(message = "Content is required.")
    @Size(min = 2, max = 50, message = "Content should contains between 2 and 50 characters.")
    @Pattern(regexp = "^([A-z-_. 0-9])+$", message = "Content should not consist any special chars.")
    private String content;

    private TaskStatusEnum status;

    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}