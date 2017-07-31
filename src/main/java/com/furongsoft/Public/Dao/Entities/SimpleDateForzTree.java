package com.furongsoft.Public.Dao.Entities;

/**
 * Created by Linyudui on 2016/6/30.
 */
public class SimpleDateForzTree
{
    private long id;
    private long pid;
    private String area_name;
    private String charge_person;
    private String email;
    private String tel_no;
    private String ico_open;
    private String ico_close;
    private Boolean isParent = false;
    private Boolean open = false;
    private String iconSkin;

    public String getIconSkin()
    {
        return iconSkin;
    }

    public void setIconSkin(String iconSkin)
    {
        this.iconSkin = iconSkin;
    }

    public long getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public long getPid()
    {
        return pid;
    }

    public void setPid(int pid)
    {
        this.pid = pid;
    }

    public String getName()
    {
        return area_name;
    }

    public void setName(String name)
    {
        this.area_name = name;
    }

    public String getTel_no()
    {
        return tel_no;
    }

    public void setTel_no(String tel_no)
    {
        this.tel_no = tel_no;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCharge_person()
    {
        return charge_person;
    }

    public void setCharge_person(String charge_person)
    {
        this.charge_person = charge_person;
    }

    public void setId(long id)
    {
        this.id = id;
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

    public void setPid(long pid)
    {
        this.pid = pid;
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