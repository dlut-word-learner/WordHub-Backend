/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Services;

import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.Vos.UserLoginVo;
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

    void updateUser(User user);

    Long addExp(Long userId, Long expToAdd);

    Boolean learnOrReviewWord(Long userId, Long wordId, Long studyCount);
}
