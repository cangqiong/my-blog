package com.chason.blog.entity;

import javax.persistence.*;

public class Comment {
    /**
     * 评论ID
     */
    @Id
    @Column(name = "comment_id")
    private Integer commentId;

    /**
     * 评论对应的博客ID
     */
    @Column(name = "blog_id")
    private Integer blogId;

    /**
     * 评论目标评论的ID，如为null则只针对博客进行评论
     */
    @Column(name = "target_id")
    private Integer targetId;

    /**
     * 评论长度(最长为255)
     */
    @Column(name = "comment_content")
    private String commentContent;

    /**
     * 复核状态(0为待复核，-1为复核不通过，1为复核通过)
     */
    @Column(name = "check_status")
    private String checkStatus;

    /**
     * 是否显示(默认为显示)
     */
    @Column(name = "is_display")
    private Boolean isDisplay;

    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    /**
     * 获取评论ID
     *
     * @return comment_id - 评论ID
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 设置评论ID
     *
     * @param commentId 评论ID
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取评论对应的博客ID
     *
     * @return blog_id - 评论对应的博客ID
     */
    public Integer getBlogId() {
        return blogId;
    }

    /**
     * 设置评论对应的博客ID
     *
     * @param blogId 评论对应的博客ID
     */
    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    /**
     * 获取评论目标评论的ID，如为null则只针对博客进行评论
     *
     * @return target_id - 评论目标评论的ID，如为null则只针对博客进行评论
     */
    public Integer getTargetId() {
        return targetId;
    }

    /**
     * 设置评论目标评论的ID，如为null则只针对博客进行评论
     *
     * @param targetId 评论目标评论的ID，如为null则只针对博客进行评论
     */
    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    /**
     * 获取评论长度(最长为255)
     *
     * @return comment_content - 评论长度(最长为255)
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 设置评论长度(最长为255)
     *
     * @param commentContent 评论长度(最长为255)
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
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
     * 获取是否显示(默认为显示)
     *
     * @return is_display - 是否显示(默认为显示)
     */
    public Boolean getIsDisplay() {
        return isDisplay;
    }

    /**
     * 设置是否显示(默认为显示)
     *
     * @param isDisplay 是否显示(默认为显示)
     */
    public void setIsDisplay(Boolean isDisplay) {
        this.isDisplay = isDisplay;
    }

    /**
     * 获取是否删除
     *
     * @return is_deleted - 是否删除
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除
     *
     * @param isDeleted 是否删除
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}