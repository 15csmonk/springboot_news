package cn.monk.news.dao;

import cn.monk.news.model.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 和尚 on 2019/1/12.
 */
@Mapper
public interface NewsDao {
    String TABLE_NAME = "news";
    String INSERT_FIELDS = " title, link, image, like_count, comment_count, created_date, user_id ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{title},#{link},#{image},#{likeCount},#{commentCount},#{createdDate},#{userId})"})
    int addNews(News news);

    @Update({"update ", TABLE_NAME, " set commentcount = #{commentCount} where id=#{id}"})
    int updateCommentCount(@Param("id") int id, @Param("commentCount") int commentCount);

    @Select({"select ",SELECT_FIELDS,"from" ,TABLE_NAME,"where id=#{id}"})
    News  selectbyId(int id);

    @Update({"update ", TABLE_NAME, " set likecount = #{likeCount} where id=#{id}"})
    int updateLikeCount(@Param("id") int id, @Param("likeCount") int likeCount);

    List<News> selectByUserIdAndOffset(@Param("userId") int userId, @Param("offset") int offset, @Param("limit") int limit);
}
