
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="SetCircuitBatteryPackResult" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "setCircuitBatteryPackResult"
})
@XmlRootElement(name = "SetCircuitBatteryPackResponse")
public class SetCircuitBatteryPackResponse {

    @XmlElement(name = "SetCircuitBatteryPackResult")
    protected Boolean setCircuitBatteryPackResult;

    /**
     * 获取setCircuitBatteryPackResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSetCircuitBatteryPackResult() {
        return setCircuitBatteryPackResult;
    }

    /**
     * 设置setCircuitBatteryPackResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSetCircuitBatteryPackResult(Boolean value) {
        this.setCircuitBatteryPackResult = value;
    }

}
