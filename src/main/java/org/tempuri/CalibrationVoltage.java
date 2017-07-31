
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="circuitId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="realVoltageIn30V" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="realVoltageIn150V" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="realVoltageIn300V" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
    "realVoltageIn30V",
    "realVoltageIn150V",
    "realVoltageIn300V"
})
@XmlRootElement(name = "CalibrationVoltage")
public class CalibrationVoltage {

    protected Long circuitId;
    protected Double realVoltageIn30V;
    protected Double realVoltageIn150V;
    protected Double realVoltageIn300V;

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
     * 获取realVoltageIn30V属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRealVoltageIn30V() {
        return realVoltageIn30V;
    }

    /**
     * 设置realVoltageIn30V属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRealVoltageIn30V(Double value) {
        this.realVoltageIn30V = value;
    }

    /**
     * 获取realVoltageIn150V属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRealVoltageIn150V() {
        return realVoltageIn150V;
    }

    /**
     * 设置realVoltageIn150V属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRealVoltageIn150V(Double value) {
        this.realVoltageIn150V = value;
    }

    /**
     * 获取realVoltageIn300V属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRealVoltageIn300V() {
        return realVoltageIn300V;
    }

    /**
     * 设置realVoltageIn300V属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRealVoltageIn300V(Double value) {
        this.realVoltageIn300V = value;
    }

}
