package com.furongsoft.Public.Dao.RowMapper;

import com.furongsoft.Public.Dao.Entities.SimpleDateForzTree;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/10/21.
 */
public class AreaRowMapper implements RowMapper
{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        SimpleDateForzTree simpleDateForzTree = new SimpleDateForzTree();
        simpleDateForzTree.setName(rs.getString("area_name"));
        simpleDateForzTree.setPid(rs.getLong("pid"));
        simpleDateForzTree.setId(rs.getLong("id"));
        return simpleDateForzTree;
    }
}