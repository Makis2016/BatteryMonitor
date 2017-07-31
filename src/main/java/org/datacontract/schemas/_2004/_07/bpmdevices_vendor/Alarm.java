
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
 * <p>Alarm complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡkey���Ե�ֵ��
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
     * ����key���Ե�ֵ��
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
     * ��ȡmAlarmId���Ե�ֵ��
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
     * ����mAlarmId���Ե�ֵ��
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
     * ��ȡmAlarmMessage���Ե�ֵ��
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
     * ����mAlarmMessage���Ե�ֵ��
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
     * ��ȡmAreaId���Ե�ֵ��
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
     * ����mAreaId���Ե�ֵ��
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
     * ��ȡmAreaName���Ե�ֵ��
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
     * ����mAreaName���Ե�ֵ��
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
     * ��ȡmBatteryPackId���Ե�ֵ��
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
     * ����mBatteryPackId���Ե�ֵ��
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
     * ��ȡmCircuitId���Ե�ֵ��
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
     * ����mCircuitId���Ե�ֵ��
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
     * ��ȡmEndTime���Ե�ֵ��
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
     * ����mEndTime���Ե�ֵ��
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
     * ��ȡmId���Ե�ֵ��
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
     * ����mId���Ե�ֵ��
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
     * ��ȡmIgnoreTime���Ե�ֵ��
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
     * ����mIgnoreTime���Ե�ֵ��
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
     * ��ȡmLevel���Ե�ֵ��
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
     * ����mLevel���Ե�ֵ��
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
     * ��ȡmMaintainAdvise���Ե�ֵ��
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
     * ����mMaintainAdvise���Ե�ֵ��
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
     * ��ȡmStrarTime���Ե�ֵ��
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
     * ����mStrarTime���Ե�ֵ��
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