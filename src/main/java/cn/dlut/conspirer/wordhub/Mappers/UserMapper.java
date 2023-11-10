/**
 * 用户管理相关JDBC逻辑
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
    @Select("select * from `user`")
    @Results(id = "UserMap", value = {
            @Result(column = "user_id", property = "id"),
            @Result(column = "user_name", property = "username"),
            @Result(column = "user_password", property = "password"),
            @Result(column = "user_email", property = "email"),
            @Result(column = "user_score", property = "score"),
            @Result(column = "user_role", property = "role")
    })
    List<User> getAll();

    @Insert("insert into `user` (user_name,user_password, user_email, user_role) values (#{username}, #{password}, #{email}, 0)")
    // 使用自增长主键，并返回到成员id里
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addUser(User user);

    @Select("select * from `user` where user_id = #{id}")
    @ResultMap("UserMap")
    User getUserById(Long id);

    @Select("select * from `user` where user_name = #{username} and user_password = #{password}")
    @ResultMap("UserMap")
    User getUserByUsernameAndPassword(String username, String password);

    @Select("select * from `user` where user_id = #{id} and user_password = #{password}")
    @ResultMap("UserMap")
    User getUserByIdAndPassword(Long id, String password);

    @Delete("delete from `user` where user_id = #{id}")
    @ResultMap("UserMap")
    int deleteUser(User user);

    @Update("update `user` " +
            "set user_name = #{username}, " +
            "    user_email = #{email}, " +
            "    user_score = #{score}, " +
            "    user_role = #{role} " +
            "where user_id = #{id}")
    @ResultMap("UserMap")
    int updateUserProfile(User user);

    @Update("update `user` " +
            "set user_password = #{password} " +
            "where user_id = #{id}")
    int updateUserPassword(Long id, String password);
    /**
     * Add a study(learn or review) record.
     *
     * @param wordId     the word studied
     * @param userId     the user who studied
     * @param
     * @return 1 if succeeded, 0 if failed
     */
//    @Insert("insert into study_rec(word_id, user_id, study_rec_ease, study_rec_gap, study_rec_due_time) values (#{wordId}, #{userId}, #{ease}, #{gap}, #{dueTime})")
//    int addStudyRecord(Long wordId, Long userId, Double ease, Long gap, LocalDateTime dueTime);
}
