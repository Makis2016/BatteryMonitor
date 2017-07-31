
package org.datacontract.schemas._2004._07.bpmservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DataAccuracyInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取current属性的值。
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
     * 设置current属性的值。
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
     * 获取environmentTemperature属性的值。
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
     * 设置environmentTemperature属性的值。
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
     * 获取leakageCurrent属性的值。
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
     * 设置leakageCurrent属性的值。
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
     * 获取packVoltage属性的值。
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
     * 设置packVoltage属性的值。
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
     * 获取resistance属性的值。
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
     * 设置resistance属性的值。
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
     * 获取rippleVoltage属性的值。
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
     * 设置rippleVoltage属性的值。
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
     * 获取temperature属性的值。
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
     * 设置temperature属性的值。
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
     * 获取voltage属性的值。
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
     * 设置voltage属性的值。
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
