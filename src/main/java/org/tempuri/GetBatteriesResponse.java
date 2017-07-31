
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.ArrayOfBattery;


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
 *         &lt;element name="GetBatteriesResult" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}ArrayOfBattery" minOccurs="0"/>
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
    "getBatteriesResult"
})
@XmlRootElement(name = "GetBatteriesResponse")
public class GetBatteriesResponse {

    @XmlElementRef(name = "GetBatteriesResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfBattery> getBatteriesResult;

    /**
     * 获取getBatteriesResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBattery> getGetBatteriesResult() {
        return getBatteriesResult;
    }

    /**
     * 设置getBatteriesResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}
     *     
     */
    public void setGetBatteriesResult(JAXBElement<ArrayOfBattery> value) {
        this.getBatteriesResult = value;
    }

}
