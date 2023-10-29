package cn.dlut.conspirer.wordhub.Services.Impls;

import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.Mappers.UserMapper;
import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Utils.FileUploadUtils;
import cn.dlut.conspirer.wordhub.Vos.UserRegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
            FileUploadUtils.upload(user.getAvatar(), avatarPath + u.getId(), new String[]{"png"});
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
    public void updateUserAvatar(Long id, MultipartFile avatar) throws IOException {
        FileUploadUtils.upload(avatar, avatarPath + id, new String[]{"png"});
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

//    @Override
//    public Boolean learnOrReviewWord(Long userId, Long wordId, Long studyCount) {
//        int count = usermapper.addStudyRecord(wordId, userId, studyCount);
//        return count == 1;
//    }
}
