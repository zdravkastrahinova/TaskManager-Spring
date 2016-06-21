package com.taskmanager.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User extends BaseModel {
    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Task> tasks;

    public User() {
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
