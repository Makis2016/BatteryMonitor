
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SfECU complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SfECU">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="BatteryCount" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="BaudRate" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="Channel" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="CurrentAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="IdStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="IntervalTime" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="IsRefresh" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Length" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="Mac" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="NegativeCurrentAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="NegativeVoltageAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="PANId" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="RegisterAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="Reserve" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="Retry" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="SerialNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="VoltageAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="ZigBeeLocal" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="ZigBeeTarget" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SfECU", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", propOrder = {
    "address",
    "batteryCount",
    "baudRate",
    "channel",
    "currentAddress",
    "idStatus",
    "intervalTime",
    "isRefresh",
    "length",
    "mac",
    "negativeCurrentAddress",
    "negativeVoltageAddress",
    "panId",
    "registerAddress",
    "reserve",
    "retry",
    "serialNumber",
    "type",
    "voltageAddress",
    "zigBeeLocal",
    "zigBeeTarget"
})
public class SfECU {

    @XmlElement(name = "Address")
    @XmlSchemaType(name = "unsignedByte")
    protected Short address;
    @XmlElement(name = "BatteryCount")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer batteryCount;
    @XmlElement(name = "BaudRate")
    @XmlSchemaType(name = "unsignedByte")
    protected Short baudRate;
    @XmlElement(name = "Channel")
    @XmlSchemaType(name = "unsignedByte")
    protected Short channel;
    @XmlElement(name = "CurrentAddress")
    @XmlSchemaType(name = "unsignedByte")
    protected Short currentAddress;
    @XmlElement(name = "IdStatus")
    @XmlSchemaType(name = "unsignedByte")
    protected Short idStatus;
    @XmlElement(name = "IntervalTime")
    @XmlSchemaType(name = "unsignedByte")
    protected Short intervalTime;
    @XmlElement(name = "IsRefresh")
    protected Boolean isRefresh;
    @XmlElement(name = "Length")
    @XmlSchemaType(name = "unsignedByte")
    protected Short length;
    @XmlElementRef(name = "Mac", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> mac;
    @XmlElement(name = "NegativeCurrentAddress")
    @XmlSchemaType(name = "unsignedByte")
    protected Short negativeCurrentAddress;
    @XmlElement(name = "NegativeVoltageAddress")
    @XmlSchemaType(name = "unsignedByte")
    protected Short negativeVoltageAddress;
    @XmlElement(name = "PANId")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer panId;
    @XmlElement(name = "RegisterAddress")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer registerAddress;
    @XmlElementRef(name = "Reserve", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> reserve;
    @XmlElement(name = "Retry")
    @XmlSchemaType(name = "unsignedByte")
    protected Short retry;
    @XmlElement(name = "SerialNumber")
    @XmlSchemaType(name = "unsignedByte")
    protected Short serialNumber;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "unsignedByte")
    protected Short type;
    @XmlElement(name = "VoltageAddress")
    @XmlSchemaType(name = "unsignedByte")
    protected Short voltageAddress;
    @XmlElement(name = "ZigBeeLocal")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer zigBeeLocal;
    @XmlElement(name = "ZigBeeTarget")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer zigBeeTarget;

    /**
     * ��ȡaddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getAddress() {
        return address;
    }

    /**
     * ����address���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setAddress(Short value) {
        this.address = value;
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
     * ��ȡbaudRate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getBaudRate() {
        return baudRate;
    }

    /**
     * ����baudRate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setBaudRate(Short value) {
        this.baudRate = value;
    }

    /**
     * ��ȡchannel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getChannel() {
        return channel;
    }

    /**
     * ����channel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setChannel(Short value) {
        this.channel = value;
    }

    /**
     * ��ȡcurrentAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCurrentAddress() {
        return currentAddress;
    }

    /**
     * ����currentAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCurrentAddress(Short value) {
        this.currentAddress = value;
    }

    /**
     * ��ȡidStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getIdStatus() {
        return idStatus;
    }

    /**
     * ����idStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setIdStatus(Short value) {
        this.idStatus = value;
    }

    /**
     * ��ȡintervalTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getIntervalTime() {
        return intervalTime;
    }

    /**
     * ����intervalTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setIntervalTime(Short value) {
        this.intervalTime = value;
    }

    /**
     * ��ȡisRefresh���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRefresh() {
        return isRefresh;
    }

    /**
     * ����isRefresh���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRefresh(Boolean value) {
        this.isRefresh = value;
    }

    /**
     * ��ȡlength���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getLength() {
        return length;
    }

    /**
     * ����length���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setLength(Short value) {
        this.length = value;
    }

    /**
     * ��ȡmac���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getMac() {
        return mac;
    }

    /**
     * ����mac���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setMac(JAXBElement<byte[]> value) {
        this.mac = value;
    }

    /**
     * ��ȡnegativeCurrentAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNegativeCurrentAddress() {
        return negativeCurrentAddress;
    }

    /**
     * ����negativeCurrentAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNegativeCurrentAddress(Short value) {
        this.negativeCurrentAddress = value;
    }

    /**
     * ��ȡnegativeVoltageAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNegativeVoltageAddress() {
        return negativeVoltageAddress;
    }

    /**
     * ����negativeVoltageAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNegativeVoltageAddress(Short value) {
        this.negativeVoltageAddress = value;
    }

    /**
     * ��ȡpanId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPANId() {
        return panId;
    }

    /**
     * ����panId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPANId(Integer value) {
        this.panId = value;
    }

    /**
     * ��ȡregisterAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRegisterAddress() {
        return registerAddress;
    }

    /**
     * ����registerAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRegisterAddress(Integer value) {
        this.registerAddress = value;
    }

    /**
     * ��ȡreserve���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getReserve() {
        return reserve;
    }

    /**
     * ����reserve���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setReserve(JAXBElement<byte[]> value) {
        this.reserve = value;
    }

    /**
     * ��ȡretry���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getRetry() {
        return retry;
    }

    /**
     * ����retry���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setRetry(Short value) {
        this.retry = value;
    }

    /**
     * ��ȡserialNumber���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getSerialNumber() {
        return serialNumber;
    }

    /**
     * ����serialNumber���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setSerialNumber(Short value) {
        this.serialNumber = value;
    }

    /**
     * ��ȡtype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getType() {
        return type;
    }

    /**
     * ����type���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setType(Short value) {
        this.type = value;
    }

    /**
     * ��ȡvoltageAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getVoltageAddress() {
        return voltageAddress;
    }

    /**
     * ����voltageAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setVoltageAddress(Short value) {
        this.voltageAddress = value;
    }

    /**
     * ��ȡzigBeeLocal���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZigBeeLocal() {
        return zigBeeLocal;
    }

    /**
     * ����zigBeeLocal���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZigBeeLocal(Integer value) {
        this.zigBeeLocal = value;
    }

    /**
     * ��ȡzigBeeTarget���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZigBeeTarget() {
        return zigBeeTarget;
    }

    /**
     * ����zigBeeTarget���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZigBeeTarget(Integer value) {
        this.zigBeeTarget = value;
    }

}
