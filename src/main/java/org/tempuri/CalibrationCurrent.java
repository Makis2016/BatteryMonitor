
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
 *         &lt;element name="realCurrentIn10A" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="realCurrentIn50A" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="realCurrentIn100A" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
    "realCurrentIn10A",
    "realCurrentIn50A",
    "realCurrentIn100A"
})
@XmlRootElement(name = "CalibrationCurrent")
public class CalibrationCurrent {

    protected Long circuitId;
    protected Double realCurrentIn10A;
    protected Double realCurrentIn50A;
    protected Double realCurrentIn100A;

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
     * 获取realCurrentIn10A属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRealCurrentIn10A() {
        return realCurrentIn10A;
    }

    /**
     * 设置realCurrentIn10A属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRealCurrentIn10A(Double value) {
        this.realCurrentIn10A = value;
    }

    /**
     * 获取realCurrentIn50A属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRealCurrentIn50A() {
        return realCurrentIn50A;
    }

    /**
     * 设置realCurrentIn50A属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRealCurrentIn50A(Double value) {
        this.realCurrentIn50A = value;
    }

    /**
     * 获取realCurrentIn100A属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRealCurrentIn100A() {
        return realCurrentIn100A;
    }

    /**
     * 设置realCurrentIn100A属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRealCurrentIn100A(Double value) {
        this.realCurrentIn100A = value;
    }

}
