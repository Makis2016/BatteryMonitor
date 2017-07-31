package com.furongsoft.Public.Dao.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Linyudui on 2016/6/29.
 */
@Entity(name = "Permission")
@Table(name = "t_sys_permission")
public class Permission implements Serializable
{
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String value;
    private String remarks;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
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

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }
}