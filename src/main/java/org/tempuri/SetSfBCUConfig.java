
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.SfBCU;


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
 *         &lt;element name="bcu" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu}SfBCU" minOccurs="0"/>
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
    "bcu"
})
@XmlRootElement(name = "SetSfBCUConfig")
public class SetSfBCUConfig {

    protected Long circuitId;
    @XmlElementRef(name = "bcu", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<SfBCU> bcu;

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
     * ��ȡbcu���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SfBCU }{@code >}
     *     
     */
    public JAXBElement<SfBCU> getBcu() {
        return bcu;
    }

    /**
     * ����bcu���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SfBCU }{@code >}
     *     
     */
    public void setBcu(JAXBElement<SfBCU> value) {
        this.bcu = value;
    }

}
