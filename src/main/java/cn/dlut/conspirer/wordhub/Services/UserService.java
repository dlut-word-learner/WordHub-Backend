/**
 * 用户管理相关逻辑
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Services;

import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.Vos.UserRegisterVo;

import java.io.IOException;
import java.util.List;

// 注解在实现类上
// @Service
public interface UserService {
    User checkLogin(String username, String password);

    User checkLogin(Long id, String password);

    /**
     * Register long.
     *
     * @param user the user
     * @return the user created
     * @throws IOException the io exception
     */
    User register(UserRegisterVo user) throws IOException;

    List<User> getAll();

    User getUserById(Long id);

    void updateUserProfile(User user);

    void updateUserPassword(Long id, String password);

    void updateUserAvatar(Long id, byte[] avatar) throws IOException;

    Long addExp(Long userId, Long expToAdd);

    byte[] getAvatarById(Long id) throws IOException;

//    Boolean learnOrReviewWord(Long userId, Long wordId, Long studyCount);
}
