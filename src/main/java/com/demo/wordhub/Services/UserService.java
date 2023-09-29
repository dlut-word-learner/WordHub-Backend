/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package com.demo.wordhub.Services;

import com.demo.wordhub.Entities.User;
import com.demo.wordhub.Vos.UserLoginVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    boolean login(UserLoginVo user);
    int register(UserLoginVo user);
    List<User> getAll();
    User getUserById(int id);
}
