package com.furongsoft.XspWeb.DbHelper;

import java.io.Serializable;
import java.util.Collection;

/**
 * 定义页面类型
 * 
 * @author Alex
 */
public class Page implements Serializable
{
    private static final long serialVersionUID = 4135069385473973029L;

    /**
     * 当前页码
     */
    private int page;

    /**
     * 每页行数
     */
    private int rows;

    /**
     * 记录总数
     */
    private int total;

    /**
     * 页面数据
     */
    private Collection<?> data;

    public Page()
    {
    }

    public Page(int page, int rows)
    {
        this.page = page;
        this.rows = rows;
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getRows()
    {
        return rows;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public Collection<?> getData()
    {
        return data;
    }

    public void setData(Collection<?> data)
    {
        this.data = data;
    }
}