package com.furongsoft.XspWeb.DbHelper.ORM;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.crazycake.jdbcTemplateTool.JdbcTemplateTool;
import org.hibernate.SessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.furongsoft.XspWeb.Common.BaseBean;
import com.furongsoft.XspWeb.DbHelper.Page;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.DB;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.Table;
import com.github.pagehelper.PageHelper;

/**
 * 定义基础数据访问对象
 *
 * @author Alex
 */
public class BaseDao extends BaseBean
{
    /**
     * 数据源Bean名称前缀
     */
    protected static final String DATASOURCE_PREFIX = "dataSource_";

    /**
     * Hibernate Bean名称前缀
     */
    protected static final String HIBERNATE_PREFIX = "hibernateSessionFactory_";

    /**
     * MyBatis Bean名称前缀
     */
    protected static final String MYBATIS_PREFIX = "myBatisSessionFactory_";

    /**
     * 定义MyBatis类型注解
     *
     * @author Alex
     */
    public @interface MyBatisMapper
    {
    }

    /**
     * 数据源
     */
    protected DataSource dataSource;

    /**
     * Hibernate会话工厂
     */
    protected SessionFactory sf;

    /**
     * MyBatis会话工厂
     */
    protected SqlSessionFactory ssf;

    /**
     * JDBC模板
     */
    protected JdbcTemplate mJdbcTemplate;

    /**
     * JDBC模板工具
     */
    protected JdbcTemplateTool mJdbcTemplateTool;

    /**
     * Hibernate模板
     */
    protected HibernateTemplate mHibernateTemplate;

    /**
     * MyBatis模板
     */
    protected SqlSessionTemplate mMyBatisTemplate;

    /**
     * jActiveRecord数据库
     */
    protected DB mDb;

