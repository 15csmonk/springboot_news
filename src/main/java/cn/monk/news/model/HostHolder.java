package cn.monk.news.model;

import org.springframework.stereotype.Component;

/**
 * Created by 和尚 on 2019/1/12.
 */
@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();
    }
}
