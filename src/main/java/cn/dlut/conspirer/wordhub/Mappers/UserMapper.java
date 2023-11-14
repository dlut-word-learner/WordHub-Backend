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
    @ResultMap("UserMap")
    int updateUserPassword(Long id, String password);

    /**
     * 返回用户过去n天学习的单词数量
     * sql大意：从StudyRec表中选出最早一次学习记录(tick=1)在n天之内的单词，count(*) group by date
     * @param userId
     * @param n
     * @return
     */
    @Select("SELECT COUNT(*) " +
            "FROM study_rec " +
            "WHERE study_rec_tick = 1 " +
            "AND user_id = #{userId} " +
            "AND DATE(timestampadd(day, -study_rec_gap, study_rec_due_time)) = timestampadd(day, -#{n}, " +
            "CURRENT_DATE);")
    Long getLearnTickNDaysBefore(Long userId, Long n);

    /**
     * 返回用户过去n天复习单词次数
     * sql大意：从StudyRec表中选出n天之内的学习记录，where tick!=1(排除学习)，count(*) group by date
     * @param userId
     * @param n
     * @return
     */
    @Select("SELECT COUNT(*) " +
            "FROM study_rec " +
            "WHERE study_rec.study_rec_tick != 1 " +
            "AND user_id = #{userId} " +
            "AND DATE(timestampadd(day, -study_rec_gap, study_rec_due_time)) = timestampadd(day, -#{n}, " +
            "CURRENT_DATE);")
    Long getReviewTickNDaysBefore(Long userId, Long n);

    /**
     * 返回用户过去n天Qwerty单词次数
     * 考虑建一个新表专门存Qwerty的历史记录，可以叫QwertyRec，因为这个记录和StudyRec的机制有很大差别
     * @param userId
     * @param n
     * @return
     */
    @Select("SELECT COUNT(*) " +
            "FROM qwerty_rec " +
            "WHERE user_id = #{userId} " +
            "AND DATE(qwerty_rec_time) = timestampadd(day, -#{n}, CURRENT_DATE);")
    Long getQwertyTickNDaysBefore(Long userId, Long n);
}
