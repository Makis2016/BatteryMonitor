package com.furongsoft.XspWeb.Security.Entities;

import java.io.Serializable;

public class User implements Serializable
{
    private static final long serialVersionUID = -9219447982065138915L;

    private Long id;
    private String login_id;
    private String password;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

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

}