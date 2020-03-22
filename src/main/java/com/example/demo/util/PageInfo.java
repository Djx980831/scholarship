package com.example.demo.util;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-22 22:55
 */
import java.io.Serializable;

public class PageInfo implements Serializable {
    private static final long serialVersionUID = 648647922960473584L;
    private long total;
    private long totalPage;
    private int page;
    private int size;

    public PageInfo() {
    }

    public PageInfo(long total, int page, int size) {
        this.total = total;
        this.page = page;
        this.size = size;
        if (0L == total % (long)size) {
            this.totalPage = total / Long.valueOf(size + "");
        } else {
            this.totalPage = total / (long)size + 1L;
        }

    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(final long total) {
        this.total = total;
    }

    public long getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(final long totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(final int page) {
        this.page = page;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(final int size) {
        this.size = size;
    }
}
