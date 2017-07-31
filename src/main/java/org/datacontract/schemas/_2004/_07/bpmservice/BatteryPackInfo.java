
package org.datacontract.schemas._2004._07.bpmservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices.AlarmManagerAlarmLevel;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.ArrayOfBattery;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.BatteryPackHealthyState;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.BatteryPackHotStates;


/**
 * <p>BatteryPackInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BatteryPackInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Batteries" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}ArrayOfBattery" minOccurs="0"/>
 *         &lt;element name="BatteryCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BatteryResistanceLevelBaseLine1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BatteryResistanceLevelBaseLine2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BatteryTeamperatureLevelBaseLine1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BatteryTeamperatureLevelBaseLine2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BatteryVoltageLevelBaseLine1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BatteryVoltageLevelBaseLine2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Current" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="EnvironmentTemperature" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="HotAlarmLevel" type="{http://schemas.datacontract.org/2004/07/BPMDevices}AlarmManager.AlarmLevel" minOccurs="0"/>
 *         &lt;element name="HotState" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}BatteryPack.HotStates" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RemainCapacity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="SOC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="SOCAlarmLevel" type="{http://schemas.datacontract.org/2004/07/BPMDevices}AlarmManager.AlarmLevel" minOccurs="0"/>
 *         &lt;element name="SOH" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}BatteryPack.HealthyState" minOccurs="0"/>
 *         &lt;element name="SOHAlarmLevel" type="{http://schemas.datacontract.org/2004/07/BPMDevices}AlarmManager.AlarmLevel" minOccurs="0"/>
 *         &lt;element name="Voltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="WaterTemperature" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="mBatteries" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}ArrayOfBattery" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatteryPackInfo", propOrder = {
    "batteries",
    "batteryCount",
    "batteryResistanceLevelBaseLine1",
    "batteryResistanceLevelBaseLine2",
    "batteryTeamperatureLevelBaseLine1",
    "batteryTeamperatureLevelBaseLine2",
    "batteryVoltageLevelBaseLine1",
    "batteryVoltageLevelBaseLine2",
    "current",
    "environmentTemperature",
    "hotAlarmLevel",
    "hotState",
    "id",
    "name",
    "remainCapacity",
    "soc",
    "socAlarmLevel",
    "soh",
    "sohAlarmLevel",
    "voltage",
    "waterTemperature",
    "mBatteries"
})
public class BatteryPackInfo {

    @XmlElementRef(name = "Batteries", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfBattery> batteries;
    @XmlElement(name = "BatteryCount")
    protected Long batteryCount;
    @XmlElementRef(name = "BatteryResistanceLevelBaseLine1", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryResistanceLevelBaseLine1;
    @XmlElementRef(name = "BatteryResistanceLevelBaseLine2", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryResistanceLevelBaseLine2;
    @XmlElementRef(name = "BatteryTeamperatureLevelBaseLine1", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryTeamperatureLevelBaseLine1;
    @XmlElementRef(name = "BatteryTeamperatureLevelBaseLine2", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryTeamperatureLevelBaseLine2;
    @XmlElementRef(name = "BatteryVoltageLevelBaseLine1", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryVoltageLevelBaseLine1;
    @XmlElementRef(name = "BatteryVoltageLevelBaseLine2", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryVoltageLevelBaseLine2;
    @XmlElementRef(name = "Current", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> current;
    @XmlElementRef(name = "EnvironmentTemperature", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> environmentTemperature;
    @XmlElement(name = "HotAlarmLevel")
    @XmlSchemaType(name = "string")
    protected AlarmManagerAlarmLevel hotAlarmLevel;
    @XmlElement(name = "HotState")
    @XmlSchemaType(name = "string")
    protected BatteryPackHotStates hotState;
    @XmlElement(name = "Id")
    protected Long id;
    @XmlElementRef(name = "Name", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElement(name = "RemainCapacity")
    protected Double remainCapacity;
    @XmlElement(name = "SOC")
    protected Double soc;
    @XmlElement(name = "SOCAlarmLevel")
    @XmlSchemaType(name = "string")
    protected AlarmManagerAlarmLevel socAlarmLevel;
    @XmlElement(name = "SOH")
    @XmlSchemaType(name = "string")
    protected BatteryPackHealthyState soh;
    @XmlElement(name = "SOHAlarmLevel")
    @XmlSchemaType(name = "string")
    protected AlarmManagerAlarmLevel sohAlarmLevel;
    @XmlElementRef(name = "Voltage", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> voltage;
    @XmlElementRef(name = "WaterTemperature", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> waterTemperature;
    @XmlElementRef(name = "mBatteries", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfBattery> mBatteries;

    /**
     * 获取batteries属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBattery> getBatteries() {
        return batteries;
    }

    /**
     * 设置batteries属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}
     *     
     */
    public void setBatteries(JAXBElement<ArrayOfBattery> value) {
        this.batteries = value;
    }

    /**
     * 获取batteryCount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBatteryCount() {
        return batteryCount;
    }

    /**
     * 设置batteryCount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBatteryCount(Long value) {
        this.batteryCount = value;
    }

    /**
     * 获取batteryResistanceLevelBaseLine1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getBatteryResistanceLevelBaseLine1() {
        return batteryResistanceLevelBaseLine1;
    }

    /**
     * 设置batteryResistanceLevelBaseLine1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setBatteryResistanceLevelBaseLine1(JAXBElement<Double> value) {
        this.batteryResistanceLevelBaseLine1 = value;
    }

    /**
     * 获取batteryResistanceLevelBaseLine2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getBatteryResistanceLevelBaseLine2() {
        return batteryResistanceLevelBaseLine2;
    }

    /**
     * 设置batteryResistanceLevelBaseLine2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setBatteryResistanceLevelBaseLine2(JAXBElement<Double> value) {
        this.batteryResistanceLevelBaseLine2 = value;
    }

    /**
     * 获取batteryTeamperatureLevelBaseLine1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getBatteryTeamperatureLevelBaseLine1() {
        return batteryTeamperatureLevelBaseLine1;
    }

    /**
     * 设置batteryTeamperatureLevelBaseLine1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setBatteryTeamperatureLevelBaseLine1(JAXBElement<Double> value) {
        this.batteryTeamperatureLevelBaseLine1 = value;
    }

    /**
     * 获取batteryTeamperatureLevelBaseLine2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getBatteryTeamperatureLevelBaseLine2() {
        return batteryTeamperatureLevelBaseLine2;
    }

    /**
     * 设置batteryTeamperatureLevelBaseLine2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setBatteryTeamperatureLevelBaseLine2(JAXBElement<Double> value) {
        this.batteryTeamperatureLevelBaseLine2 = value;
    }

    /**
     * 获取batteryVoltageLevelBaseLine1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getBatteryVoltageLevelBaseLine1() {
        return batteryVoltageLevelBaseLine1;
    }

    /**
     * 设置batteryVoltageLevelBaseLine1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setBatteryVoltageLevelBaseLine1(JAXBElement<Double> value) {
        this.batteryVoltageLevelBaseLine1 = value;
    }

    /**
     * 获取batteryVoltageLevelBaseLine2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getBatteryVoltageLevelBaseLine2() {
        return batteryVoltageLevelBaseLine2;
    }

    /**
     * 设置batteryVoltageLevelBaseLine2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setBatteryVoltageLevelBaseLine2(JAXBElement<Double> value) {
        this.batteryVoltageLevelBaseLine2 = value;
    }

    /**
     * 获取current属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getCurrent() {
        return current;
    }

    /**
     * 设置current属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setCurrent(JAXBElement<Double> value) {
        this.current = value;
    }

    /**
     * 获取environmentTemperature属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getEnvironmentTemperature() {
        return environmentTemperature;
    }

    /**
     * 设置environmentTemperature属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setEnvironmentTemperature(JAXBElement<Double> value) {
        this.environmentTemperature = value;
    }

    /**
     * 获取hotAlarmLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AlarmManagerAlarmLevel }
     *     
     */
    public AlarmManagerAlarmLevel getHotAlarmLevel() {
        return hotAlarmLevel;
    }

    /**
     * 设置hotAlarmLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmManagerAlarmLevel }
     *     
     */
    public void setHotAlarmLevel(AlarmManagerAlarmLevel value) {
        this.hotAlarmLevel = value;
    }

    /**
     * 获取hotState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BatteryPackHotStates }
     *     
     */
    public BatteryPackHotStates getHotState() {
        return hotState;
    }

    /**
     * 设置hotState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BatteryPackHotStates }
     *     
     */
    public void setHotState(BatteryPackHotStates value) {
        this.hotState = value;
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

    /**
     * 获取remainCapacity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRemainCapacity() {
        return remainCapacity;
    }

    /**
     * 设置remainCapacity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRemainCapacity(Double value) {
        this.remainCapacity = value;
    }

    /**
     * 获取soc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSOC() {
        return soc;
    }

    /**
     * 设置soc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSOC(Double value) {
        this.soc = value;
    }

    /**
     * 获取socAlarmLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AlarmManagerAlarmLevel }
     *     
     */
    public AlarmManagerAlarmLevel getSOCAlarmLevel() {
        return socAlarmLevel;
    }

    /**
     * 设置socAlarmLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmManagerAlarmLevel }
     *     
     */
    public void setSOCAlarmLevel(AlarmManagerAlarmLevel value) {
        this.socAlarmLevel = value;
    }

    /**
     * 获取soh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BatteryPackHealthyState }
     *     
     */
    public BatteryPackHealthyState getSOH() {
        return soh;
    }

    /**
     * 设置soh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BatteryPackHealthyState }
     *     
     */
    public void setSOH(BatteryPackHealthyState value) {
        this.soh = value;
    }

    /**
     * 获取sohAlarmLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AlarmManagerAlarmLevel }
     *     
     */
    public AlarmManagerAlarmLevel getSOHAlarmLevel() {
        return sohAlarmLevel;
    }

    /**
     * 设置sohAlarmLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmManagerAlarmLevel }
     *     
     */
    public void setSOHAlarmLevel(AlarmManagerAlarmLevel value) {
        this.sohAlarmLevel = value;
    }

    /**
     * 获取voltage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getVoltage() {
        return voltage;
    }

    /**
     * 设置voltage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setVoltage(JAXBElement<Double> value) {
        this.voltage = value;
    }

    /**
     * 获取waterTemperature属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getWaterTemperature() {
        return waterTemperature;
    }

    /**
     * 设置waterTemperature属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setWaterTemperature(JAXBElement<Double> value) {
        this.waterTemperature = value;
    }

    /**
     * 获取mBatteries属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBattery> getMBatteries() {
        return mBatteries;
    }

    /**
     * 设置mBatteries属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}
     *     
     */
    public void setMBatteries(JAXBElement<ArrayOfBattery> value) {
        this.mBatteries = value;
    }

}
