
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.datacontract.schemas._2004._07.bpmdevices.AlarmManagerAlarmLevel;


/**
 * <p>Alarm complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Alarm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mAlarmId" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}AlarmConfig.AlarmType" minOccurs="0"/>
 *         &lt;element name="mAlarmMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mAreaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mAreaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mBatteryPackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mCircuitId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mEndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="mId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mIgnoreTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="mLevel" type="{http://schemas.datacontract.org/2004/07/BPMDevices}AlarmManager.AlarmLevel" minOccurs="0"/>
 *         &lt;element name="mMaintainAdvise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mStrarTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Alarm", propOrder = {
    "key",
    "mAlarmId",
    "mAlarmMessage",
    "mAreaId",
    "mAreaName",
    "mBatteryPackId",
    "mCircuitId",
    "mEndTime",
    "mId",
    "mIgnoreTime",
    "mLevel",
    "mMaintainAdvise",
    "mStrarTime"
})
public class Alarm {

    @XmlElementRef(name = "key", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> key;
    @XmlSchemaType(name = "string")
    protected AlarmConfigAlarmType mAlarmId;
    @XmlElementRef(name = "mAlarmMessage", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mAlarmMessage;
    protected Long mAreaId;
    @XmlElementRef(name = "mAreaName", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mAreaName;
    protected Long mBatteryPackId;
    protected Long mCircuitId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar mEndTime;
    protected Long mId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar mIgnoreTime;
    @XmlSchemaType(name = "string")
    protected AlarmManagerAlarmLevel mLevel;
    @XmlElementRef(name = "mMaintainAdvise", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mMaintainAdvise;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar mStrarTime;

    /**
     * 获取key属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKey() {
        return key;
    }

    /**
     * 设置key属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKey(JAXBElement<String> value) {
        this.key = value;
    }

    /**
     * 获取mAlarmId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AlarmConfigAlarmType }
     *     
     */
    public AlarmConfigAlarmType getMAlarmId() {
        return mAlarmId;
    }

    /**
     * 设置mAlarmId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmConfigAlarmType }
     *     
     */
    public void setMAlarmId(AlarmConfigAlarmType value) {
        this.mAlarmId = value;
    }

    /**
     * 获取mAlarmMessage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMAlarmMessage() {
        return mAlarmMessage;
    }

    /**
     * 设置mAlarmMessage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMAlarmMessage(JAXBElement<String> value) {
        this.mAlarmMessage = value;
    }

    /**
     * 获取mAreaId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMAreaId() {
        return mAreaId;
    }

    /**
     * 设置mAreaId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMAreaId(Long value) {
        this.mAreaId = value;
    }

    /**
     * 获取mAreaName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMAreaName() {
        return mAreaName;
    }

    /**
     * 设置mAreaName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMAreaName(JAXBElement<String> value) {
        this.mAreaName = value;
    }

    /**
     * 获取mBatteryPackId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMBatteryPackId() {
        return mBatteryPackId;
    }

    /**
     * 设置mBatteryPackId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMBatteryPackId(Long value) {
        this.mBatteryPackId = value;
    }

    /**
     * 获取mCircuitId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMCircuitId() {
        return mCircuitId;
    }

    /**
     * 设置mCircuitId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMCircuitId(Long value) {
        this.mCircuitId = value;
    }

    /**
     * 获取mEndTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMEndTime() {
        return mEndTime;
    }

    /**
     * 设置mEndTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMEndTime(XMLGregorianCalendar value) {
        this.mEndTime = value;
    }

    /**
     * 获取mId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMId() {
        return mId;
    }

    /**
     * 设置mId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMId(Long value) {
        this.mId = value;
    }

    /**
     * 获取mIgnoreTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMIgnoreTime() {
        return mIgnoreTime;
    }

    /**
     * 设置mIgnoreTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMIgnoreTime(XMLGregorianCalendar value) {
        this.mIgnoreTime = value;
    }

    /**
     * 获取mLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AlarmManagerAlarmLevel }
     *     
     */
    public AlarmManagerAlarmLevel getMLevel() {
        return mLevel;
    }

    /**
     * 设置mLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmManagerAlarmLevel }
     *     
     */
    public void setMLevel(AlarmManagerAlarmLevel value) {
        this.mLevel = value;
    }

    /**
     * 获取mMaintainAdvise属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMMaintainAdvise() {
        return mMaintainAdvise;
    }

    /**
     * 设置mMaintainAdvise属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMMaintainAdvise(JAXBElement<String> value) {
        this.mMaintainAdvise = value;
    }

    /**
     * 获取mStrarTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMStrarTime() {
        return mStrarTime;
    }

    /**
     * 设置mStrarTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMStrarTime(XMLGregorianCalendar value) {
        this.mStrarTime = value;
    }

}
