package com.chason.blog.bean.req;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author cang
 * @date 2017-11-26
 */
public class UpdateBlogReq implements Serializable {

    private static final long serialVersionUID = -388018342780351922L;

    @NotNull( message = "博客ID不能为空" )
    private Integer blogId;

    @NotNull
    @Size( min = 1, max = 64, message = "标题长度只能1到64位" )
    private String title;

    @NotEmpty( message = "博客不能为空" )
    private String content;

    private Integer cotentType;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCotentType() {
        return cotentType;
    }

    public void setCotentType(Integer cotentType) {
        this.cotentType = cotentType;
    }
}
