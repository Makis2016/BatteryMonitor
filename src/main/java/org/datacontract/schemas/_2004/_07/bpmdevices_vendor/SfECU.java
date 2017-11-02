
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SfECU complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SfECU">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="BatteryCount" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="BaudRate" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="Channel1" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="Channel2" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="Channel3" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="CurrentAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="IdStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="IntervalTime" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="IsRefresh" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Length" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="Mac" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="NegativeCurrentAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="NegativeVoltageAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="PANId1" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="PANId2" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="PANId3" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="PANId4" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="PANId5" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="PANId6" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
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
    "channel1",
    "channel2",
    "channel3",
    "currentAddress",
    "idStatus",
    "intervalTime",
    "isRefresh",
    "length",
    "mac",
    "negativeCurrentAddress",
    "negativeVoltageAddress",
    "panId1",
    "panId2",
    "panId3",
    "panId4",
    "panId5",
    "panId6",
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
    @XmlElement(name = "Channel1")
    @XmlSchemaType(name = "unsignedByte")
    protected Short channel1;
    @XmlElement(name = "Channel2")
    @XmlSchemaType(name = "unsignedByte")
    protected Short channel2;
    @XmlElement(name = "Channel3")
    @XmlSchemaType(name = "unsignedByte")
    protected Short channel3;
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
    @XmlElement(name = "PANId1")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer panId1;
    @XmlElement(name = "PANId2")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer panId2;
    @XmlElement(name = "PANId3")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer panId3;
    @XmlElement(name = "PANId4")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer panId4;
    @XmlElement(name = "PANId5")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer panId5;
    @XmlElement(name = "PANId6")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer panId6;
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
     * 获取address属性的值。
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
     * 设置address属性的值。
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
     * 获取batteryCount属性的值。
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
     * 设置batteryCount属性的值。
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
     * 获取baudRate属性的值。
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
     * 设置baudRate属性的值。
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
     * 获取channel1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getChannel1() {
        return channel1;
    }

    /**
     * 设置channel1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setChannel1(Short value) {
        this.channel1 = value;
    }

    /**
     * 获取channel2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getChannel2() {
        return channel2;
    }

    /**
     * 设置channel2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setChannel2(Short value) {
        this.channel2 = value;
    }

    /**
     * 获取channel3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getChannel3() {
        return channel3;
    }

    /**
     * 设置channel3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setChannel3(Short value) {
        this.channel3 = value;
    }

    /**
     * 获取currentAddress属性的值。
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
     * 设置currentAddress属性的值。
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
     * 获取idStatus属性的值。
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
     * 设置idStatus属性的值。
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
     * 获取intervalTime属性的值。
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
     * 设置intervalTime属性的值。
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
     * 获取isRefresh属性的值。
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
     * 设置isRefresh属性的值。
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
     * 获取length属性的值。
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
     * 设置length属性的值。
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
     * 获取mac属性的值。
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
     * 设置mac属性的值。
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
     * 获取negativeCurrentAddress属性的值。
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
     * 设置negativeCurrentAddress属性的值。
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
     * 获取negativeVoltageAddress属性的值。
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
     * 设置negativeVoltageAddress属性的值。
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
     * 获取panId1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPANId1() {
        return panId1;
    }

    /**
     * 设置panId1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPANId1(Integer value) {
        this.panId1 = value;
    }

    /**
     * 获取panId2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPANId2() {
        return panId2;
    }

    /**
     * 设置panId2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPANId2(Integer value) {
        this.panId2 = value;
    }

    /**
     * 获取panId3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPANId3() {
        return panId3;
    }

    /**
     * 设置panId3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPANId3(Integer value) {
        this.panId3 = value;
    }

    /**
     * 获取panId4属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPANId4() {
        return panId4;
    }

    /**
     * 设置panId4属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPANId4(Integer value) {
        this.panId4 = value;
    }

    /**
     * 获取panId5属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPANId5() {
        return panId5;
    }

    /**
     * 设置panId5属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPANId5(Integer value) {
        this.panId5 = value;
    }

    /**
     * 获取panId6属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPANId6() {
        return panId6;
    }

    /**
     * 设置panId6属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPANId6(Integer value) {
        this.panId6 = value;
    }

    /**
     * 获取registerAddress属性的值。
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
     * 设置registerAddress属性的值。
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
     * 获取reserve属性的值。
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
     * 设置reserve属性的值。
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
     * 获取retry属性的值。
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
     * 设置retry属性的值。
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
     * 获取serialNumber属性的值。
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
     * 设置serialNumber属性的值。
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
     * 获取type属性的值。
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
     * 设置type属性的值。
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
     * 获取voltageAddress属性的值。
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
     * 设置voltageAddress属性的值。
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
     * 获取zigBeeLocal属性的值。
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
     * 设置zigBeeLocal属性的值。
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
     * 获取zigBeeTarget属性的值。
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
     * 设置zigBeeTarget属性的值。
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
