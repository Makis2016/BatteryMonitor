
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
 * <p>BatteryPackThreshold complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡbatteryGroupId���Ե�ֵ��
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
     * ����batteryGroupId���Ե�ֵ��
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
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatTime() {
        return creatTime;
    }

    /**
     * ����creatTime���Ե�ֵ��
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
     * ��ȡenvirTeaperature���Ե�ֵ��
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
     * ����envirTeaperature���Ե�ֵ��
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
     * ��ȡgroupCurrentThreshold���Ե�ֵ��
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
     * ����groupCurrentThreshold���Ե�ֵ��
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
     * ��ȡgroupLeakageCurrent���Ե�ֵ��
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
     * ����groupLeakageCurrent���Ե�ֵ��
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
     * ��ȡgroupRippleCurrent���Ե�ֵ��
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
     * ����groupRippleCurrent���Ե�ֵ��
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
     * ��ȡgroupRippleVoltage���Ե�ֵ��
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
     * ����groupRippleVoltage���Ե�ֵ��
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
     * ��ȡgroupVoltageDown���Ե�ֵ��
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
     * ����groupVoltageDown���Ե�ֵ��
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
     * ��ȡgroupVoltageUp���Ե�ֵ��
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
     * ����groupVoltageUp���Ե�ֵ��
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
