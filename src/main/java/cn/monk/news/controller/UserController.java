package cn.monk.news.controller;

import cn.monk.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by 和尚 on 2019/1/11.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
}
