package com.furongsoft.Public.Model;

/**
 * Created by Linyudui on 2016/7/17.
 */
public class Permissions
{
    private int id;
    private String name;
    private String value;
    private String type;
    private String remarks;
    private String role_names;
    private long role_id;
    private long resources_id;

    public long getResources_id()
    {
        return resources_id;
    }

    public void setResources_id(long resources_id)
    {
        this.resources_id = resources_id;
    }

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

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRole_names()
    {
        return role_names;
    }

    public void setRole_names(String role_names)
    {
        this.role_names = role_names;
    }

    public long getRole_id()
    {
        return role_id;
    }

    public void setRole_id(long role_id)
    {
        this.role_id = role_id;
    }
}