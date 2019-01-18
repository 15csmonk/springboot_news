package cn.monk.news.service;

import cn.monk.news.dao.NewsDao;
import cn.monk.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 和尚 on 2019/1/12.
 */
@Service
public class NewsService {
    @Autowired
    private NewsDao newsDao;
    public List<News> getLatestNews(int userId, int offset, int limit) {
        return newsDao.selectByUserIdAndOffset(userId, offset, limit);
    }
    public News getById(int id){
        return newsDao.selectbyId(id);
    }
    public int addNews(News news){
        return newsDao.addNews(news);
    }
    public int updateCommentCount(int id, int count){
        return newsDao.updateCommentCount(id, count);
    }
    public int updateLikeCount(int id, int count){
        return newsDao.updateLikeCount(id, count);
    }
}
