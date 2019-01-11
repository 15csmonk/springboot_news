package cn.monk.news.service;

import cn.monk.news.dao.LoginTicketDao;
import cn.monk.news.dao.UserDao;
import cn.monk.news.model.User;
import cn.monk.news.util.NewsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Created by 和尚 on 2019/1/9.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginTicketDao LoginTicketDao;

    public User getUser(int id){
        return userDao.selectById(id);
    }

    public Map<String, Object> register(String username, String password){
        Map<String, Object> map = new HashMap<String, Object>();
        if(username == null || username.length() == 0){
            map.put("messagename", "用户名不能为空");
            return map;
        }
        if(password == null || password.length() == 0){
            map.put("messagepassword", "密码不能为空");
            return map;
        }
        User user = userDao.selectByName(username);
        if(user != null){
            map.put("messagename", "用户名已经被注册");
            return map;
        }
        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        String head = String.format("/head/%dt.png", new Random().nextInt(1000));
        user.setHeadUrl(head);
        user.setPassword(NewsUtil.MD5(password + user.getSalt()));
        userDao.addUser(user);

        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);

        return map;
    }
}
