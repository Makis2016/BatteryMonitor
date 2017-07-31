package com.furongsoft.XspWeb.Security.Entities;

import java.io.Serializable;

public class UserRole implements Serializable
{
    private static final long serialVersionUID = -6789915664585494884L;

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}