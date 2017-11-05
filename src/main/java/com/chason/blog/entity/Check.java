package com.chason.blog.entity;

import java.util.Date;
import javax.persistence.*;

public class Check {
    /**
     * 复核ID
     */
    @Id
    @Column(name = "check_id")
    private Integer checkId;

    /**
     * 复核类型
     */
    @Column(name = "check_type")
    private String checkType;

    /**
     * 复核目标ID
     */
    @Column(name = "target_id")
    private Integer targetId;

    /**
     * 复核状态(0为待复核，-1为复核不通过，1为复核通过)
     */
    @Column(name = "check_status")
    private String checkStatus;

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
     * 复核目标内容
     */
    @Column(name = "target_content")
    private String targetContent;

    /**
     * 获取复核ID
     *
     * @return check_id - 复核ID
     */
    public Integer getCheckId() {
        return checkId;
    }

    /**
     * 设置复核ID
     *
     * @param checkId 复核ID
     */
    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    /**
     * 获取复核类型
     *
     * @return check_type - 复核类型
     */
    public String getCheckType() {
        return checkType;
    }

    /**
     * 设置复核类型
     *
     * @param checkType 复核类型
     */
    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    /**
     * 获取复核目标ID
     *
     * @return target_id - 复核目标ID
     */
    public Integer getTargetId() {
        return targetId;
    }

    /**
     * 设置复核目标ID
     *
     * @param targetId 复核目标ID
     */
    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    /**
     * 获取复核状态(0为待复核，-1为复核不通过，1为复核通过)
     *
     * @return check_status - 复核状态(0为待复核，-1为复核不通过，1为复核通过)
     */
    public String getCheckStatus() {
        return checkStatus;
    }

    /**
     * 设置复核状态(0为待复核，-1为复核不通过，1为复核通过)
     *
     * @param checkStatus 复核状态(0为待复核，-1为复核不通过，1为复核通过)
     */
    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
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
     * 获取复核目标内容
     *
     * @return target_content - 复核目标内容
     */
    public String getTargetContent() {
        return targetContent;
    }

    /**
     * 设置复核目标内容
     *
     * @param targetContent 复核目标内容
     */
    public void setTargetContent(String targetContent) {
        this.targetContent = targetContent;
    }
}