package cn.monk.news.service;

import cn.monk.news.dao.CommentDao;
import cn.monk.news.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 和尚 on 2019/1/12.
 */
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    public List<Comment> getCommentsByEntity(int entityId, int entityType){
        return commentDao.selectByEntity(entityId, entityType);
    }
    public int addComment(Comment comment){
        return commentDao.addcomment(comment);
    }
    public int getCommentCount(int entityId, int entityType){
        return commentDao.getCommentCount(entityId, entityType);
    }
}
