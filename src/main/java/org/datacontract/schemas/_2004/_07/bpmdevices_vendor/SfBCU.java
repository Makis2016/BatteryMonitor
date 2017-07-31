
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SfBCU complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SfBCU">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="BaudRate" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="Channel" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="IdStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="IsRefresh" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Length" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="Mac" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="PANId" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="RegisterAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="Reserve" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="SerialNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
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
@XmlType(name = "SfBCU", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", propOrder = {
    "address",
    "baudRate",
    "channel",
    "idStatus",
    "isRefresh",
    "length",
    "mac",
    "panId",
    "registerAddress",
    "reserve",
    "serialNumber",
    "type",
    "zigBeeLocal",
    "zigBeeTarget"
})
public class SfBCU {

    @XmlElement(name = "Address")
    @XmlSchemaType(name = "unsignedByte")
    protected Short address;
    @XmlElement(name = "BaudRate")
    @XmlSchemaType(name = "unsignedByte")
    protected Short baudRate;
    @XmlElement(name = "Channel")
    @XmlSchemaType(name = "unsignedByte")
    protected Short channel;
    @XmlElement(name = "IdStatus")
    @XmlSchemaType(name = "unsignedByte")
    protected Short idStatus;
    @XmlElement(name = "IsRefresh")
    protected Boolean isRefresh;
    @XmlElement(name = "Length")
    @XmlSchemaType(name = "unsignedByte")
    protected Short length;
    @XmlElementRef(name = "Mac", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> mac;
    @XmlElement(name = "PANId")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer panId;
    @XmlElement(name = "RegisterAddress")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer registerAddress;
    @XmlElementRef(name = "Reserve", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> reserve;
    @XmlElement(name = "SerialNumber")
    @XmlSchemaType(name = "unsignedByte")
    protected Short serialNumber;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "unsignedByte")
    protected Short type;
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
     * 获取channel属性的值。
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
     * 设置channel属性的值。
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
     * 获取panId属性的值。
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
     * 设置panId属性的值。
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
