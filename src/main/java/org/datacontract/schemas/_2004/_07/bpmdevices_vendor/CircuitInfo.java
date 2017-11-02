
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
 * <p>CircuitInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡacdcId���Ե�ֵ��
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
     * ����acdcId���Ե�ֵ��
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
     * ��ȡalarmLevel���Ե�ֵ��
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
     * ����alarmLevel���Ե�ֵ��
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
     * ��ȡareaId���Ե�ֵ��
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
     * ����areaId���Ե�ֵ��
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
     * ��ȡareaIdPath���Ե�ֵ��
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
     * ����areaIdPath���Ե�ֵ��
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
     * ��ȡareaName���Ե�ֵ��
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
     * ����areaName���Ե�ֵ��
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
     * ��ȡbatteryPackId���Ե�ֵ��
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
     * ����batteryPackId���Ե�ֵ��
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
     * ��ȡbatteryPackInfo���Ե�ֵ��
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
     * ����batteryPackInfo���Ե�ֵ��
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
     * ��ȡdcdcId���Ե�ֵ��
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
     * ����dcdcId���Ե�ֵ��
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
     * ��ȡdataAccuracyInfo���Ե�ֵ��
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
     * ����dataAccuracyInfo���Ե�ֵ��
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
     * ��ȡdcdcInfo���Ե�ֵ��
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
     * ����dcdcInfo���Ե�ֵ��
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
     * ��ȡformattingState���Ե�ֵ��
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
     * ����formattingState���Ե�ֵ��
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
     * ��ȡid���Ե�ֵ��
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
     * ����id���Ե�ֵ��
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
     * ��ȡmonitorId���Ե�ֵ��
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
     * ����monitorId���Ե�ֵ��
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
     * ��ȡmonitorState���Ե�ֵ��
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
     * ����monitorState���Ե�ֵ��
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
     * ��ȡname���Ե�ֵ��
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
     * ����name���Ե�ֵ��
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
