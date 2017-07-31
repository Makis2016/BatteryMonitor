
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
 * <p>BatteryPackInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡbatteries���Ե�ֵ��
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
     * ����batteries���Ե�ֵ��
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
     * ��ȡbatteryCount���Ե�ֵ��
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
     * ����batteryCount���Ե�ֵ��
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
     * ��ȡbatteryResistanceLevelBaseLine1���Ե�ֵ��
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
     * ����batteryResistanceLevelBaseLine1���Ե�ֵ��
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
     * ��ȡbatteryResistanceLevelBaseLine2���Ե�ֵ��
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
     * ����batteryResistanceLevelBaseLine2���Ե�ֵ��
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
     * ��ȡbatteryTeamperatureLevelBaseLine1���Ե�ֵ��
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
     * ����batteryTeamperatureLevelBaseLine1���Ե�ֵ��
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
     * ��ȡbatteryTeamperatureLevelBaseLine2���Ե�ֵ��
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
     * ����batteryTeamperatureLevelBaseLine2���Ե�ֵ��
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
     * ��ȡbatteryVoltageLevelBaseLine1���Ե�ֵ��
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
     * ����batteryVoltageLevelBaseLine1���Ե�ֵ��
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
     * ��ȡbatteryVoltageLevelBaseLine2���Ե�ֵ��
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
     * ����batteryVoltageLevelBaseLine2���Ե�ֵ��
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
     * ��ȡcurrent���Ե�ֵ��
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
     * ����current���Ե�ֵ��
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
     * ��ȡenvironmentTemperature���Ե�ֵ��
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
     * ����environmentTemperature���Ե�ֵ��
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
     * ��ȡhotAlarmLevel���Ե�ֵ��
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
     * ����hotAlarmLevel���Ե�ֵ��
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
     * ��ȡhotState���Ե�ֵ��
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
     * ����hotState���Ե�ֵ��
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

    /**
     * ��ȡremainCapacity���Ե�ֵ��
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
     * ����remainCapacity���Ե�ֵ��
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
     * ��ȡsoc���Ե�ֵ��
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
     * ����soc���Ե�ֵ��
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
     * ��ȡsocAlarmLevel���Ե�ֵ��
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
     * ����socAlarmLevel���Ե�ֵ��
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
     * ��ȡsoh���Ե�ֵ��
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
     * ����soh���Ե�ֵ��
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
     * ��ȡsohAlarmLevel���Ե�ֵ��
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
     * ����sohAlarmLevel���Ե�ֵ��
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
     * ��ȡvoltage���Ե�ֵ��
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
     * ����voltage���Ե�ֵ��
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
     * ��ȡwaterTemperature���Ե�ֵ��
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
     * ����waterTemperature���Ե�ֵ��
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
     * ��ȡmBatteries���Ե�ֵ��
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
     * ����mBatteries���Ե�ֵ��
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
