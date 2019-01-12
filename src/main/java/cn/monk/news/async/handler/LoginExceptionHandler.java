package cn.monk.news.async.handler;

import cn.monk.news.async.EventHandler;
import cn.monk.news.async.EventModel;
import cn.monk.news.async.EventType;
import cn.monk.news.model.Message;
import cn.monk.news.util.MailSender;
import cn.monk.news.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by 和尚 on 2019/1/12.
 */
@Component
public class LoginExceptionHandler implements EventHandler {
    @Autowired
    MessageService messageService;

    @Autowired
    MailSender mailSender;

    @Override
    public void doHandle(EventModel model) {
        Message message = new Message();
        message.setToId(model.getActorId());
        message.setContent("你上次的登陆IP异常");
        // SYSTEM ACCOUNT
        message.setFromId(3);
        message.setCreateDate(new Date());
        messageService.addMessage(message);

        Map<String, Object> map = new HashMap();
        map.put("username", model.getExt("username"));
        mailSender.sendWithHTMLTemplate(model.getExt("to"), "登陆异常",
                "mails/welcome.html", map);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LOGIN);
    }
}
