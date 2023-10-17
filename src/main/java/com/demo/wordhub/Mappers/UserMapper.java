/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package com.demo.wordhub.Mappers;

import com.demo.wordhub.Entities.User;
import com.demo.wordhub.Vos.UserLoginVo;
import com.demo.wordhub.Vos.UserRegisterVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    @Results(id="UserMap", value={
            @Result(column = "user_id", property = "id"),
            @Result(column = "user_name", property = "username"),
            @Result(column = "user_password", property = "password"),
            @Result(column = "user_email", property = "email"),
            @Result(column = "user_avatar_path", property = "avatarPath"),
            @Result(column = "user_score", property = "score"),
            @Result(column = "user_role", property = "role")
    })
    List<User> getAll();

    @Insert("insert into user(user_name,user_password, user_email, user_avatar_path) values (#{username}, #{password}, #{email}, #{avatarPath})")
    // 使用自增长主键，并返回到成员id里
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long addUser(User user);

    @Select("select * from user where user_id = #{id}")
    @ResultMap("UserMap")
    User getUserById(Long id);

    @Select("select * from user where user_name=#{username} and user_password=#{password}")
    @ResultMap("UserMap")
    User login(UserLoginVo user);
}
