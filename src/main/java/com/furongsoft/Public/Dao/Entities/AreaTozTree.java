package com.furongsoft.Public.Dao.Entities;

import java.util.List;

/**
 * Created by Linyudui on 2016/6/29.
 */
public class AreaTozTree
{
    private int id;
    private int pid;
    private String name;
    private Boolean open = true;
    private String icon;
    private Boolean isParent;
    private List<AreaTozTree> children;
    private String iconClose;
    private String iconOpen;

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public Boolean getParent()
    {
        return isParent;
    }

    public void setParent(Boolean parent)
    {
        isParent = parent;
    }

    public String getIconClose()
    {
        return iconClose;
    }

    public void setIconClose(String iconClose)
    {
        this.iconClose = iconClose;
    }

    public String getIconOpen()
    {
        return iconOpen;
    }

    public void setIconOpen(String iconOpen)
    {
        this.iconOpen = iconOpen;
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

    public int getPid()
    {
        return pid;
    }

    public void setPid(int pid)
    {
        this.pid = pid;
    }

    public List<AreaTozTree> getChildren()
    {
        return children;
    }

    public void setChildren(List<AreaTozTree> children)
    {
        this.children = children;
    }

    public Boolean getOpen()
    {
        return open;
    }

    public void setOpen(Boolean open)
    {
        this.open = open;
    }
}