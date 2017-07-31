package com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.ex;

/**
 * 连接数据库时遇到任何问题抛出此异常。
 * 
 * @since 1.0
 * @author redraiment
 */
public class DBOpenException extends RuntimeException
{
    private static final long serialVersionUID = -8014152416530366771L;

    public DBOpenException(Throwable cause)
    {
        super(cause);
    }
}