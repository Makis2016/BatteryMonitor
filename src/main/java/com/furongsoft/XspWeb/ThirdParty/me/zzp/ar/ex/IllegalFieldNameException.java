package com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.ex;

/**
 * 列不存在。
 * 
 * @since 1.0
 * @author redraiment
 */
public class IllegalFieldNameException extends RuntimeException
{
    private static final long serialVersionUID = -5659693313774724946L;

    public IllegalFieldNameException(String fieldName)
    {
        super(String.format("illegal field %s", fieldName));
    }

    public IllegalFieldNameException(String fieldName, Throwable cause)
    {
        super(String.format("illegal field %s", fieldName), cause);
    }
}