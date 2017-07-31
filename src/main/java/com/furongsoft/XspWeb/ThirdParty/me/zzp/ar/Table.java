package com.furongsoft.XspWeb.ThirdParty.me.zzp.ar;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.ex.IllegalFieldNameException;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.ex.SqlExecuteException;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.sql.SqlBuilder;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.sql.TSqlBuilder;

/**
 * 表对象。
 * 
 * @since 1.0
 * @author redraiment
 */
public final class Table
{
    final DB dbo;
    final String name;
    final Map<String, Integer> columns;
    Map<String, String> properties;
    final Map<String, Association> relations;
    final Map<String, Lambda> hooks;
    final String primaryKey;

    private String foreignTable;
    private final Map<String, Integer> foreignKeys = new HashMap<>();

    Table(
        DB dbo,
        String name,
        Map<String, Integer> columns,
        Map<String, Association> relations,
        Map<String, Lambda> hooks)
    {
        this.dbo = dbo;
        this.name = name;
        this.columns = columns;
        this.relations = relations;
        this.hooks = hooks;
        this.primaryKey = name.concat(".id");

        initProperties();
    }

    /**
     * 初始化属性列表
     */
    void initProperties()
    {
        if (columns == null)
            return;

        this.properties = new HashMap<String, String>();
        for (String key : columns.keySet()) {
            String propertyKey = JdbcUtils
                .convertUnderscoreNameToPropertyName(key.toLowerCase());
            properties.put(key, propertyKey);
        }
    }

    /**
     * 继承给定的JavaBean，扩展Record对象的get和set方法。
     * 
     * @param bean
     *            希望被继承的JavaBean
     * @return 返回Table自身
     * @since 2.3
     */
    public Table extend(Object bean)
    {
        Class<?> type = bean.getClass();
        for (Method method : type.getDeclaredMethods()) {
            Class<?> returnType = method.getReturnType();
            Class<?>[] params = method.getParameterTypes();
            String key = method.getName();

            if (params.length == 2 && key.length() > 3 && (key
                .startsWith("get") || key.startsWith("set")) && params[0]
                    .isAssignableFrom(Record.class) && params[1]
                        .isAssignableFrom(Object.class) && Object.class
                            .isAssignableFrom(returnType)) {
                key = key.replaceAll("(?=[A-Z])", "_").toLowerCase();
                hooks.put(key, new Lambda(bean, method));
            }
        }

        return this;
    }

    public Map<String, Integer> getColumns()
    {
        return Collections.unmodifiableMap(columns);
    }

    /* Association */
    private Association assoc(String name, boolean onlyOne, boolean ancestor)
    {
        name = DB.parseKeyParameter(name);
        Association assoc = new Association(relations, name, onlyOne, ancestor);
        relations.put(name, assoc);
        return assoc;
    }

    public Association belongsTo(String name)
    {
        return assoc(name, true, false);
    }

    public Association hasOne(String name)
    {
        return assoc(name, true, true);
    }

    public Association hasMany(String name)
    {
        return assoc(name, false, true);
    }

    public Association hasAndBelongsToMany(String name)
    {
        return assoc(name, false, false);
    }

    private String[] getForeignKeys()
    {
        List<String> conditions = new ArrayList<>();
        for (Map.Entry<String, Integer> e : foreignKeys.entrySet()) {
            conditions.add(
                String.format("%s.%s = %d", name, e.getKey(), e.getValue()));
        }
        return conditions.toArray(new String[0]);
    }

    public Table constrain(String key, int id)
    {
        foreignKeys.put(DB.parseKeyParameter(key), id);
        return this;
    }

    public Table join(String table)
    {
        this.foreignTable = table;
        return this;
    }

