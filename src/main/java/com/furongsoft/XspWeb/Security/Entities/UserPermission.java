package com.furongsoft.XspWeb.Security.Entities;

import java.io.Serializable;

public class UserPermission implements Serializable
{
    private static final long serialVersionUID = -6029776654052701633L;

    private String value;

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}