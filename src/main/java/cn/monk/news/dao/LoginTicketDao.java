package cn.monk.news.dao;

import cn.monk.news.model.LoginTicket;
import org.apache.ibatis.annotations.*;

/**
 * Created by 和尚 on 2019/1/11.
 */
@Mapper
public interface LoginTicketDao {
    String TABLE_NAME = "loginticket";
    String INSERT_FIELDS = " userId, expired, status, ticket ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{userId},#{expired},#{status},#{ticket})"})
    int addTicket(LoginTicket ticket);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where ticket=#{ticket}"})
    LoginTicket selectByTicket(String ticket);

    @Update({"update ", TABLE_NAME, " set status=#{status} where ticket=#{ticket}"})
    void updateStatus(@Param("ticket") String ticket, @Param("status") int status);
}
