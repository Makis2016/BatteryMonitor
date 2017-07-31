
package org.datacontract.schemas._2004._07.bpmservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DataAccuracyInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DataAccuracyInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Current" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="EnvironmentTemperature" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="LeakageCurrent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="PackVoltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Resistance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="RippleVoltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Temperature" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Voltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataAccuracyInfo", propOrder = {
    "current",
    "environmentTemperature",
    "leakageCurrent",
    "packVoltage",
    "resistance",
    "rippleVoltage",
    "temperature",
    "voltage"
})
public class DataAccuracyInfo {

    @XmlElement(name = "Current")
    protected Double current;
    @XmlElement(name = "EnvironmentTemperature")
    protected Double environmentTemperature;
    @XmlElement(name = "LeakageCurrent")
    protected Double leakageCurrent;
    @XmlElement(name = "PackVoltage")
    protected Double packVoltage;
    @XmlElement(name = "Resistance")
    protected Double resistance;
    @XmlElement(name = "RippleVoltage")
    protected Double rippleVoltage;
    @XmlElement(name = "Temperature")
    protected Double temperature;
    @XmlElement(name = "Voltage")
    protected Double voltage;

    /**
     * ��ȡcurrent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCurrent() {
        return current;
    }

    /**
     * ����current���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCurrent(Double value) {
        this.current = value;
    }

    /**
     * ��ȡenvironmentTemperature���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getEnvironmentTemperature() {
        return environmentTemperature;
    }

    /**
     * ����environmentTemperature���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setEnvironmentTemperature(Double value) {
        this.environmentTemperature = value;
    }

    /**
     * ��ȡleakageCurrent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLeakageCurrent() {
        return leakageCurrent;
    }

    /**
     * ����leakageCurrent���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLeakageCurrent(Double value) {
        this.leakageCurrent = value;
    }

    /**
     * ��ȡpackVoltage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPackVoltage() {
        return packVoltage;
    }

    /**
     * ����packVoltage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPackVoltage(Double value) {
        this.packVoltage = value;
    }

    /**
     * ��ȡresistance���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getResistance() {
        return resistance;
    }

    /**
     * ����resistance���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setResistance(Double value) {
        this.resistance = value;
    }

    /**
     * ��ȡrippleVoltage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRippleVoltage() {
        return rippleVoltage;
    }

    /**
     * ����rippleVoltage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRippleVoltage(Double value) {
        this.rippleVoltage = value;
    }

    /**
     * ��ȡtemperature���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * ����temperature���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTemperature(Double value) {
        this.temperature = value;
    }

    /**
     * ��ȡvoltage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVoltage() {
        return voltage;
    }

    /**
     * ����voltage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVoltage(Double value) {
        this.voltage = value;
    }

}
