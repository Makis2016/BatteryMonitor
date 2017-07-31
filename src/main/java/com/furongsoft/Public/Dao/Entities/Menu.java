package com.furongsoft.Public.Dao.Entities;

/**
 * Created by LYD on 2016/7/16.
 */
public class Menu
{
    private long id;
    private String name;
    private String url;
    private String address;
    private long parent_id;
    private long order_no;
    private long type;
    private String remark;
    private int start;
    private String permission_ids;

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

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public long getParent_id()
    {
        return parent_id;
    }

    public void setParent_id(long parent_id)
    {
        this.parent_id = parent_id;
    }

    public long getOrder_no()
    {
        return order_no;
    }

    public void setOrder_no(long order_no)
    {
        this.order_no = order_no;
    }

    public long getType()
    {
        return type;
    }

    public void setType(long type)
    {
        this.type = type;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public int getStart()
    {
        return start;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPermission_ids()
    {
        return permission_ids;
    }

    public void setPermission_ids(String permission_ids)
    {
        this.permission_ids = permission_ids;
    }
}