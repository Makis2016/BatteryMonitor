package com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.ex;

/**
 * 在处理事务时遇到任何异常抛出此异常。
 * 
 * @since 2.0
 * @author redraiment
 */
public class TransactionException extends RuntimeException
{
    private static final long serialVersionUID = 8860441537702133352L;

    public TransactionException(String message, Throwable cause)
    {
        super(message, cause);
    }
}