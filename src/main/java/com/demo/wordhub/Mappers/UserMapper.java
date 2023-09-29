/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package com.demo.wordhub.Mappers;

import com.demo.wordhub.Entities.User;
import com.demo.wordhub.Vos.UserLoginVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();

    @Insert("insert into user(username,password) values (#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserLoginVo user);

    @Select("select * from user where id = #{id}")
    User getUserById(int id);

    @Select("select * from user where username=#{username} and password=#{password}")
    User login(UserLoginVo user);
}
