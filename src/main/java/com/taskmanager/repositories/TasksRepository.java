package com.taskmanager.repositories;

import com.taskmanager.models.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TasksRepository extends BaseRepository<Task> {
    public TasksRepository() {
        super();
        this.tClass = Task.class;
    }
}
