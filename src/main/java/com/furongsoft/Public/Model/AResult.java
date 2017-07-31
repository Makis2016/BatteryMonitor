package com.furongsoft.Public.Model;

import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.Utils.StringUtils;

import javax.sound.midi.Track;

/**
 * Created by Linyudui on 2016/5/25.
 */
public class AResult
{
    private String message;
    private Integer code;
    private Object data;

    public AResult(String message, Integer code, Object data)
    {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }
}