    public DataSource getDataSource()
    {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public SessionFactory getSf()
    {
        return sf;
    }

    public void setSf(SessionFactory sf)
    {
        this.sf = sf;
    }

    public SqlSessionFactory getSsf()
    {
        return ssf;
    }

    public void setSsf(SqlSessionFactory ssf)
    {
        this.ssf = ssf;
    }

    /**
     * @return JDBC模板工具对象
     */
    public synchronized JdbcTemplateTool getJdbcTemplateTool()
    {
        if (mJdbcTemplateTool != null) {
            return mJdbcTemplateTool;
        }

        if (dataSource != null) {
            mJdbcTemplate = new JdbcTemplate(dataSource);
            mJdbcTemplateTool = new JdbcTemplateTool();
            mJdbcTemplateTool.setJdbcTemplate(mJdbcTemplate);
        }

        return mJdbcTemplateTool;
    }

    /**
     * @return JDBC模板对象
     */
    public synchronized JdbcTemplate getJdbcTemplate()
    {
        JdbcTemplateTool tool = getJdbcTemplateTool();
        if (tool == null) {
            return null;
        }

        return tool.getJdbcTemplate();
    }

    /**
     * @return Hibernate模板对象
     */
    public synchronized HibernateTemplate getHibernateTemplate()
    {
        if (mHibernateTemplate != null) {
            return mHibernateTemplate;
        }

        if (sf != null) {
            mHibernateTemplate = new HibernateTemplate(sf);
        }

        return mHibernateTemplate;
    }

    /**
     * @return MyBatis模板对象
     */
    public synchronized SqlSessionTemplate getSqlSessionTemplate()
    {
        if (mMyBatisTemplate != null) {
            return mMyBatisTemplate;
        }

        if (ssf != null) {
            mMyBatisTemplate = new SqlSessionTemplate(ssf);
        }

        return mMyBatisTemplate;
    }

    /**
     * @return 返回jActiveRecord数据库
     */
    public synchronized DB getDb()
    {
        if (mDb != null) {
            return mDb;
        }

        if (dataSource != null) {
            mDb = DB.open(dataSource);
        }

        return mDb;
    }

    /**
     * 添加实体对象
     *
     * @param entity 实体对象
     * @return 生成索引
     * @throws DataAccessException
     */
    public Serializable insert(final Object entity) throws DataAccessException
    {
        return getHibernateTemplate().save(entity);
    }

    /**
     * 添加实体对象
     *
     * @param mapperClass 映射类型
     * @param methodName  方法名称
     * @param entity      实体对象
     * @throws DataAccessException
     */
    public void insert(
        final Class<?> mapperClass,
        String methodName,
        final Object entity) throws DataAccessException
    {
        getSqlSessionTemplate()
            .insert(mapperClass.getName() + "." + methodName, entity);
    }

    /**
     * 删除实体对象
     *
     * @param entity 实体对象
     * @throws DataAccessException
     */
    public void delete(final Object entity) throws DataAccessException
    {
        getHibernateTemplate().delete(entity);
    }

    /**
     * 更新实体对象
     *
     * @param entity 实体对象
     * @throws DataAccessException
     */
    public void update(final Object entity) throws DataAccessException
    {
        getHibernateTemplate().update(entity);
    }

    /**
     * 查询实体类对象
     *
     * @param entityClass 实体类型
     * @param id          对象索引
     * @return 实体类对象
     * @throws DataAccessException
     */
    public <T> T query(final Class<T> entityClass, final Serializable id)
        throws DataAccessException
    {
        return getHibernateTemplate().get(entityClass, id);
    }

    /**
     * 查询实体类对象
     *
     * @param mapperClass 映射类型
     * @param methodName  方法名称
     * @param id          对象索引
     * @return 实体类对象
     * @throws DataAccessException
     */
    public <T> T query(
        final Class<?> mapperClass,
        final String methodName,
        final Serializable id) throws DataAccessException
    {
        return getSqlSessionTemplate()
            .selectOne(mapperClass.getName() + "." + methodName, id);
    }

    /**
     * 查询所有实体类型对象
     *
     * @param entityClass 实体类型
     * @return 所有实体类型对象
     * @throws DataAccessException
     */
    public <T> List<T> loadAll(final Class<T> entityClass)
        throws DataAccessException
    {
        return getHibernateTemplate().loadAll(entityClass);
    }

    /**
     * 查询所有实体类型对象
     *
     * @param mapperClass 映射类型
     * @param methodName  方法名称
     * @return 所有实体类型对象
     * @throws DataAccessException
     */
    public <
        T> List<T> loadAll(final Class<?> mapperClass, final String methodName)
        throws DataAccessException
    {
        return getSqlSessionTemplate()
            .selectList(mapperClass.getName() + "." + methodName);
    }

    /**
     * 查询所有实体类型对象
     *
     * @param mapperClass 映射类型
     * @param methodName  方法名称
     * @param params      参数表
     * @return 所有实体类型对象
     * @throws DataAccessException
     */
    public <T> List<T> loadAll(
        final Class<?> mapperClass,
        final String methodName,
        final Map<String, Object> params) throws DataAccessException
    {
        return getSqlSessionTemplate()
            .selectList(mapperClass.getName() + "." + methodName, params);
    }

    /**
     * 查询记录总数
     *
     * @param entityClass 实体类型
     * @return 记录总数
     */
    public <T> int count(final Class<T> entityClass) throws DataAccessException
    {
        return DataAccessUtils.intResult(
            getHibernateTemplate().find(
                "SELECT COUNT(*) FROM " + entityClass.getCanonicalName()));
    }

    /**
     * 分页查询
     *
     * @param table 数据表对象
     * @param page  分页参数对象
     * @return 分页查询结果对象
     */
    public Page paging(final Table table, Page page)
    {
        page.setData(table.paging(page.getPage() - 1, page.getRows()));

        return page;
    }

    /**
     * 分页查询
     *
     * @param mapperClass 映射类型
     * @param methodName  方法名称
     * @param params      参数表
     * @param page        分页参数对象
     * @return 分页查询结果对象
     * @throws DataAccessException
     */
    public Page paging(
        final Class<?> mapperClass,
        final String methodName,
        final Map<String, Object> params,
        Page page) throws DataAccessException
    {
        PageHelper.startPage(page.getPage(), page.getRows());
        page.setData(
            getSqlSessionTemplate()
                .selectList(mapperClass.getName() + "." + methodName, params));

        return page;
    }
}