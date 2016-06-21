package com.taskmanager.repositories;

import com.taskmanager.models.BaseModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class BaseRepository<T extends BaseModel> {
    protected Class<T> tClass;

    @Autowired
    protected SessionFactory sessionFactory;

    public BaseRepository() {
    }

    public T getById(int id) {
        return this.getAll().stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public List<T> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(tClass).list();
    }

    public void save(T item) {
        sessionFactory.getCurrentSession().saveOrUpdate(item);
    }

    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(getById(id));
    }
}