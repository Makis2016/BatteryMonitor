
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="GetBatteryCalcAlarmDllVersionResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getBatteryCalcAlarmDllVersionResult"
})
@XmlRootElement(name = "GetBatteryCalcAlarmDllVersionResponse")
public class GetBatteryCalcAlarmDllVersionResponse {

    @XmlElementRef(name = "GetBatteryCalcAlarmDllVersionResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> getBatteryCalcAlarmDllVersionResult;

    /**
     * 获取getBatteryCalcAlarmDllVersionResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGetBatteryCalcAlarmDllVersionResult() {
        return getBatteryCalcAlarmDllVersionResult;
    }

    /**
     * 设置getBatteryCalcAlarmDllVersionResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGetBatteryCalcAlarmDllVersionResult(JAXBElement<String> value) {
        this.getBatteryCalcAlarmDllVersionResult = value;
    }

}
