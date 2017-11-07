
package org.datacontract.schemas._2004._07.bpmservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CurentDucer complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CurentDucer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChargeInputCurrent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ChargeOutputVoltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DischargeInputCurrent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DischargeOutputVoltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurentDucer", propOrder = {
    "chargeInputCurrent",
    "chargeOutputVoltage",
    "dischargeInputCurrent",
    "dischargeOutputVoltage"
})
public class CurentDucer {

    @XmlElement(name = "ChargeInputCurrent")
    protected Double chargeInputCurrent;
    @XmlElement(name = "ChargeOutputVoltage")
    protected Double chargeOutputVoltage;
    @XmlElement(name = "DischargeInputCurrent")
    protected Double dischargeInputCurrent;
    @XmlElement(name = "DischargeOutputVoltage")
    protected Double dischargeOutputVoltage;

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
