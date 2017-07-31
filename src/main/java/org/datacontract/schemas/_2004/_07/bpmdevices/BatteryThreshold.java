
package org.datacontract.schemas._2004._07.bpmdevices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>BatteryThreshold complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BatteryThreshold">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BatteryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Config" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreatTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ResistanceLevel1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ResistanceLevel2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="RippleVoltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Temperature" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="VoltageThresholdDown" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="VoltageThresholdUp" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatteryThreshold", propOrder = {
    "batteryId",
    "config",
    "creatTime",
    "resistanceLevel1",
    "resistanceLevel2",
    "rippleVoltage",
    "temperature",
    "voltageThresholdDown",
    "voltageThresholdUp"
})
public class BatteryThreshold {

    @XmlElement(name = "BatteryId")
    protected Long batteryId;
    @XmlElementRef(name = "Config", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> config;
    @XmlElementRef(name = "CreatTime", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> creatTime;
    @XmlElementRef(name = "ResistanceLevel1", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> resistanceLevel1;
    @XmlElementRef(name = "ResistanceLevel2", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> resistanceLevel2;
    @XmlElementRef(name = "RippleVoltage", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> rippleVoltage;
    @XmlElementRef(name = "Temperature", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> temperature;
    @XmlElementRef(name = "VoltageThresholdDown", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> voltageThresholdDown;
    @XmlElementRef(name = "VoltageThresholdUp", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> voltageThresholdUp;

    /**
     * ��ȡbatteryId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBatteryId() {
        return batteryId;
    }

    /**
     * ����batteryId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBatteryId(Long value) {
        this.batteryId = value;
    }

    /**
     * ��ȡconfig���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConfig() {
        return config;
    }

    /**
     * ����config���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConfig(JAXBElement<String> value) {
        this.config = value;
    }

    /**
     * ��ȡcreatTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getCreatTime() {
        return creatTime;
    }

    /**
     * ����creatTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setCreatTime(JAXBElement<XMLGregorianCalendar> value) {
        this.creatTime = value;
    }

    /**
     * ��ȡresistanceLevel1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getResistanceLevel1() {
        return resistanceLevel1;
    }

    /**
     * ����resistanceLevel1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setResistanceLevel1(JAXBElement<Double> value) {
        this.resistanceLevel1 = value;
    }

    /**
     * ��ȡresistanceLevel2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getResistanceLevel2() {
        return resistanceLevel2;
    }

    /**
     * ����resistanceLevel2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setResistanceLevel2(JAXBElement<Double> value) {
        this.resistanceLevel2 = value;
    }

    /**
     * ��ȡrippleVoltage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getRippleVoltage() {
        return rippleVoltage;
    }

    /**
     * ����rippleVoltage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setRippleVoltage(JAXBElement<Double> value) {
        this.rippleVoltage = value;
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
     * ��ȡvoltageThresholdDown���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getVoltageThresholdDown() {
        return voltageThresholdDown;
    }

    /**
     * ����voltageThresholdDown���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setVoltageThresholdDown(JAXBElement<Double> value) {
        this.voltageThresholdDown = value;
    }

    /**
     * ��ȡvoltageThresholdUp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getVoltageThresholdUp() {
        return voltageThresholdUp;
    }

    /**
     * ����voltageThresholdUp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setVoltageThresholdUp(JAXBElement<Double> value) {
        this.voltageThresholdUp = value;
    }

}
