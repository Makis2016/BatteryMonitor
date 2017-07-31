
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryPackThreshold;


/**
 * <p>BatteryPack complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BatteryPack">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Batteries" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}ArrayOfBattery" minOccurs="0"/>
 *         &lt;element name="BatteryCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BatteryGroupThreshold" type="{http://schemas.datacontract.org/2004/07/BPMDevices}BatteryPackThreshold" minOccurs="0"/>
 *         &lt;element name="BatteryResistanceLevelBaseLine1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BatteryResistanceLevelBaseLine2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BatteryTeamperatureLevelBaseLine1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BatteryTeamperatureLevelBaseLine2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BatteryTemperature" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BatteryVoltageLevelBaseLine1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BatteryVoltageLevelBaseLine2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Capacity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Character" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfdouble" minOccurs="0"/>
 *         &lt;element name="CheckCycleTime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Current" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="EnvironmentTemperature" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="HotState" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}BatteryPack.HotStates" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OnlineTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="RemainCapacity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="SOC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="SOH" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}BatteryPack.HealthyState" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}BatteryPack.BatterySpecification" minOccurs="0"/>
 *         &lt;element name="Voltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="VoltageRange" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="WaterTemperature" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="mBatteryCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatteryPack", propOrder = {
    "batteries",
    "batteryCount",
    "batteryGroupThreshold",
    "batteryResistanceLevelBaseLine1",
    "batteryResistanceLevelBaseLine2",
    "batteryTeamperatureLevelBaseLine1",
    "batteryTeamperatureLevelBaseLine2",
    "batteryTemperature",
    "batteryVoltageLevelBaseLine1",
    "batteryVoltageLevelBaseLine2",
    "capacity",
    "character",
    "checkCycleTime",
    "current",
    "environmentTemperature",
    "hotState",
    "id",
    "name",
    "onlineTime",
    "remainCapacity",
    "soc",
    "soh",
    "type",
    "voltage",
    "voltageRange",
    "waterTemperature",
    "mBatteryCount"
})
public class BatteryPack {

    @XmlElementRef(name = "Batteries", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfBattery> batteries;
    @XmlElement(name = "BatteryCount")
    protected Integer batteryCount;
    @XmlElementRef(name = "BatteryGroupThreshold", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<BatteryPackThreshold> batteryGroupThreshold;
    @XmlElementRef(name = "BatteryResistanceLevelBaseLine1", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryResistanceLevelBaseLine1;
    @XmlElementRef(name = "BatteryResistanceLevelBaseLine2", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryResistanceLevelBaseLine2;
    @XmlElementRef(name = "BatteryTeamperatureLevelBaseLine1", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryTeamperatureLevelBaseLine1;
    @XmlElementRef(name = "BatteryTeamperatureLevelBaseLine2", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryTeamperatureLevelBaseLine2;
    @XmlElementRef(name = "BatteryTemperature", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryTemperature;
    @XmlElementRef(name = "BatteryVoltageLevelBaseLine1", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryVoltageLevelBaseLine1;
    @XmlElementRef(name = "BatteryVoltageLevelBaseLine2", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> batteryVoltageLevelBaseLine2;
    @XmlElementRef(name = "Capacity", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> capacity;
    @XmlElementRef(name = "Character", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfdouble> character;
    @XmlElement(name = "CheckCycleTime")
    protected Integer checkCycleTime;
    @XmlElementRef(name = "Current", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> current;
    @XmlElementRef(name = "EnvironmentTemperature", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> environmentTemperature;
    @XmlElement(name = "HotState")
    @XmlSchemaType(name = "string")
    protected BatteryPackHotStates hotState;
    @XmlElement(name = "Id")
    protected Long id;
    @XmlElementRef(name = "Name", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElement(name = "OnlineTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar onlineTime;
    @XmlElement(name = "RemainCapacity")
    protected Double remainCapacity;
    @XmlElement(name = "SOC")
    protected Double soc;
    @XmlElement(name = "SOH")
    @XmlSchemaType(name = "string")
    protected BatteryPackHealthyState soh;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected BatteryPackBatterySpecification type;
    @XmlElementRef(name = "Voltage", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> voltage;
    @XmlElement(name = "VoltageRange")
    protected Double voltageRange;
    @XmlElementRef(name = "WaterTemperature", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> waterTemperature;
    protected Integer mBatteryCount;

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
     *     {@link Integer }
     *     
     */
    public Integer getBatteryCount() {
        return batteryCount;
    }

    /**
     * ����batteryCount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBatteryCount(Integer value) {
        this.batteryCount = value;
    }

    /**
     * ��ȡbatteryGroupThreshold���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BatteryPackThreshold }{@code >}
     *     
     */
    public JAXBElement<BatteryPackThreshold> getBatteryGroupThreshold() {
        return batteryGroupThreshold;
    }

    /**
     * ����batteryGroupThreshold���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BatteryPackThreshold }{@code >}
     *     
     */
    public void setBatteryGroupThreshold(JAXBElement<BatteryPackThreshold> value) {
        this.batteryGroupThreshold = value;
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
     * ��ȡbatteryTemperature���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getBatteryTemperature() {
        return batteryTemperature;
    }

    /**
     * ����batteryTemperature���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setBatteryTemperature(JAXBElement<Double> value) {
        this.batteryTemperature = value;
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
     * ��ȡcapacity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getCapacity() {
        return capacity;
    }

    /**
     * ����capacity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setCapacity(JAXBElement<Double> value) {
        this.capacity = value;
    }

    /**
     * ��ȡcharacter���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     *     
     */
    public JAXBElement<ArrayOfdouble> getCharacter() {
        return character;
    }

    /**
     * ����character���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     *     
     */
    public void setCharacter(JAXBElement<ArrayOfdouble> value) {
        this.character = value;
    }

    /**
     * ��ȡcheckCycleTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCheckCycleTime() {
        return checkCycleTime;
    }

    /**
     * ����checkCycleTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCheckCycleTime(Integer value) {
        this.checkCycleTime = value;
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
     * ��ȡonlineTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOnlineTime() {
        return onlineTime;
    }

    /**
     * ����onlineTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOnlineTime(XMLGregorianCalendar value) {
        this.onlineTime = value;
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
     * ��ȡtype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BatteryPackBatterySpecification }
     *     
     */
    public BatteryPackBatterySpecification getType() {
        return type;
    }

    /**
     * ����type���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BatteryPackBatterySpecification }
     *     
     */
    public void setType(BatteryPackBatterySpecification value) {
        this.type = value;
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
     * ��ȡvoltageRange���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVoltageRange() {
        return voltageRange;
    }

    /**
     * ����voltageRange���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVoltageRange(Double value) {
        this.voltageRange = value;
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
     * ��ȡmBatteryCount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMBatteryCount() {
        return mBatteryCount;
    }

    /**
     * ����mBatteryCount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMBatteryCount(Integer value) {
        this.mBatteryCount = value;
    }

}
