package cn.monk.news.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 和尚 on 2019/1/12.
 */
public class ViewObject {
    private Map<String, Object> objs = new HashMap<String, Object>();
    public void set(String key, Object value) {
        objs.put(key, value);
    }

    public Object get(String key) {
        return objs.get(key);
    }
}
