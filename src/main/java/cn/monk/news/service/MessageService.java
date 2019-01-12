package cn.monk.news.service;

import cn.monk.news.dao.MessageDao;
import cn.monk.news.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 和尚 on 2019/1/12.
 */
@Service
public class MessageService {
    @Autowired
    private MessageDao messageDao;
    public int addMessage(Message message){
        return messageDao.addMessage(message);
    }
    public List<Message> getConversationList(int userId, int offset, int limit){
        return messageDao.getConversationList(userId, offset, limit);
    }
    public List<Message> getConversationDetail(String conversationId, int offset, int limit){
        return messageDao.getConversationDetail(conversationId, offset, limit);
    }
    public int getUnreadCount(int userId, String conversationId){
        return messageDao.getConversationUnReadCount(userId, conversationId);
    }
    public int getConversationCout(String conversationId){
        return messageDao.getConversationCount(conversationId);
    }
}
