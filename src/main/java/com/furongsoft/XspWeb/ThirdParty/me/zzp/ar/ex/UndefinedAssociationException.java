package com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.ex;

/**
 * 遇到未定义的关联时抛出此异常。
 * 
 * @since 1.0
 * @author redraiment
 */
public class UndefinedAssociationException extends RuntimeException
{
    private static final long serialVersionUID = -3904367024939494415L;

    public UndefinedAssociationException(String name)
    {
        super(String.format("undefined association name: %s", name));
    }
}