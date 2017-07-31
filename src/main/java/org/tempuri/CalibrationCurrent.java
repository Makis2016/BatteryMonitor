
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
     * ��ȡrealCurrentIn10A���Ե�ֵ��
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
     * ����realCurrentIn10A���Ե�ֵ��
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
     * ��ȡrealCurrentIn50A���Ե�ֵ��
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
     * ����realCurrentIn50A���Ե�ֵ��
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
     * ��ȡrealCurrentIn100A���Ե�ֵ��
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
     * ����realCurrentIn100A���Ե�ֵ��
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
