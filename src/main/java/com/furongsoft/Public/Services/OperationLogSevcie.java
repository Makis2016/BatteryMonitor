package com.furongsoft.Public.Services;

import com.alibaba.fastjson.JSON;
import com.furongsoft.Public.Dao.RowMapper.OperationLogRowMapper;
import com.furongsoft.Public.Model.OperationLog;
import com.furongsoft.Public.Model.PaginationResultByEuiGrid;
import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.DbHelper.ORM.BaseDao;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.Record;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.Table;
import com.furongsoft.XspWeb.Utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
@Service
public class OperationLogSevcie
{
    @Autowired
    @Qualifier("BaseDao_system")
    public BaseDao baseDao;

    // 插入操作日记
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Long insertOperation(String operation, Object loginName)
    {
        try {
            if (!operation.equals("login") && loginName == null) {
                loginName = SecurityUtils.getSubject().getPrincipal();
            }

            Table table = baseDao.getDb().active("t_bpm_user_operation_log");
            Record record = table.create("login_name:", loginName
                , "operation:", operation);
            if (record != null) {
                return record.get("id");
            }
            return null;
        }
        catch (Throwable e) {
            Tracker.e(e.getMessage());
            return null;
        }

    }

    // 更新操作结果
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void updateOperationResult(Long id)
    {
        try {
            Table table = baseDao.getDb().active("t_bpm_user_operation_log");
            table.update(table.find(id).set("operation_result", 1));
        }
        catch (Throwable e) {
            Tracker.e(e.getMessage());
        }
    }

    // 操作历史记录查询
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public String getOperationLog(String paramJson)
    {
        List<OperationLog> operationLogs = new ArrayList<>();
        String sql = getSqlByParamJson(paramJson);
        operationLogs = baseDao.getJdbcTemplate().query(sql, new OperationLogRowMapper());

        return JSON.toJSONString(new PaginationResultByEuiGrid(
            operationLogs.size(), operationLogs));
    }

    private String getSqlByParamJson(String paramJson)
    {
        String sql = "SELECT * FROM t_bpm_user_operation_log WHERE 1=1";
        OperationLog bean = new OperationLog();
        if (!StringUtils.isNullOrEmpty(paramJson)) {
            bean = JSON.parseObject(paramJson, OperationLog.class);
        }

        if (bean != null) {
            if (bean.getId() != null) {
                sql += " AND id = " + bean.getId();
            }

            if (!StringUtils.isNullOrEmpty(bean.getLogin_name())) {
                sql += " AND login_name LIKE '%" + bean.getLogin_name() + "%'";
            }

            if (!StringUtils.isNullOrEmpty(bean.getOperation())) {
                sql += " AND operation LIKE '%" + bean.getOperation() + "%'";
            }

            if (!StringUtils.isNullOrEmpty(bean.getOperation_result())) {
                sql += " AND operation_result LIKE '%" + bean.getOperation_result() + "%'";
            }

            if (!StringUtils.isNullOrEmpty(bean.getStartDate())) {
                sql += " AND time >= '" + bean.getStartDate() + "'";
            }

            if (!StringUtils.isNullOrEmpty(bean.getEndDate())) {
                sql += " AND time <= '" + bean.getEndDate() + "'";
            }
        }

        return sql;
    }
}