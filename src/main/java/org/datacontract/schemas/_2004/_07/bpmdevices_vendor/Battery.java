
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryThreshold;


/**
 * <p>Battery complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Battery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlarmState" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Barcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatteryThreshold" type="{http://schemas.datacontract.org/2004/07/BPMDevices}BatteryThreshold" minOccurs="0"/>
 *         &lt;element name="CapacityCheckPoInt32" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CellNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ChargeRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ChemicalComposition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CircleLife" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DesignVoltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="EqualChargeVolt" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="FirstTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FloatChargeLife" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="FloatChargeVolt" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="HotState" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}BatteryPack.HotStates" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="InitCapacity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="IsAlarm" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ProducerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Resistance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ResistanceBaseValue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="SOH" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SchedulingCycle" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="SerialNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Specification" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}BatteryPack.BatterySpecification" minOccurs="0"/>
 *         &lt;element name="State" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}Battery.BatteryState" minOccurs="0"/>
 *         &lt;element name="Temperature" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}Battery.BatteryType" minOccurs="0"/>
 *         &lt;element name="VirtualAmp" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="VirtualCapacity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Voltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Battery", propOrder = {
    "alarmState",
    "barcode",
    "batteryThreshold",
    "capacityCheckPoInt32",
    "cellNum",
    "chargeRate",
    "chemicalComposition",
    "circleLife",
    "designVoltage",
    "equalChargeVolt",
    "firstTime",
    "floatChargeLife",
    "floatChargeVolt",
    "hotState",
    "id",
    "initCapacity",
    "isAlarm",
    "name",
    "packId",
    "producerName",
    "productionDate",
    "resistance",
    "resistanceBaseValue",
    "soh",
    "schedulingCycle",
    "serialNum",
    "specification",
    "state",
    "temperature",
    "type",
    "virtualAmp",
    "virtualCapacity",
    "voltage"
})
public class Battery {

    @XmlElement(name = "AlarmState")
    protected Boolean alarmState;
    @XmlElementRef(name = "Barcode", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> barcode;
    @XmlElementRef(name = "BatteryThreshold", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<BatteryThreshold> batteryThreshold;
    @XmlElementRef(name = "CapacityCheckPoInt32", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> capacityCheckPoInt32;
    @XmlElementRef(name = "CellNum", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> cellNum;
    @XmlElementRef(name = "ChargeRate", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> chargeRate;
    @XmlElementRef(name = "ChemicalComposition", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> chemicalComposition;
    @XmlElementRef(name = "CircleLife", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> circleLife;
    @XmlElementRef(name = "DesignVoltage", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> designVoltage;
    @XmlElementRef(name = "EqualChargeVolt", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> equalChargeVolt;
    @XmlElementRef(name = "FirstTime", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> firstTime;
    @XmlElementRef(name = "FloatChargeLife", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> floatChargeLife;
    @XmlElementRef(name = "FloatChargeVolt", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> floatChargeVolt;
    @XmlElement(name = "HotState")
    @XmlSchemaType(name = "string")
    protected BatteryPackHotStates hotState;
    @XmlElement(name = "Id")
    protected Long id;
    @XmlElementRef(name = "InitCapacity", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> initCapacity;
    @XmlElement(name = "IsAlarm")
    protected Boolean isAlarm;
    @XmlElementRef(name = "Name", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElement(name = "PackId")
    protected Long packId;
    @XmlElementRef(name = "ProducerName", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> producerName;
    @XmlElementRef(name = "ProductionDate", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> productionDate;
    @XmlElementRef(name = "Resistance", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> resistance;
    @XmlElementRef(name = "ResistanceBaseValue", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> resistanceBaseValue;
    @XmlElement(name = "SOH")
    protected Integer soh;
    @XmlElementRef(name = "SchedulingCycle", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> schedulingCycle;
    @XmlElementRef(name = "SerialNum", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serialNum;
    @XmlElement(name = "Specification")
    @XmlSchemaType(name = "string")
    protected BatteryPackBatterySpecification specification;
    @XmlElement(name = "State")
    @XmlSchemaType(name = "string")
    protected BatteryBatteryState state;
    @XmlElementRef(name = "Temperature", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> temperature;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected BatteryBatteryType type;
    @XmlElementRef(name = "VirtualAmp", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> virtualAmp;
    @XmlElementRef(name = "VirtualCapacity", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> virtualCapacity;
    @XmlElementRef(name = "Voltage", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> voltage;

    /**
     * ��ȡalarmState���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAlarmState() {
        return alarmState;
    }

    /**
     * ����alarmState���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAlarmState(Boolean value) {
        this.alarmState = value;
    }

    /**
     * ��ȡbarcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBarcode() {
        return barcode;
    }

    /**
     * ����barcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBarcode(JAXBElement<String> value) {
        this.barcode = value;
    }

    /**
     * ��ȡbatteryThreshold���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BatteryThreshold }{@code >}
     *     
     */
    public JAXBElement<BatteryThreshold> getBatteryThreshold() {
        return batteryThreshold;
    }

    /**
     * ����batteryThreshold���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BatteryThreshold }{@code >}
     *     
     */
    public void setBatteryThreshold(JAXBElement<BatteryThreshold> value) {
        this.batteryThreshold = value;
    }

    /**
     * ��ȡcapacityCheckPoInt32���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getCapacityCheckPoInt32() {
        return capacityCheckPoInt32;
    }

    /**
     * ����capacityCheckPoInt32���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setCapacityCheckPoInt32(JAXBElement<Double> value) {
        this.capacityCheckPoInt32 = value;
    }

    /**
     * ��ȡcellNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCellNum() {
        return cellNum;
    }

    /**
     * ����cellNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCellNum(JAXBElement<Integer> value) {
        this.cellNum = value;
    }

    /**
     * ��ȡchargeRate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getChargeRate() {
        return chargeRate;
    }

    /**
     * ����chargeRate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setChargeRate(JAXBElement<Double> value) {
        this.chargeRate = value;
    }

    /**
     * ��ȡchemicalComposition���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getChemicalComposition() {
        return chemicalComposition;
    }

    /**
     * ����chemicalComposition���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChemicalComposition(JAXBElement<String> value) {
        this.chemicalComposition = value;
    }

    /**
     * ��ȡcircleLife���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getCircleLife() {
        return circleLife;
    }

    /**
     * ����circleLife���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setCircleLife(JAXBElement<Double> value) {
        this.circleLife = value;
    }

    /**
     * ��ȡdesignVoltage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getDesignVoltage() {
        return designVoltage;
    }

    /**
     * ����designVoltage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setDesignVoltage(JAXBElement<Double> value) {
        this.designVoltage = value;
    }

    /**
     * ��ȡequalChargeVolt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getEqualChargeVolt() {
        return equalChargeVolt;
    }

    /**
     * ����equalChargeVolt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setEqualChargeVolt(JAXBElement<Double> value) {
        this.equalChargeVolt = value;
    }

    /**
     * ��ȡfirstTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getFirstTime() {
        return firstTime;
    }

    /**
     * ����firstTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setFirstTime(JAXBElement<XMLGregorianCalendar> value) {
        this.firstTime = value;
    }

    /**
     * ��ȡfloatChargeLife���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getFloatChargeLife() {
        return floatChargeLife;
    }

    /**
     * ����floatChargeLife���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setFloatChargeLife(JAXBElement<Double> value) {
        this.floatChargeLife = value;
    }

    /**
     * ��ȡfloatChargeVolt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getFloatChargeVolt() {
        return floatChargeVolt;
    }

    /**
     * ����floatChargeVolt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setFloatChargeVolt(JAXBElement<Double> value) {
        this.floatChargeVolt = value;
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
     * ��ȡinitCapacity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getInitCapacity() {
        return initCapacity;
    }

    /**
     * ����initCapacity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setInitCapacity(JAXBElement<Double> value) {
        this.initCapacity = value;
    }

    /**
     * ��ȡisAlarm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAlarm() {
        return isAlarm;
    }

    /**
     * ����isAlarm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAlarm(Boolean value) {
        this.isAlarm = value;
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
     * ��ȡpackId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPackId() {
        return packId;
    }

    /**
     * ����packId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPackId(Long value) {
        this.packId = value;
    }

    /**
     * ��ȡproducerName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProducerName() {
        return producerName;
    }

    /**
     * ����producerName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProducerName(JAXBElement<String> value) {
        this.producerName = value;
    }

    /**
     * ��ȡproductionDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getProductionDate() {
        return productionDate;
    }

    /**
     * ����productionDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setProductionDate(JAXBElement<XMLGregorianCalendar> value) {
        this.productionDate = value;
    }

    /**
     * ��ȡresistance���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getResistance() {
        return resistance;
    }

    /**
     * ����resistance���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setResistance(JAXBElement<Double> value) {
        this.resistance = value;
    }

    /**
     * ��ȡresistanceBaseValue���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getResistanceBaseValue() {
        return resistanceBaseValue;
    }

    /**
     * ����resistanceBaseValue���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setResistanceBaseValue(JAXBElement<Double> value) {
        this.resistanceBaseValue = value;
    }

    /**
     * ��ȡsoh���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSOH() {
        return soh;
    }

    /**
     * ����soh���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSOH(Integer value) {
        this.soh = value;
    }

    /**
     * ��ȡschedulingCycle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getSchedulingCycle() {
        return schedulingCycle;
    }

    /**
     * ����schedulingCycle���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setSchedulingCycle(JAXBElement<Double> value) {
        this.schedulingCycle = value;
    }

    /**
     * ��ȡserialNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSerialNum() {
        return serialNum;
    }

    /**
     * ����serialNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSerialNum(JAXBElement<String> value) {
        this.serialNum = value;
    }

    /**
     * ��ȡspecification���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BatteryPackBatterySpecification }
     *     
     */
    public BatteryPackBatterySpecification getSpecification() {
        return specification;
    }

    /**
     * ����specification���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BatteryPackBatterySpecification }
     *     
     */
    public void setSpecification(BatteryPackBatterySpecification value) {
        this.specification = value;
    }

    /**
     * ��ȡstate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BatteryBatteryState }
     *     
     */
    public BatteryBatteryState getState() {
        return state;
    }

    /**
     * ����state���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BatteryBatteryState }
     *     
     */
    public void setState(BatteryBatteryState value) {
        this.state = value;
    }

    /**
     * ��ȡtemperature���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getTemperature() {
        return temperature;
    }

    /**
     * ����temperature���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setTemperature(JAXBElement<Double> value) {
        this.temperature = value;
    }

    /**
     * ��ȡtype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BatteryBatteryType }
     *     
     */
    public BatteryBatteryType getType() {
        return type;
    }

    /**
     * ����type���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BatteryBatteryType }
     *     
     */
    public void setType(BatteryBatteryType value) {
        this.type = value;
    }

    /**
     * ��ȡvirtualAmp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getVirtualAmp() {
        return virtualAmp;
    }

    /**
     * ����virtualAmp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setVirtualAmp(JAXBElement<Double> value) {
        this.virtualAmp = value;
    }

    /**
     * ��ȡvirtualCapacity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getVirtualCapacity() {
        return virtualCapacity;
    }

    /**
     * ����virtualCapacity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setVirtualCapacity(JAXBElement<Double> value) {
        this.virtualCapacity = value;
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

}
