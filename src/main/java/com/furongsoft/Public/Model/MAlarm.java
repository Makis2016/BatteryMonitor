package com.furongsoft.Public.Model;

/**
 * Created by Administrator on 2016/8/30.
 */
public class MAlarm
{
    /// <summary>
    /// 数据库索引
    /// </summary>
    public Long Id;

    /// <summary>
    /// 告警索引
    /// </summary>
    public String AlarmId;

    /// <summary>
    /// 区域名称
    /// </summary>
    public String AreaName;

    /// <summary>
    /// 告警等级
    /// </summary>
    public String Level;

    /// <summary>
    /// 告警信息
    /// </summary>
    public String AlarmMessage;

    /// <summary>
    /// 维护建议
    /// </summary>
    public String MaintainAdvise;

    /// <summary>
    /// 手动解除
    /// </summary>
    public Boolean ManualOperationed;

    /// <summary>
    /// 告警开始时间
    /// </summary>
    public String StrarTime;

    /// <summary>
    /// 告警结束时间
    /// </summary>
    public String EndTime;

    /// <summary>
    /// 回路ID
    /// </summary>
    public Long CircuitId;
}