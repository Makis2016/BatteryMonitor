package com.furongsoft.Public.Model;

/**
 * Created by LYD on 2016/7/16.
 */
public class PaginationResultByEuiGrid
{
    private int total;
    private Object rows;

    public PaginationResultByEuiGrid(int total, Object rows)
    {
        this.total = total;
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

    public Object getRows()
    {
        return rows;
    }

    public void setRows(Object rows)
    {
        this.rows = rows;
    }
}