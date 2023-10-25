/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Entities.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from \"user\"")
    @Results(id = "UserMap", value = {
            @Result(column = "user_id", property = "id"),
            @Result(column = "user_name", property = "username"),
            @Result(column = "user_password", property = "password"),
            @Result(column = "user_email", property = "email"),
            @Result(column = "user_avatar_path", property = "avatarPath"),
            @Result(column = "user_score", property = "score"),
            @Result(column = "user_role", property = "role")
    })
    List<User> getAll();

    @Insert("insert into \"user\"(user_name,user_password, user_email, user_avatar_path) values (#{username}, #{password}, #{email}, #{avatarPath})")
    // 使用自增长主键，并返回到成员id里
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addUser(User user);

    @Select("select * from \"user\" where user_id = #{id}")
    @ResultMap("UserMap")
    User getUserById(Long id);

    @Select("select * from \"user\" where user_name = #{username} and user_password = #{password}")
    @ResultMap("UserMap")
    User getUserByUsernameAndPassword(String username, String password);

    @Delete("delete from \"user\" where user_id = #{id}")
    @ResultMap("UserMap")
    int deleteUser(User user);

    @Update("update \"user\" " +
            "set user_name = #{username}, " +
            "    user_email = #{email}, " +
            "    user_password = #{password}, " +
            "    user_score = #{score}, " +
            "    user_avatar_path = #{avatarPath}, " +
            "    user_role = #{role} " +
            "where user_id = #{id}")
    @ResultMap("UserMap")
    int updateUser(User user);

    /**
     * Add a study(learn or review) record.
     *
     * @param wordId     the word studied
     * @param userId     the user who studied
     * @param studyCount the count that the user finished the study this time.
     * @return 1 if succeeded, 0 if failed
     */
    @Insert("insert into study_rec(word_id, user_id, study_count) values (#{wordId}, #{userId}, #{studyCount})")
    int addStudyRecord(Long wordId, Long userId, Long studyCount);
}
