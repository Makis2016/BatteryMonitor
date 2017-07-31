package com.furongsoft.Public.Dao.Entities;

/**
 * Created by Administrator on 2016/8/18.
 */
public class Device
{
    private long id;
    private String name;
    private String type;
    private String config;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getConfig()
    {
        return config;
    }

    public void setConfig(String config)
    {
        this.config = config;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}