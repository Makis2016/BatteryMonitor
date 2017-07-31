package com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.ex;

/**
 * 表不存在。
 * 
 * @since 1.0
 * @author redraiment
 */
public class IllegalTableNameException extends RuntimeException
{
    private static final long serialVersionUID = 514853640294542736L;

    public IllegalTableNameException(String tableName, Throwable e)
    {
        super(String.format("illegal table %s", tableName), e);
    }
}