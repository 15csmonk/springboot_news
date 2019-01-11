package cn.monk.news.service;

import cn.monk.news.dao.UserDao;
import cn.monk.news.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 和尚 on 2019/1/9.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUser(int id){
        return userDao.selectById(id);
    }

}
