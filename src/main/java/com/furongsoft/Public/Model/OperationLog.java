package com.furongsoft.Public.Model;

/**
 * Created by Administrator on 2016/10/26.
 */
public class OperationLog
{
    private Long id;
    private String login_name;
    private String operation;
    private String operation_result;
    private String time;

    private String startDate;
    private String endDate;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLogin_name()
    {
        return login_name;
    }

    public void setLogin_name(String login_name)
    {
        this.login_name = login_name;
    }

    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    public String getOperation_result()
    {
        return operation_result;
    }

    public void setOperation_result(String operation_result)
    {
        this.operation_result = operation_result;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }
}