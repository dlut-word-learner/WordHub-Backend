package cn.dlut.conspirer.wordhub.Services.Impls;

import cn.dlut.conspirer.wordhub.Entities.Task;
import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.Mappers.UserMapper;
import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Utils.FileUploadUtils;
import cn.dlut.conspirer.wordhub.Vos.UserRegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * User Service的实现
 *
 * @author OuOu
 * @version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private UserMapper usermapper;
    private String avatarPath;


    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserMapper userMapper, @Value("${urls.avatar}") String avatarPath) {
        this.usermapper = userMapper;
        this.avatarPath = avatarPath;
    }

    @Autowired
    public void setAvatarPath(@Value("${urls.avatar}") String avatarPath){
        this.avatarPath = avatarPath;
    }

    @Autowired
    public void setUserMapper(UserMapper u) {
        usermapper = u;
    }

    @Override
    public User checkLogin(String username, String password) {
        User user = usermapper.getUserByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public User checkLogin(Long id, String password) {
        User user = usermapper.getUserByIdAndPassword(id, password);
        return user;
    }

    @Override
    public User register(UserRegisterVo user) throws IOException {
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());

        int id = usermapper.addUser(u);
        log.info("User created, id: " + u.getId());
        if (user.getAvatar() != null) {
            FileUploadUtils.upload(user.getAvatar().getBytes(), avatarPath + u.getId(), "png");
        }
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

    @Override
    public void updateUserProfile(User user) {
        usermapper.updateUserProfile(user);
    }

    @Override
    public void updateUserPassword(Long id, String password) {
        usermapper.updateUserPassword(id, password);
    }

    @Override
    public void updateUserAvatar(Long id, byte[] avatar) throws IOException {
        FileUploadUtils.upload(avatar, avatarPath + id, "png");
    }

    @Override
    public Long addExp(Long id, Long expToAdd) {
        User user = getUserById(id);
        if (user != null) {
            user.setScore(user.getScore() + expToAdd);
            updateUserProfile(user);
            return user.getScore();
        }
        return null;
    }

    @Override
    public byte[] getAvatarById(Long id) throws IOException {
        User user = getUserById(id);
        if (user != null) {
            File avatar = new File(avatarPath + id + ".png");
            return Files.readAllBytes(avatar.toPath());
        }
        return null;
    }

    /**
     * 获取过去n天（包括今天）的每天，用户对指定 task 的记录条数
     * 按时间顺序给出，先给出 n-1 天前，最后给今天
     * @param task 学习/复习/Qwerty
     * @param userId 用户名
     * @param n 总共多少天，即为返回的List的size
     * @return
     */
    @Override
    public List<Long> getStudyTickInPastNDays(Task task, Long userId, Long n){
        ArrayList<Long> ans = new ArrayList<>();
        for(Long i= n-1 ;i>=0L;i--){
            switch (task) {
                case Learn -> {
                    ans.add(usermapper.getLearnTickNDaysBefore(userId, i));
                }
                case Review -> {
                    ans.add(usermapper.getReviewTickNDaysBefore(userId, i));
                }
                case QwertyMode -> {
                    ans.add(usermapper.getQwertyTickNDaysBefore(userId, i));
                }
            }

        }
        return ans;
    }
}
