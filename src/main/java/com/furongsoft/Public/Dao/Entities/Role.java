package com.furongsoft.Public.Dao.Entities;

import org.hibernate.annotations.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Linyudui on 2016/6/29.
 */
@Entity(name = "Role")
@Table(name = "t_sys_role")
public class Role implements Serializable
{
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String remark;

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

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}