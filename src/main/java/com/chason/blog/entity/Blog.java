package com.chason.blog.entity;

import java.util.Date;
import javax.persistence.*;

public class Blog {
    /**
     * 博客ID
     */
    @Id
    @Column(name = "blog_id")
    private Integer blogId;

    /**
     * 博客标题
     */
    @Column(name = "blog_title")
    private String blogTitle;

    /**
     * 博客状态(0:新建,1:发表,2:个人)
     */
    @Column(name = "blog_status")
    private String blogStatus;

    /**
     * 是否是转载内容
     */
    @Column(name = "is_reproduced")
    private Boolean isReproduced;

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
     * 删除状态(0:未删除,1:已删除)
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    /**
     * 博客内容
     */
    @Column(name = "blog_content")
    private String blogContent;

    /**
     * 获取博客ID
     *
     * @return blog_id - 博客ID
     */
    public Integer getBlogId() {
        return blogId;
    }

    /**
     * 设置博客ID
     *
     * @param blogId 博客ID
     */
    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    /**
     * 获取博客标题
     *
     * @return blog_title - 博客标题
     */
    public String getBlogTitle() {
        return blogTitle;
    }

    /**
     * 设置博客标题
     *
     * @param blogTitle 博客标题
     */
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    /**
     * 获取博客状态(0:新建,1:发表,2:个人)
     *
     * @return blog_status - 博客状态(0:新建,1:发表,2:个人)
     */
    public String getBlogStatus() {
        return blogStatus;
    }

    /**
     * 设置博客状态(0:新建,1:发表,2:个人)
     *
     * @param blogStatus 博客状态(0:新建,1:发表,2:个人)
     */
    public void setBlogStatus(String blogStatus) {
        this.blogStatus = blogStatus;
    }

    /**
     * 获取是否是转载内容
     *
     * @return is_reproduced - 是否是转载内容
     */
    public Boolean getIsReproduced() {
        return isReproduced;
    }

    /**
     * 设置是否是转载内容
     *
     * @param isReproduced 是否是转载内容
     */
    public void setIsReproduced(Boolean isReproduced) {
        this.isReproduced = isReproduced;
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
     * 获取删除状态(0:未删除,1:已删除)
     *
     * @return is_deleted - 删除状态(0:未删除,1:已删除)
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置删除状态(0:未删除,1:已删除)
     *
     * @param isDeleted 删除状态(0:未删除,1:已删除)
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取博客内容
     *
     * @return blog_content - 博客内容
     */
    public String getBlogContent() {
        return blogContent;
    }

    /**
     * 设置博客内容
     *
     * @param blogContent 博客内容
     */
    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}