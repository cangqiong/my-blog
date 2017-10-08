package com.cang.blog.model;

import javax.persistence.*;

@Table(name = "blog_event")
public class BlogEvent {
    /**
     * 事件ID
     */
    @Id
    private Integer id;

    /**
     * 事件名称
     */
    @Column(name = "event_name")
    private String eventName;

    /**
     * 事件描述
     */
    @Column(name = "event_desc")
    private String eventDesc;

    /**
     * 是否完成(1为完成，默认值0为未完成)
     */
    @Column(name = "is_finished")
    private Integer isFinished;

    /**
     * 是否删除(1为删除，默认值0为未删除))
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * 获取事件ID
     *
     * @return id - 事件ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置事件ID
     *
     * @param id 事件ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取事件名称
     *
     * @return event_name - 事件名称
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * 设置事件名称
     *
     * @param eventName 事件名称
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * 获取事件描述
     *
     * @return event_desc - 事件描述
     */
    public String getEventDesc() {
        return eventDesc;
    }

    /**
     * 设置事件描述
     *
     * @param eventDesc 事件描述
     */
    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    /**
     * 获取是否完成(1为完成，默认值0为未完成)
     *
     * @return is_finished - 是否完成(1为完成，默认值0为未完成)
     */
    public Integer getIsFinished() {
        return isFinished;
    }

    /**
     * 设置是否完成(1为完成，默认值0为未完成)
     *
     * @param isFinished 是否完成(1为完成，默认值0为未完成)
     */
    public void setIsFinished(Integer isFinished) {
        this.isFinished = isFinished;
    }

    /**
     * 获取是否删除(1为删除，默认值0为未删除))
     *
     * @return is_delete - 是否删除(1为删除，默认值0为未删除))
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除(1为删除，默认值0为未删除))
     *
     * @param isDelete 是否删除(1为删除，默认值0为未删除))
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}