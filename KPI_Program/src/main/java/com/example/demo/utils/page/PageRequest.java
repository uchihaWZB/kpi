package com.example.demo.utils.page;

import java.io.Serializable;

/**
 * web层响应数据分页信息基类
 */
public class PageRequest implements Serializable {

    /** 每页项数 */
    private int itemsPerPage = 10;

    /** 当前页码 */
    private int page = 1;

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public PageRequest setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
        return this;
    }

    public int getPage() {
        return page;
    }

    public PageRequest setPage(int page) {
        this.page = page;
        return this;
    }

}
