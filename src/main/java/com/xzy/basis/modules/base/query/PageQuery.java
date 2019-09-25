package com.xzy.basis.modules.base.query;

import java.io.Serializable;

/**
 * @author xzy
 * @date 2019/9/2 16:10
 */
public class PageQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 页面，从1开始
     */
    private int pageNum;

    /**
     * 页面大小
     */
    private int pageSize;

    /**
     * 包含count查询
     */
    private boolean countSql = true;

    /**
     * 分页合理化参数，默认值为false。当该参数设置为true时，pageNum<=0时，会查询第一页，
     * pageNum>pages（超过总数时），会查询最后一页。默认false时，直接根据参数查询。
     */
    private boolean reasonable;

    /**
     * 当设置为true时，如果pageNum设置为0（或者RowBounds的limit=0），就不执行分页，返回全部结果
     */
    private boolean pageSizeZero = true;

    /**
     * 排序
     */
    private String orderBy;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isCountSql() {
        return countSql;
    }

    public void setCountSql(boolean countSql) {
        this.countSql = countSql;
    }

    public boolean isReasonable() {
        return reasonable;
    }

    public void setReasonable(boolean reasonable) {
        this.reasonable = reasonable;
    }

    public boolean isPageSizeZero() {
        return pageSizeZero;
    }

    public void setPageSizeZero(boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        return "PageQuery{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", countSql=" + countSql +
                ", reasonable=" + reasonable +
                ", pageSizeZero=" + pageSizeZero +
                ", orderBy='" + orderBy + '\'' +
                '}';
    }
}
