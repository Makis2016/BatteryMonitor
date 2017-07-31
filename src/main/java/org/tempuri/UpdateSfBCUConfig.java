
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.SfBCU;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="circuitId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bcu" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu}SfBCU" minOccurs="0"/>
 *         &lt;element name="newRegisterAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="oldRegisterAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "circuitId",
    "bcu",
    "newRegisterAddress",
    "oldRegisterAddress"
})
@XmlRootElement(name = "UpdateSfBCUConfig")
public class UpdateSfBCUConfig {

    protected Long circuitId;
    @XmlElementRef(name = "bcu", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<SfBCU> bcu;
    @XmlSchemaType(name = "unsignedShort")
    protected Integer newRegisterAddress;
    @XmlSchemaType(name = "unsignedShort")
    protected Integer oldRegisterAddress;

    /**
     * 获取circuitId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCircuitId() {
        return circuitId;
    }

    /**
     * 设置circuitId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCircuitId(Long value) {
        this.circuitId = value;
    }

    /**
     * 获取bcu属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SfBCU }{@code >}
     *     
     */
    public JAXBElement<SfBCU> getBcu() {
        return bcu;
    }

    /**
     * 设置bcu属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SfBCU }{@code >}
     *     
     */
    public void setBcu(JAXBElement<SfBCU> value) {
        this.bcu = value;
    }

    /**
     * 获取newRegisterAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNewRegisterAddress() {
        return newRegisterAddress;
    }

    /**
     * 设置newRegisterAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNewRegisterAddress(Integer value) {
        this.newRegisterAddress = value;
    }

    /**
     * 获取oldRegisterAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOldRegisterAddress() {
        return oldRegisterAddress;
    }

    /**
     * 设置oldRegisterAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOldRegisterAddress(Integer value) {
        this.oldRegisterAddress = value;
    }

}
