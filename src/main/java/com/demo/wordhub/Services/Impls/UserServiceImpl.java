package com.demo.wordhub.Services.Impls;

import com.demo.wordhub.Entities.User;
import com.demo.wordhub.Mappers.UserMapper;
import com.demo.wordhub.Services.UserService;
import com.demo.wordhub.Utils.FileUploadUtils;
import com.demo.wordhub.Vos.UserLoginVo;
import com.demo.wordhub.Vos.UserRegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserMapper usermapper;

    @Value("${urls.avatar}")
    private String avatarPath;
    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.usermapper=userMapper;
    }

    /**
     * TODO
     *
     * @param user
     * @return
     */
    @Override
    public boolean login(UserLoginVo user) {
        return true;
    }

    @Override
    public User register(UserRegisterVo user) throws IOException {
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());

        u.setAvatarPath(avatarPath+user.getUsername());
        if(user.getAvatar()!=null){
            FileUploadUtils.upload(user.getAvatar(), u.getAvatarPath());
        }

        int id = usermapper.addUser(u);
        log.info("User created, id: " + u.getId());
        return usermapper.getUserById(u.getId());
    }

    @Override
    public List<User> getAll() {
        return usermapper.getAll();
    }

    @Override
    public User getUserById(Long id) {
        return usermapper.getUserById(id);
    }
}
