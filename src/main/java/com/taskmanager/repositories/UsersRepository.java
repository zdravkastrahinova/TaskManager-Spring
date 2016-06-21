package com.taskmanager.repositories;

import com.taskmanager.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsersRepository extends BaseRepository<User> {
    public UsersRepository() {
        super();
        this.tClass = User.class;
    }
}
