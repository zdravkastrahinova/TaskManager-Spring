package com.taskmanager.services.modelServices;

import com.taskmanager.models.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@Transactional
public class TasksService extends BaseService<Task> {
    public TasksService() {
        super();
    }

    public ArrayList<Task> getByUserId(int userId) {
        return this.getAll().stream().filter(t -> t.getUser().getId() == userId).collect(Collectors.toCollection(ArrayList<Task>::new));
    }
}
