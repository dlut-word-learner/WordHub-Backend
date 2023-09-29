package com.demo.wordhub.Services.Impls;

import com.demo.wordhub.Entities.User;
import com.demo.wordhub.Mappers.UserMapper;
import com.demo.wordhub.Services.UserService;
import com.demo.wordhub.Vos.UserLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper usermapper;
    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.usermapper=userMapper;
    }

    @Override
    public boolean login(UserLoginVo user) {
        return usermapper.login(user)!=null;
    }

    @Override
    public int register(UserLoginVo user) {
        return usermapper.insert(user);
    }

    @Override
    public List<User> getAll() {
        return usermapper.getAll();
    }

    @Override
    public User getUserById(int id) {
        return usermapper.getUserById(id);
    }
}
