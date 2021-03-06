
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
 *         &lt;element name="chargeInputCurrent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="chargeOutputVoltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="dischargeInputCurrent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="dischargeOutputVoltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
    "chargeInputCurrent",
    "chargeOutputVoltage",
    "dischargeInputCurrent",
    "dischargeOutputVoltage"
})
@XmlRootElement(name = "SetCurrentDucer")
public class SetCurrentDucer {

    protected Long circuitId;
    protected Double chargeInputCurrent;
    protected Double chargeOutputVoltage;
    protected Double dischargeInputCurrent;
    protected Double dischargeOutputVoltage;

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
     * 获取chargeInputCurrent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getChargeInputCurrent() {
        return chargeInputCurrent;
    }

    /**
     * 设置chargeInputCurrent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setChargeInputCurrent(Double value) {
        this.chargeInputCurrent = value;
    }

    /**
     * 获取chargeOutputVoltage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getChargeOutputVoltage() {
        return chargeOutputVoltage;
    }

    /**
     * 设置chargeOutputVoltage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setChargeOutputVoltage(Double value) {
        this.chargeOutputVoltage = value;
    }

    /**
     * 获取dischargeInputCurrent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDischargeInputCurrent() {
        return dischargeInputCurrent;
    }

    /**
     * 设置dischargeInputCurrent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDischargeInputCurrent(Double value) {
        this.dischargeInputCurrent = value;
    }

    /**
     * 获取dischargeOutputVoltage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDischargeOutputVoltage() {
        return dischargeOutputVoltage;
    }

    /**
     * 设置dischargeOutputVoltage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDischargeOutputVoltage(Double value) {
        this.dischargeOutputVoltage = value;
    }

}
