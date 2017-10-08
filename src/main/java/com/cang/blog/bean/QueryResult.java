package com.cang.blog.bean;

import java.util.List;

/**
 * @author cang
 * @date 2017-10-08
 */
public class QueryResult<T> {

    // 数据总条数
    private int count;
    // 返回记录
    private List<T> records;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
