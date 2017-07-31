
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SfBCU complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
