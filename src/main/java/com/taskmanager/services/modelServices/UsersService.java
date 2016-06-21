package com.taskmanager.services.modelServices;

import com.taskmanager.models.User;
import com.taskmanager.viewModels.accountVM.AccountRegisterVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersService extends BaseService<User> {
    public UsersService() {
        super();
    }

    public Boolean ifUserExists(AccountRegisterVM model) {
        User verifyUser = this.getAll().stream().filter(u -> u.getUsername().equals(model.getUsername())).findFirst().orElse(null);
        if (verifyUser == null) {
            return false;
        }

        return true;
    }

    public User getByUsernameAndPassword(String username, String password) {
        return this.getAll().stream().filter((User) -> User.getUsername().equals(username) && User.getPassword().equals(password)).findFirst().orElse(null);
    }
}