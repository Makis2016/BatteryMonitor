
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡcircuitId���Ե�ֵ��
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
     * ����circuitId���Ե�ֵ��
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
     * ��ȡrealVoltageIn30V���Ե�ֵ��
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
     * ����realVoltageIn30V���Ե�ֵ��
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
     * ��ȡrealVoltageIn150V���Ե�ֵ��
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
     * ����realVoltageIn150V���Ե�ֵ��
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
     * ��ȡrealVoltageIn300V���Ե�ֵ��
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
     * ����realVoltageIn300V���Ե�ֵ��
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
