package cn.dlut.conspirer.wordhub.Services.Impls;

import cn.dlut.conspirer.wordhub.Mappers.UserMapper;
import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Utils.FileUploadUtils;
import cn.dlut.conspirer.wordhub.Vos.UserLoginVo;
import cn.dlut.conspirer.wordhub.Vos.UserRegisterVo;
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
    private UserMapper usermapper;

    @Value("${urls.avatar}")
    private String avatarPath;


    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.usermapper = userMapper;
    }

    @Autowired
    public void setUserMapper(UserMapper u) {
        usermapper = u;
    }

    /**
     * TODO
     *
     */
    @Override
    public User login(UserLoginVo userLoginVo) {
        User user = usermapper.getUserByUsernameAndPassword(userLoginVo.getUsername(), userLoginVo.getPassword());
        return user;
    }

    @Override
    public User register(UserRegisterVo user) throws IOException {
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());

        u.setAvatarPath(avatarPath + user.getUsername());
        if (user.getAvatar() != null) {
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
