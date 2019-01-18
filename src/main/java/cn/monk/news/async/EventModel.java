package cn.monk.news.async;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by 和尚 on 2019/1/12.
 */
public class EventModel {
    private int actorId;
    private int entityId;
    private int entityType;
    private int entityOwnerId;
    private Map<String, String> exts = new HashMap<>();
    private EventType type;


    public EventModel() {

    }
    public EventModel(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }

    public EventModel setType(EventType type) {
        this.type = type;
        return this;
    }

    public int getActorId() {
        return actorId;
    }

    public EventModel setActorId(int actorId) {
        this.actorId = actorId;
        return this;
    }

    public int getEntityId() {
        return entityId;
    }

    public EventModel setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public int getEntityType() {
        return entityType;
    }

    public EventModel setEntityType(int entityType) {
        this.entityType = entityType;
        return this;
    }

    public int getEntityOwnerId()
    {

        return entityOwnerId;
    }

    public EventModel setEntityOwnerId(int entityOwnerId) {
        this.entityOwnerId = entityOwnerId;
        return this;
    }

    public String getExt(String name) {
        return exts.get(name);
    }

    public EventModel setExts(String name, String value) {
        exts.put(name, value);
        return this;
    }
}
