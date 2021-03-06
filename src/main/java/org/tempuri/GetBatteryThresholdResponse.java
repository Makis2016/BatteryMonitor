
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryThreshold;


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
 *         &lt;element name="GetBatteryThresholdResult" type="{http://schemas.datacontract.org/2004/07/BPMDevices}BatteryThreshold" minOccurs="0"/>
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
    "getBatteryThresholdResult"
})
@XmlRootElement(name = "GetBatteryThresholdResponse")
public class GetBatteryThresholdResponse {

    @XmlElementRef(name = "GetBatteryThresholdResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<BatteryThreshold> getBatteryThresholdResult;

    /**
     * 获取getBatteryThresholdResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BatteryThreshold }{@code >}
     *     
     */
    public JAXBElement<BatteryThreshold> getGetBatteryThresholdResult() {
        return getBatteryThresholdResult;
    }

    /**
     * 设置getBatteryThresholdResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BatteryThreshold }{@code >}
     *     
     */
    public void setGetBatteryThresholdResult(JAXBElement<BatteryThreshold> value) {
        this.getBatteryThresholdResult = value;
    }

}
