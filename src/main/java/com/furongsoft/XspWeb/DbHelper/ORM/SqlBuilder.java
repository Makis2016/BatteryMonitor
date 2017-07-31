package com.furongsoft.XspWeb.DbHelper.ORM;

import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.sql.TSqlBuilder;

public class SqlBuilder extends TSqlBuilder
{
    /**
     * 获取查询条件
     * 
     * @return 查询条件
     */
    public String getConditions()
    {
        String sql = toString();

        int pos = sql.indexOf("from");
        if (pos < 0)
            return null;

        return sql.substring(pos + "from".length()).trim();
    }
}