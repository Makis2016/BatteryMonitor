
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
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *         &lt;element name="deviceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "category",
    "deviceId"
})
@XmlRootElement(name = "CircuitAddDevice")
public class CircuitAddDevice {

    protected Long circuitId;
    protected Byte category;
    protected Long deviceId;

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
     * ��ȡcategory���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getCategory() {
        return category;
    }

    /**
     * ����category���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setCategory(Byte value) {
        this.category = value;
    }

    /**
     * ��ȡdeviceId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeviceId() {
        return deviceId;
    }

    /**
     * ����deviceId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeviceId(Long value) {
        this.deviceId = value;
    }

}
