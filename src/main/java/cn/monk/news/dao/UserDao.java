package cn.monk.news.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by 和尚 on 2019/1/9.
 */
@Mapper
public interface UserDao {
    String TABLE_NAME = "user";
    String INSET_FIELDS = " name, password, salt, head_url ";
    String SELECT_FIELDS = " id, name, password, salt, head_url";

}
