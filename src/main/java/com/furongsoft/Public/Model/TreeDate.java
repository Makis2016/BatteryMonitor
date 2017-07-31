package com.furongsoft.Public.Model;

import java.util.List;

/**
 * Created by Linyudui on 2016/7/13.
 */
public class TreeDate
{
    private long id;
    private long pid;
    private String name;
    private String charge_person;
    private String email;
    private String tel_no;
    private String ico_open;
    private String ico_close;
    private Boolean isParent;
    private Boolean open;
    private List<TreeDate> children;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getPid()
    {
        return pid;
    }

    public void setPid(long pid)
    {
        this.pid = pid;
    }

    public String getCharge_person()
    {
        return charge_person;
    }

    public void setCharge_person(String charge_person)
    {
        this.charge_person = charge_person;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTel_no()
    {
        return tel_no;
    }

    public void setTel_no(String tel_no)
    {
        this.tel_no = tel_no;
    }

    public String getIco_open()
    {
        return ico_open;
    }

    public void setIco_open(String ico_open)
    {
        this.ico_open = ico_open;
    }

    public String getIco_close()
    {
        return ico_close;
    }

    public void setIco_close(String ico_close)
    {
        this.ico_close = ico_close;
    }

    public Boolean getParent()
    {
        return isParent;
    }

    public void setParent(Boolean parent)
    {
        isParent = parent;
    }

    public Boolean getOpen()
    {
        return open;
    }

    public void setOpen(Boolean open)
    {
        this.open = open;
    }

    public List<TreeDate> getChildren()
    {
        return children;
    }

    public void setChildren(List<TreeDate> children)
    {
        this.children = children;
    }
}