package com.chason.blog.entity;

import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名(唯一)
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码(密文存储)
     */
    private String password;

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
     * 是否被删除(1为已删除，0为未删除)
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名(唯一)
     *
     * @return user_name - 用户名(唯一)
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名(唯一)
     *
     * @param userName 用户名(唯一)
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码(密文存储)
     *
     * @return password - 密码(密文存储)
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码(密文存储)
     *
     * @param password 密码(密文存储)
     */
    public void setPassword(String password) {
        this.password = password;
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
     * 获取是否被删除(1为已删除，0为未删除)
     *
     * @return is_deleted - 是否被删除(1为已删除，0为未删除)
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否被删除(1为已删除，0为未删除)
     *
     * @param isDeleted 是否被删除(1为已删除，0为未删除)
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}