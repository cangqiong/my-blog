package com.chason.blog.entity;

import java.util.Date;
import javax.persistence.*;

public class Image {
    /**
     * 图片ID
     */
    @Id
    @Column(name = "image_id")
    private Integer imageId;

    /**
     * 图片上传类别(blog、life、temp)
     */
    @Column(name = "image_type")
    private String imageType;

    /**
     * 图片的相对路径
     */
    @Column(name = "relative_path")
    private String relativePath;

    /**
     * 上传时间
     */
    @Column(name = "upload_time")
    private Date uploadTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    /**
     * 获取图片ID
     *
     * @return image_id - 图片ID
     */
    public Integer getImageId() {
        return imageId;
    }

    /**
     * 设置图片ID
     *
     * @param imageId 图片ID
     */
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    /**
     * 获取图片上传类别(blog、life、temp)
     *
     * @return image_type - 图片上传类别(blog、life、temp)
     */
    public String getImageType() {
        return imageType;
    }

    /**
     * 设置图片上传类别(blog、life、temp)
     *
     * @param imageType 图片上传类别(blog、life、temp)
     */
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    /**
     * 获取图片的相对路径
     *
     * @return relative_path - 图片的相对路径
     */
    public String getRelativePath() {
        return relativePath;
    }

    /**
     * 设置图片的相对路径
     *
     * @param relativePath 图片的相对路径
     */
    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    /**
     * 获取上传时间
     *
     * @return upload_time - 上传时间
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * 设置上传时间
     *
     * @param uploadTime 上传时间
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
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