
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmservice.BatteryPackInfo;
import org.datacontract.schemas._2004._07.bpmservice.DataAccuracyInfo;
import org.datacontract.schemas._2004._07.bpmservice.DcdcData;


/**
 * <p>CircuitInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CircuitInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACDCId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="AlarmLevel" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}Alarm.AlarmLevel" minOccurs="0"/>
 *         &lt;element name="AreaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="AreaIdPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AreaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatteryPackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BatteryPackInfo" type="{http://schemas.datacontract.org/2004/07/BPMService.Model}BatteryPackInfo" minOccurs="0"/>
 *         &lt;element name="DCDCId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DataAccuracyInfo" type="{http://schemas.datacontract.org/2004/07/BPMService.Model}DataAccuracyInfo" minOccurs="0"/>
 *         &lt;element name="DcdcInfo" type="{http://schemas.datacontract.org/2004/07/BPMService.Model}DcdcData" minOccurs="0"/>
 *         &lt;element name="FormattingState" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}Circuit.FormattingStatus" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="MonitorId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="MonitorState" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}Circuit.BatteryPackStatus" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CircuitInfo", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", propOrder = {
    "acdcId",
    "alarmLevel",
    "areaId",
    "areaIdPath",
    "areaName",
    "batteryPackId",
    "batteryPackInfo",
    "dcdcId",
    "dataAccuracyInfo",
    "dcdcInfo",
    "formattingState",
    "id",
    "monitorId",
    "monitorState",
    "name"
})
public class CircuitInfo {

    @XmlElementRef(name = "ACDCId", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> acdcId;
    @XmlElement(name = "AlarmLevel")
    @XmlSchemaType(name = "string")
    protected AlarmAlarmLevel alarmLevel;
    @XmlElement(name = "AreaId")
    protected Long areaId;
    @XmlElementRef(name = "AreaIdPath", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", type = JAXBElement.class, required = false)
    protected JAXBElement<String> areaIdPath;
    @XmlElementRef(name = "AreaName", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", type = JAXBElement.class, required = false)
    protected JAXBElement<String> areaName;
    @XmlElement(name = "BatteryPackId")
    protected Long batteryPackId;
    @XmlElementRef(name = "BatteryPackInfo", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", type = JAXBElement.class, required = false)
    protected JAXBElement<BatteryPackInfo> batteryPackInfo;
    @XmlElementRef(name = "DCDCId", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> dcdcId;
    @XmlElementRef(name = "DataAccuracyInfo", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", type = JAXBElement.class, required = false)
    protected JAXBElement<DataAccuracyInfo> dataAccuracyInfo;
    @XmlElementRef(name = "DcdcInfo", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", type = JAXBElement.class, required = false)
    protected JAXBElement<DcdcData> dcdcInfo;
    @XmlElement(name = "FormattingState")
    @XmlSchemaType(name = "string")
    protected CircuitFormattingStatus formattingState;
    @XmlElement(name = "Id")
    protected Long id;
    @XmlElementRef(name = "MonitorId", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> monitorId;
    @XmlElement(name = "MonitorState")
    @XmlSchemaType(name = "string")
    protected CircuitBatteryPackStatus monitorState;
    @XmlElementRef(name = "Name", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;

    /**
     * 获取acdcId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getACDCId() {
        return acdcId;
    }

    /**
     * 设置acdcId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setACDCId(JAXBElement<Long> value) {
        this.acdcId = value;
    }

    /**
     * 获取alarmLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AlarmAlarmLevel }
     *     
     */
    public AlarmAlarmLevel getAlarmLevel() {
        return alarmLevel;
    }

    /**
     * 设置alarmLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmAlarmLevel }
     *     
     */
    public void setAlarmLevel(AlarmAlarmLevel value) {
        this.alarmLevel = value;
    }

    /**
     * 获取areaId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * 设置areaId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAreaId(Long value) {
        this.areaId = value;
    }

    /**
     * 获取areaIdPath属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAreaIdPath() {
        return areaIdPath;
    }

    /**
     * 设置areaIdPath属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAreaIdPath(JAXBElement<String> value) {
        this.areaIdPath = value;
    }

    /**
     * 获取areaName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAreaName() {
        return areaName;
    }

    /**
     * 设置areaName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAreaName(JAXBElement<String> value) {
        this.areaName = value;
    }

    /**
     * 获取batteryPackId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBatteryPackId() {
        return batteryPackId;
    }

    /**
     * 设置batteryPackId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBatteryPackId(Long value) {
        this.batteryPackId = value;
    }

    /**
     * 获取batteryPackInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BatteryPackInfo }{@code >}
     *     
     */
    public JAXBElement<BatteryPackInfo> getBatteryPackInfo() {
        return batteryPackInfo;
    }

    /**
     * 设置batteryPackInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BatteryPackInfo }{@code >}
     *     
     */
    public void setBatteryPackInfo(JAXBElement<BatteryPackInfo> value) {
        this.batteryPackInfo = value;
    }

    /**
     * 获取dcdcId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getDCDCId() {
        return dcdcId;
    }

    /**
     * 设置dcdcId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setDCDCId(JAXBElement<Long> value) {
        this.dcdcId = value;
    }

    /**
     * 获取dataAccuracyInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DataAccuracyInfo }{@code >}
     *     
     */
    public JAXBElement<DataAccuracyInfo> getDataAccuracyInfo() {
        return dataAccuracyInfo;
    }

    /**
     * 设置dataAccuracyInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DataAccuracyInfo }{@code >}
     *     
     */
    public void setDataAccuracyInfo(JAXBElement<DataAccuracyInfo> value) {
        this.dataAccuracyInfo = value;
    }

    /**
     * 获取dcdcInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DcdcData }{@code >}
     *     
     */
    public JAXBElement<DcdcData> getDcdcInfo() {
        return dcdcInfo;
    }

    /**
     * 设置dcdcInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DcdcData }{@code >}
     *     
     */
    public void setDcdcInfo(JAXBElement<DcdcData> value) {
        this.dcdcInfo = value;
    }

    /**
     * 获取formattingState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CircuitFormattingStatus }
     *     
     */
    public CircuitFormattingStatus getFormattingState() {
        return formattingState;
    }

    /**
     * 设置formattingState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CircuitFormattingStatus }
     *     
     */
    public void setFormattingState(CircuitFormattingStatus value) {
        this.formattingState = value;
    }

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * 获取monitorId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getMonitorId() {
        return monitorId;
    }

    /**
     * 设置monitorId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setMonitorId(JAXBElement<Long> value) {
        this.monitorId = value;
    }

    /**
     * 获取monitorState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CircuitBatteryPackStatus }
     *     
     */
    public CircuitBatteryPackStatus getMonitorState() {
        return monitorState;
    }

    /**
     * 设置monitorState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CircuitBatteryPackStatus }
     *     
     */
    public void setMonitorState(CircuitBatteryPackStatus value) {
        this.monitorState = value;
    }

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = value;
    }

}