    /* CRUD */
    public Record create(Object... args)
    {
        Map<String, Object> data = new HashMap<>();
        data.putAll(foreignKeys);
        for (int i = 0; i < args.length; i += 2) {
            String key = DB.parseKeyParameter(args[i].toString());
            if (!columns.containsKey(key)) {
                throw new IllegalFieldNameException(key);
            }
            Object value = args[i + 1];
            data.put(key, value);
        }

        String[] fields = new String[data.size()];
        int[] types = new int[data.size()];
        Object[] values = new Object[data.size()];
        int index = 0;
        for (Map.Entry<String, Object> e : data.entrySet()) {
            fields[index] = e.getKey();
            types[index] = columns.get(e.getKey());
            values[index] = e.getValue();
            index++;
        }

        SqlBuilder sql = new TSqlBuilder();
        sql.insert().into(name).values(fields);
        PreparedStatement call = dbo.prepare(sql.toString(), values, types);
        try {
            int id = 0;
            if (call.executeUpdate() > 0) {
                ResultSet rs = call.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    id = rs.getInt(1);
                    rs.close();
                }
            }
            return id > 0 ? find(id) : null;
        }
        catch (SQLException e) {
            throw new SqlExecuteException(sql.toString(), e);
        }
        finally {
            dbo.close(call);
        }
    }

    public <T> T create(RowMapper<T> rowMapper, Object... args)
    {
        Map<String, Object> data = new HashMap<>();
        data.putAll(foreignKeys);
        for (int i = 0; i < args.length; i += 2) {
            String key = DB.parseKeyParameter(args[i].toString());
            if (!columns.containsKey(key)) {
                throw new IllegalFieldNameException(key);
            }
            Object value = args[i + 1];
            data.put(key, value);
        }

        String[] fields = new String[data.size()];
        int[] types = new int[data.size()];
        Object[] values = new Object[data.size()];
        int index = 0;
        for (Map.Entry<String, Object> e : data.entrySet()) {
            fields[index] = e.getKey();
            types[index] = columns.get(e.getKey());
            values[index] = e.getValue();
            index++;
        }

        SqlBuilder sql = new TSqlBuilder();
        sql.insert().into(name).values(fields);
        PreparedStatement call = dbo.prepare(sql.toString(), values, types);
        try {
            int id = 0;
            if (call.executeUpdate() > 0) {
                ResultSet rs = call.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    id = rs.getInt(1);
                    rs.close();
                }
            }
            return id > 0 ? find(id, rowMapper) : null;
        }
        catch (SQLException e) {
            throw new SqlExecuteException(sql.toString(), e);
        }
        finally {
            dbo.close(call);
        }
    }

    /**
     * 根据现有的Record创建新的Record. 为跨数据库之间导数据提供便捷接口；同时也方便根据模板创建多条相似的纪录。
     * 
     * @param o
     *            Record对象
     * @return 根据参数创建的新的Record对象
     */
    public Record create(Record o)
    {
        List<Object> params = new LinkedList<>();
        for (String key : columns.keySet()) {
            if (!foreignKeys.containsKey(key)) {
                params.add(key);
                params.add(o.get(key));
            }
        }
        return create(params.toArray());
    }

    public <T> T create(T o, BeanPropertyRowMapper<T> rowMapper)
    {
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(o);
        List<Object> params = new LinkedList<>();
        for (String key : columns.keySet()) {
            if (!foreignKeys.containsKey(key)) {
                String propertyKey = properties.get(key);
                params.add(key);
                params.add(
                    bw.isReadableProperty(propertyKey) ? bw
                        .getPropertyValue(propertyKey) : null);
            }
        }
        return create(rowMapper, params.toArray());
    }

    public void update(Record record)
    {
        String[] fields = new String[columns.size()];
        int[] types = new int[columns.size()];
        Object[] values = new Object[columns.size()];
        int index = 0;
        for (String column : columns.keySet()) {
            fields[index] = column;
            types[index] = columns.get(column);
            values[index] = record.get(column);
            index++;
        }

        SqlBuilder sql = new TSqlBuilder();
        Object id = record.get("id");
        sql.update(name).set(fields).where(
            String.format("%s = %s", primaryKey, id.toString()));
        dbo.execute(sql.toString(), values, types);
    }

    public <T> void update(T record, BeanPropertyRowMapper<T> rowMapper)
    {
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(record);
        String[] fields = new String[columns.size()];
        int[] types = new int[columns.size()];
        Object[] values = new Object[columns.size()];
        int index = 0;
        for (String column : columns.keySet()) {
            fields[index] = column;
            types[index] = columns.get(column);
            String propertyKey = properties.get(column);
            values[index] = bw.isReadableProperty(propertyKey) ? bw
                .getPropertyValue(propertyKey) : null;
            index++;
        }

        SqlBuilder sql = new TSqlBuilder();
        Object id = bw.isReadableProperty("id") ? bw
            .getPropertyValue("id") : null;
        sql.update(name).set(fields).where(
            String.format("%s = %s", primaryKey, id.toString()));
        dbo.execute(sql.toString(), values, types);
    }

    public void delete(Record record)
    {
        Object id = record.get("id");
        SqlBuilder sql = new TSqlBuilder();
        sql.delete().from(name).where(
            String.format("%s = %s", primaryKey, id.toString()));
        dbo.execute(sql.toString());
    }

    public void delete(Object id)
    {
        SqlBuilder sql = new TSqlBuilder();
        sql.delete().from(name).where(
            String.format("%s = %s", primaryKey, id.toString()));
        dbo.execute(sql.toString());
    }

    public void purge()
    {
        // TODO: need enhancement
        for (Record record : all()) {
            delete(record);
        }
    }

    List<Record> query(SqlBuilder sql, Object... args)
    {
        List<Record> records = new LinkedList<>();
        ResultSet rs = dbo.query(sql.toString(), args);
        try {
            ResultSetMetaData meta = rs.getMetaData();
            while (rs.next()) {
                Map<String, Object> values = new LinkedHashMap<>();
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    String label = DB.parseKeyParameter(meta.getColumnLabel(i));
                    values.put(label, rs.getObject(label));
                }
                records.add(new Record(this, values));
            }
        }
        catch (SQLException e) {
            throw new SqlExecuteException(sql.toString(), e);
        }
        finally {
            dbo.close(rs);
        }
        return records;
    }

    <T> List<T> query(SqlBuilder sql, RowMapper<T> rowMapper, Object... args)
    {
        List<T> records = new LinkedList<>();
        ResultSet rs = dbo.query(sql.toString(), args);
        try {
            int rowNum = 0;
            while (rs.next()) {
                records.add(rowMapper.mapRow(rs, rowNum++));
            }
        }
        catch (SQLException e) {
            throw new SqlExecuteException(sql.toString(), e);
        }
        finally {
            dbo.close(rs);
        }
        return records;
    }

    public Query select(String... columns)
    {
        Query sql = new Query(this);
        if (columns == null || columns.length == 0) {
            sql.select(String.format("%s.*", name));
        }
        else {
            sql.select(columns);
        }
        sql.from(name);
        if (foreignTable != null && !foreignTable.isEmpty()) {
            sql.join(foreignTable);
        }
        if (!foreignKeys.isEmpty()) {
            for (String condition : getForeignKeys()) {
                sql.where(condition);
            }
        }
        // 有问题sql.orderBy(primaryKey)
        return sql.orderBy(columns);
    }

    public Record first()
    {
        return select().limit(1).one();
    }

    public <T> T first(RowMapper<T> rowMapper)
    {
        return select().limit(1).one(rowMapper);
    }

    public Record first(String condition, Object... args)
    {
        return select().where(condition).limit(1).one(args);
    }

    public <T> T first(RowMapper<T> rowMapper, String condition, Object... args)
    {
        return select().where(condition).limit(1).one(rowMapper, args);
    }

    public Record last()
    {
        return select().orderBy(primaryKey.concat(" desc")).limit(1).one();
    }

    public <T> T last(RowMapper<T> rowMapper)
    {
        return select()
            .orderBy(primaryKey.concat(" desc")).limit(1).one(rowMapper);
    }

    public Record last(String condition, Object... args)
    {
        return select()
            .where(condition).orderBy(primaryKey.concat(" desc")).limit(1)
            .one(args);
    }

    public <T> T last(RowMapper<T> rowMapper, String condition, Object... args)
    {
        return select()
            .where(condition).orderBy(primaryKey.concat(" desc")).limit(1)
            .one(rowMapper, args);
    }

    public Record find(long id)
    {
        return first(primaryKey.concat(" = ?"), id);
    }

    public <T> T find(long id, RowMapper<T> rowMapper)
    {
        return first(rowMapper, primaryKey.concat(" = ?"), id);
    }

    /**
     * 根据指定列，返回符合条件的第一条记录.
     * 
     * @param key
     *            要匹配的列名
     * @param value
     *            要匹配的值
     * @return 返回符合条件的第一条记录
     */
    public Record findA(String key, Object value)
    {
        key = DB.parseKeyParameter(key);
        if (value != null) {
            return first(key.concat(" = ?"), value);
        }
        else {
            return first(key.concat(" is null"));
        }
    }

    public <T> T findA(String key, Object value, RowMapper<T> rowMapper)
    {
        key = DB.parseKeyParameter(key);
        if (value != null) {
            return first(rowMapper, key.concat(" = ?"), value);
        }
        else {
            return first(rowMapper, key.concat(" is null"));
        }
    }

    public List<Record> findBy(String key, Object value)
    {
        key = DB.parseKeyParameter(key);
        if (value != null) {
            return where(key.concat(" = ?"), value);
        }
        else {
            return where(key.concat(" is null"));
        }
    }

    public <T> List<T> findBy(String key, Object value, RowMapper<T> rowMapper)
    {
        key = DB.parseKeyParameter(key);
        if (value != null) {
            return where(rowMapper, key.concat(" = ?"), value);
        }
        else {
            return where(rowMapper, key.concat(" is null"));
        }
    }

    public List<Record> all()
    {
        return select().all();
    }

    public <T> List<T> all(RowMapper<T> rowMapper)
    {
        return select().all(rowMapper);
    }

    public List<Record> where(String condition, Object... args)
    {
        return select().where(condition).all(args);
    }

    public <T> List<T> where(
        RowMapper<T> rowMapper,
        String condition,
        Object... args)
    {
        return select().where(condition).all(rowMapper, args);
    }

    public List<Record> paging(int page, int size)
    {
        return select().limit(size).offset(page * size).all();
    }

    public <T> List<T> paging(int page, int size, RowMapper<T> rowMapper)
    {
        return select().limit(size).offset(page * size).all(rowMapper);
    }
}