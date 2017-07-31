
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryPackThreshold;


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
 *         &lt;element name="batteryPackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="batteryGroupThreshold" type="{http://schemas.datacontract.org/2004/07/BPMDevices}BatteryPackThreshold" minOccurs="0"/>
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
    "batteryPackId",
    "batteryGroupThreshold"
})
@XmlRootElement(name = "UpdateBatteryGroupThreshold")
public class UpdateBatteryGroupThreshold {

    protected Long batteryPackId;
    @XmlElementRef(name = "batteryGroupThreshold", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<BatteryPackThreshold> batteryGroupThreshold;

    /**
     * 获取batteryPackId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBatteryPackId() {
        return batteryPackId;
    }

    /**
     * 设置batteryPackId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBatteryPackId(Long value) {
        this.batteryPackId = value;
    }

    /**
     * 获取batteryGroupThreshold属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BatteryPackThreshold }{@code >}
     *     
     */
    public JAXBElement<BatteryPackThreshold> getBatteryGroupThreshold() {
        return batteryGroupThreshold;
    }

    /**
     * 设置batteryGroupThreshold属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BatteryPackThreshold }{@code >}
     *     
     */
    public void setBatteryGroupThreshold(JAXBElement<BatteryPackThreshold> value) {
        this.batteryGroupThreshold = value;
    }

}
