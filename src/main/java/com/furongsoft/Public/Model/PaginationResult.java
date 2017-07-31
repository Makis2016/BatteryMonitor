package com.furongsoft.Public.Model;

/**
 * Created by Linyudui on 2016/6/29.
 */
public class PaginationResult
{
    private int total;
    private int page;
    private int records;
    private Object rows;

    public PaginationResult(int total, int page, int records, Object rows)
    {
        this.total = total;
        this.page = page;
        this.records = records;
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

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getRecords()
    {
        return records;
    }

    public void setRecords(int records)
    {
        this.records = records;
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