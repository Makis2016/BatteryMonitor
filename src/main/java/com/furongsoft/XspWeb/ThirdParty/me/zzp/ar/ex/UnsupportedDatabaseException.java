package com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.ex;

/**
 * 未找到相应的方言。
 * 
 * @since 1.0
 * @author redraiment
 */
public class UnsupportedDatabaseException extends RuntimeException
{
    private static final long serialVersionUID = 4308846959159821409L;

    public UnsupportedDatabaseException(String product)
    {
        super(String.format("Unsupported Database: %s", product));
    }
}