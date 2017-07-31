
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.ArrayOfCircuitInfo;


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
 *         &lt;element name="GetCircuitListResult" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel}ArrayOfCircuitInfo" minOccurs="0"/>
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
    "getCircuitListResult"
})
@XmlRootElement(name = "GetCircuitListResponse")
public class GetCircuitListResponse {

    @XmlElementRef(name = "GetCircuitListResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfCircuitInfo> getCircuitListResult;

    /**
     * 获取getCircuitListResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCircuitInfo }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCircuitInfo> getGetCircuitListResult() {
        return getCircuitListResult;
    }

    /**
     * 设置getCircuitListResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCircuitInfo }{@code >}
     *     
     */
    public void setGetCircuitListResult(JAXBElement<ArrayOfCircuitInfo> value) {
        this.getCircuitListResult = value;
    }

}
