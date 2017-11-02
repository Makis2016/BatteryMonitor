package com.furongsoft.Public.Model;

/**
 * Created by Administrator on 2016/10/13.
 */
public class MSfBCU
{
    /// <summary>
    /// 数据更新标志位
    /// </summary>
    private Boolean IsRefresh;

    /// <summary>
    /// Modbus设备地址
    /// </summary>
    private Short Address;

    /// <summary>
    /// Modbus寄存器地址(BCU编号)
    /// </summary>
    private Integer RegisterAddress;

    /// <summary>
    /// 数据长度
    /// </summary>
    private Short Length;
    /// <summary>
    /// 设备类型
    /// </summary>
    private Short Type;

    /// <summary>
    /// 设备MAC地址
    /// </summary>
    private String Mac;

    /// <summary>
    /// ZigBee目标地址
    /// </summary>
    private Integer ZigBeeGoal;

    /// <summary>
    /// ZigBee本地地址（短地址）
    /// </summary>
    private Integer ZigBeeLocal;

    /// <summary>
    /// 通信信道1
    /// </summary>
    private Short Channel;

    /// <summary>
    /// 设备通讯波特率
    /// </summary>
    private Short BaudRate;

    /// <summary>
    /// 预留信息
    /// </summary>
    private String Reserve;

    /// <summary>
    /// 编号ID流水号
    /// </summary>
    private Short SerialNumber;

    /// <summary>
    /// ID设定存储状态
    /// </summary>
    private Short IdStatus;

    /**
     * 操作标示
     */
    private String op;

    /**
     * 单体id
     */
    private Long battery_id;

    /**
     * 单体序号
     */
    private int battery_num;

    /**
     * 单体状态
     */
    private int battery_status;

    /**
     * 单体状态
     */
    private int battery_state;

    /**
     * 网段通讯ID
     */
    private Integer panId1;

    /**
     * 网段通讯ID
     */
    private Integer panId2;

    /**
     * Modbus寄存器地址(BCU编号) 修改前
     */
    private Integer oldRegisterAddress;

    public int getBattery_status() {
        return battery_status;
    }

    public void setBattery_status(int battery_status) {
        this.battery_status = battery_status;
    }

    public Boolean getRefresh()
    {
        return IsRefresh;
    }

    public void setRefresh(Boolean refresh)
    {
        IsRefresh = refresh;
    }

    public Short getAddress()
    {
        return Address;
    }

    public void setAddress(Short address)
    {
        Address = address;
    }

    public Integer getRegisterAddress()
    {
        return RegisterAddress;
    }

    public void setRegisterAddress(Integer registerAddress)
    {
        RegisterAddress = registerAddress;
    }

    public Short getLength()
    {
        return Length;
    }

    public void setLength(Short length)
    {
        Length = length;
    }

    public Short getType()
    {
        return Type;
    }

    public void setType(Short type)
    {
        Type = type;
    }

    public String getMac()
    {
        return Mac;
    }

    public void setMac(String mac)
    {
        Mac = mac;
    }

    public Integer getZigBeeGoal()
    {
        return ZigBeeGoal;
    }

    public void setZigBeeGoal(Integer zigBeeGoal)
    {
        ZigBeeGoal = zigBeeGoal;
    }

    public Integer getZigBeeLocal()
    {
        return ZigBeeLocal;
    }

    public void setZigBeeLocal(Integer zigBeeLocal)
    {
        ZigBeeLocal = zigBeeLocal;
    }

    public Short getBaudRate()
    {
        return BaudRate;
    }

    public void setBaudRate(Short baudRate)
    {
        BaudRate = baudRate;
    }

    public String getReserve()
    {
        return Reserve;
    }

    public void setReserve(String reserve)
    {
        Reserve = reserve;
    }

    public Short getSerialNumber()
    {
        return SerialNumber;
    }

    public void setSerialNumber(Short serialNumber)
    {
        SerialNumber = serialNumber;
    }

    public Short getIdStatus()
    {
        return IdStatus;
    }

    public void setIdStatus(Short idStatus)
    {
        IdStatus = idStatus;
    }

    public String getOp()
    {
        return op;
    }

    public void setOp(String op)
    {
        this.op = op;
    }

    public Long getBattery_id()
    {
        return battery_id;
    }

    public void setBattery_id(Long battery_id)
    {
        this.battery_id = battery_id;
    }

    public int getBattery_num()
    {
        return battery_num;
    }

    public void setBattery_num(int battery_num)
    {
        this.battery_num = battery_num;
    }

    public int getBattery_state() {
        return battery_state;
    }

    public void setBattery_state(int battery_state) {
        this.battery_state = battery_state;
    }

    public Integer getOldRegisterAddress() {
        return oldRegisterAddress;
    }

    public void setOldRegisterAddress(Integer oldRegisterAddress) {
        this.oldRegisterAddress = oldRegisterAddress;
    }


    public Integer getPanId1() {
        return panId1;
    }

    public void setPanId1(Integer panId1) {
        this.panId1 = panId1;
    }

    public Integer getPanId2() {
        return panId2;
    }

    public void setPanId2(Integer panId2) {
        this.panId2 = panId2;
    }

    public Short getChannel() {
        return Channel;
    }

    public void setChannel(Short channel) {
        Channel = channel;
    }
}