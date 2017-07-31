package com.furongsoft.XspWeb.Common;

/**
 * 定义错误类型
 * 
 * @author Alex
 */
public class Errno
{
    public enum AResult {
        S_OK, // 正确执行
        E_FAIL, // 执行失败
        E_TERMINATED, // 用户打断操作
        E_OUTOFMEMORY, // 内存不足
        E_INVALIDARG, // 错误参数
        E_TIMEOUT, // 超时
        E_ALREADY_EXISTS, // 已经存在
        E_DOES_NOT_EXISTS // 不存在
    }

    public static boolean SUCCEEDED(AResult value)
    {
        return (value.equals(AResult.S_OK));
    }

    public static boolean FAILED(AResult value)
    {
        return (!value.equals(AResult.S_OK));
    }
}