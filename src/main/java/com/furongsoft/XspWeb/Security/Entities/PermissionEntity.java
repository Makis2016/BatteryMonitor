package com.furongsoft.XspWeb.Security.Entities;

import java.io.Serializable;

public class PermissionEntity implements Serializable
{
    private static final long serialVersionUID = 2603002645584283474L;

    private String name;
    private String permission;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPermission()
    {
        return permission;
    }

    public void setPermission(String permission)
    {
        this.permission = permission;
    }
}