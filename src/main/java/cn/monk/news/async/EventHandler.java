package cn.monk.news.async;

import java.util.List;
/**
 * Created by 和尚 on 2019/1/12.
 */
public interface EventHandler {
    void doHandle(EventModel model);
    List<EventType> getSupportEventTypes();
}
