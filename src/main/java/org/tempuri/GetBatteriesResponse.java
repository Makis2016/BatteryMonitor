
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.ArrayOfBattery;


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
 *         &lt;element name="GetBatteriesResult" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}ArrayOfBattery" minOccurs="0"/>
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
    "getBatteriesResult"
})
@XmlRootElement(name = "GetBatteriesResponse")
public class GetBatteriesResponse {

    @XmlElementRef(name = "GetBatteriesResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfBattery> getBatteriesResult;

    /**
     * ��ȡgetBatteriesResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBattery> getGetBatteriesResult() {
        return getBatteriesResult;
    }

    /**
     * ����getBatteriesResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}
     *     
     */
    public void setGetBatteriesResult(JAXBElement<ArrayOfBattery> value) {
        this.getBatteriesResult = value;
    }

}
