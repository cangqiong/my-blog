package com.chason.blog.util;

import com.chason.blog.bean.req.PageReq;
import org.apache.ibatis.session.RowBounds;

/**
 * 分页工具类
 *
 * @author cang
 * @date 2017-11-26
 */
public class PageUtils {

    /**
     * 获取Mybatis的行查询的区间
     *
     * @param pageReq
     * @return
     */
    public static RowBounds getRowBounds(PageReq pageReq) {

        // 没有分页信息，默认返回前10条数据
        if (pageReq == null) {
            return new RowBounds(0, 10);
        }
        if (pageReq.getPageNum() == null || pageReq.getPageNum() <= 0) {
            pageReq.setPageNum(1);
        }

        if (pageReq.getPageSize() == null) {
            pageReq.setPageSize(10);
        }

        int offset = (pageReq.getPageNum() - 1) * pageReq.getPageSize();
        int limit = offset + pageReq.getPageSize();

        return new RowBounds(offset, limit);
    }
}
