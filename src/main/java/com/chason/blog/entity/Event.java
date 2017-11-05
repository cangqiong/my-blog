package com.chason.blog.entity;

import java.util.Date;
import javax.persistence.*;

public class Event {
    /**
     * 事件ID
     */
    @Id
    @Column(name = "event_id")
    private Integer eventId;

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
    private Boolean isFinished;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否删除(1为删除，默认值0为未删除))
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    /**
     * 获取事件ID
     *
     * @return event_id - 事件ID
     */
    public Integer getEventId() {
        return eventId;
    }

    /**
     * 设置事件ID
     *
     * @param eventId 事件ID
     */
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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
    public Boolean getIsFinished() {
        return isFinished;
    }

    /**
     * 设置是否完成(1为完成，默认值0为未完成)
     *
     * @param isFinished 是否完成(1为完成，默认值0为未完成)
     */
    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否删除(1为删除，默认值0为未删除))
     *
     * @return is_deleted - 是否删除(1为删除，默认值0为未删除))
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除(1为删除，默认值0为未删除))
     *
     * @param isDeleted 是否删除(1为删除，默认值0为未删除))
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}