package com.furongsoft.Public.Model;

import java.util.List;

/**
 * Created by Linyudui on 2016/7/20.
 */
public class Role
{
    private int id;
    private String name;
    private String remark;

    private String ids;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getIds()
    {
        return ids;
    }

    public void setIds(String ids)
    {
        this.ids = ids;
    }
}