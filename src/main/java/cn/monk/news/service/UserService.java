package cn.monk.news.service;

import cn.monk.news.dao.LoginTicketDao;
import cn.monk.news.dao.UserDao;
import cn.monk.news.model.LoginTicket;
import cn.monk.news.model.User;
import cn.monk.news.util.NewsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        String head = String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000));
        user.setHeadUrl(head);
        user.setPassword(NewsUtil.MD5(password + user.getSalt()));
        userDao.addUser(user);

        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);

        return map;
    }

    public Map<String, Object> login(String username, String password){
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

        if(user == null){
            map.put("msgname", "用户名不能为空");
            return map;
        }
        if(!NewsUtil.MD5(password + user.getSalt()).equals(user.getPassword())){
            map.put("msgpwd", "密码不正确");
            return map;
        }
        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }

    private String addLoginTicket(int userId) {
        LoginTicket ticket = new LoginTicket();
        ticket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        ticket.setExpired(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        LoginTicketDao.addTicket(ticket);
        return ticket.getTicket();
    }

    public void logout(String ticket) {
        LoginTicketDao.updateStatus(ticket, 1);
    }
}
