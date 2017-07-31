
package org.datacontract.schemas._2004._07.bpmdevices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>BatteryPackThreshold complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BatteryPackThreshold">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BatteryGroupId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Config" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreatTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="EnvirTeaperature" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="GroupCurrentThreshold" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="GroupLeakageCurrent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="GroupRippleCurrent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="GroupRippleVoltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="GroupVoltageDown" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="GroupVoltageUp" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatteryPackThreshold", propOrder = {
    "batteryGroupId",
    "config",
    "creatTime",
    "envirTeaperature",
    "groupCurrentThreshold",
    "groupLeakageCurrent",
    "groupRippleCurrent",
    "groupRippleVoltage",
    "groupVoltageDown",
    "groupVoltageUp"
})
public class BatteryPackThreshold {

    @XmlElement(name = "BatteryGroupId")
    protected Long batteryGroupId;
    @XmlElementRef(name = "Config", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> config;
    @XmlElement(name = "CreatTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creatTime;
    @XmlElementRef(name = "EnvirTeaperature", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> envirTeaperature;
    @XmlElementRef(name = "GroupCurrentThreshold", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> groupCurrentThreshold;
    @XmlElementRef(name = "GroupLeakageCurrent", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> groupLeakageCurrent;
    @XmlElementRef(name = "GroupRippleCurrent", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> groupRippleCurrent;
    @XmlElementRef(name = "GroupRippleVoltage", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> groupRippleVoltage;
    @XmlElementRef(name = "GroupVoltageDown", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> groupVoltageDown;
    @XmlElementRef(name = "GroupVoltageUp", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> groupVoltageUp;

    /**
     * 获取batteryGroupId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBatteryGroupId() {
        return batteryGroupId;
    }

    /**
     * 设置batteryGroupId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBatteryGroupId(Long value) {
        this.batteryGroupId = value;
    }

    /**
     * 获取config属性的值。
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
     * 设置config属性的值。
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
     * 获取creatTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatTime() {
        return creatTime;
    }

    /**
     * 设置creatTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatTime(XMLGregorianCalendar value) {
        this.creatTime = value;
    }

    /**
     * 获取envirTeaperature属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getEnvirTeaperature() {
        return envirTeaperature;
    }

    /**
     * 设置envirTeaperature属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setEnvirTeaperature(JAXBElement<Double> value) {
        this.envirTeaperature = value;
    }

    /**
     * 获取groupCurrentThreshold属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getGroupCurrentThreshold() {
        return groupCurrentThreshold;
    }

    /**
     * 设置groupCurrentThreshold属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setGroupCurrentThreshold(JAXBElement<Double> value) {
        this.groupCurrentThreshold = value;
    }

    /**
     * 获取groupLeakageCurrent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getGroupLeakageCurrent() {
        return groupLeakageCurrent;
    }

    /**
     * 设置groupLeakageCurrent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setGroupLeakageCurrent(JAXBElement<Double> value) {
        this.groupLeakageCurrent = value;
    }

    /**
     * 获取groupRippleCurrent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getGroupRippleCurrent() {
        return groupRippleCurrent;
    }

    /**
     * 设置groupRippleCurrent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setGroupRippleCurrent(JAXBElement<Double> value) {
        this.groupRippleCurrent = value;
    }

    /**
     * 获取groupRippleVoltage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getGroupRippleVoltage() {
        return groupRippleVoltage;
    }

    /**
     * 设置groupRippleVoltage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setGroupRippleVoltage(JAXBElement<Double> value) {
        this.groupRippleVoltage = value;
    }

    /**
     * 获取groupVoltageDown属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getGroupVoltageDown() {
        return groupVoltageDown;
    }

    /**
     * 设置groupVoltageDown属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setGroupVoltageDown(JAXBElement<Double> value) {
        this.groupVoltageDown = value;
    }

    /**
     * 获取groupVoltageUp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getGroupVoltageUp() {
        return groupVoltageUp;
    }

    /**
     * 设置groupVoltageUp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setGroupVoltageUp(JAXBElement<Double> value) {
        this.groupVoltageUp = value;
    }

}
