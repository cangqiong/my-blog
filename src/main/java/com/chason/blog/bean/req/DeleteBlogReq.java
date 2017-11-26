package com.chason.blog.bean.req;

import javax.validation.constraints.NotNull;

/**
 * @author cang
 * @date 2017-11-26
 */
public class DeleteBlogReq {

    @NotNull( message = "博客ID不能为空" )
    private Integer blogId;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
}
