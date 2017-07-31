package com.furongsoft.Public.Model;


/**
 * Created by Linyudui on 2016/6/29.
 */
public class User
{
    private long id;
    private String name;
    private String login_id;
    private String password;
    private int starus;
    private long point1_id;
    private long point2_id;
    private long point3_id;
    private String email;
    private String tel_no;
    private String affiliated_institutions;
    private int sex;
    private String role_name;
    private long role_id;

    public String getLogin_id()
    {
        return login_id;
    }

    public void setLogin_id(String login_id)
    {
        this.login_id = login_id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getStarus()
    {
        return starus;
    }

    public void setStarus(int starus)
    {
        this.starus = starus;
    }

    public long getPoint1_id()
    {
        return point1_id;
    }

    public void setPoint1_id(long point1_id)
    {
        this.point1_id = point1_id;
    }

    public long getPoint2_id()
    {
        return point2_id;
    }

    public void setPoint2_id(long point2_id)
    {
        this.point2_id = point2_id;
    }

    public long getPoint3_id()
    {
        return point3_id;
    }

    public void setPoint3_id(long point3_id)
    {
        this.point3_id = point3_id;
    }

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

    public String getAffiliated_institutions()
    {
        return affiliated_institutions;
    }

    public void setAffiliated_institutions(String affiliated_institutions)
    {
        this.affiliated_institutions = affiliated_institutions;
    }

    public int getSex()
    {
        return sex;
    }

    public void setSex(int sex)
    {
        this.sex = sex;
    }

    public String getRole_name()
    {
        return role_name;
    }

    public void setRole_name(String role_name)
    {
        this.role_name = role_name;
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