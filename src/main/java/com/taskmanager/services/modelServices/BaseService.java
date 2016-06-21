package com.taskmanager.services.modelServices;

import com.taskmanager.models.BaseModel;
import com.taskmanager.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public abstract class BaseService<T extends BaseModel> {
    @Autowired
    protected BaseRepository<T> baseRepository;

    public BaseService() {
    }

    public T getById(int id) {
        return this.baseRepository.getById(id);
    }

    public List<T> getAll() {
        return this.baseRepository.getAll();
    }

    public void save(T item) {
        this.baseRepository.save(item);
    }

    public void delete(int id) {
        this.baseRepository.delete(id);
    }
}
