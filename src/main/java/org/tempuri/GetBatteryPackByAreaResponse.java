
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.ArrayOfBatteryPack;


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
 *         &lt;element name="GetBatteryPackByAreaResult" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}ArrayOfBatteryPack" minOccurs="0"/>
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
    "getBatteryPackByAreaResult"
})
@XmlRootElement(name = "GetBatteryPackByAreaResponse")
public class GetBatteryPackByAreaResponse {

    @XmlElementRef(name = "GetBatteryPackByAreaResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfBatteryPack> getBatteryPackByAreaResult;

    /**
     * 获取getBatteryPackByAreaResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBatteryPack }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBatteryPack> getGetBatteryPackByAreaResult() {
        return getBatteryPackByAreaResult;
    }

    /**
     * 设置getBatteryPackByAreaResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBatteryPack }{@code >}
     *     
     */
    public void setGetBatteryPackByAreaResult(JAXBElement<ArrayOfBatteryPack> value) {
        this.getBatteryPackByAreaResult = value;
    }

}
