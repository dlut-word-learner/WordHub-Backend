/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package com.demo.wordhub.Services;

import com.demo.wordhub.Entities.User;
import com.demo.wordhub.Vos.UserLoginVo;
import com.demo.wordhub.Vos.UserRegisterVo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface UserService {
    boolean login(UserLoginVo user);


    /**
     * Register long.
     *
     *
     * @param user the user
     * @return the user created
     * @throws IOException the io exception
     */
    User register(UserRegisterVo user) throws IOException;
    List<User> getAll();
    User getUserById(Long id);
}
