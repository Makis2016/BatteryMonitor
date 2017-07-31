
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.CircuitInfo;


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
 *         &lt;element name="circuitInfo" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel}CircuitInfo" minOccurs="0"/>
 *         &lt;element name="updateUserId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "circuitInfo",
    "updateUserId"
})
@XmlRootElement(name = "UpdateCircuit")
public class UpdateCircuit {

    @XmlElementRef(name = "circuitInfo", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<CircuitInfo> circuitInfo;
    protected Long updateUserId;

    /**
     * ��ȡcircuitInfo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CircuitInfo }{@code >}
     *     
     */
    public JAXBElement<CircuitInfo> getCircuitInfo() {
        return circuitInfo;
    }

    /**
     * ����circuitInfo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CircuitInfo }{@code >}
     *     
     */
    public void setCircuitInfo(JAXBElement<CircuitInfo> value) {
        this.circuitInfo = value;
    }

    /**
     * ��ȡupdateUserId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * ����updateUserId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUpdateUserId(Long value) {
        this.updateUserId = value;
    }

}
