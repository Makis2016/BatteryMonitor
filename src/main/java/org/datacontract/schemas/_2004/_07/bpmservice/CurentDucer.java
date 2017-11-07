
package org.datacontract.schemas._2004._07.bpmservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CurentDucer complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡchargeInputCurrent���Ե�ֵ��
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
     * ����chargeInputCurrent���Ե�ֵ��
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
     * ��ȡchargeOutputVoltage���Ե�ֵ��
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
     * ����chargeOutputVoltage���Ե�ֵ��
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
     * ��ȡdischargeInputCurrent���Ե�ֵ��
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
     * ����dischargeInputCurrent���Ե�ֵ��
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
     * ��ȡdischargeOutputVoltage���Ե�ֵ��
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
     * ����dischargeOutputVoltage���Ե�ֵ��
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
