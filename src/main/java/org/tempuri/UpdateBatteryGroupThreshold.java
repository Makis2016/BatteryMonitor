
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryPackThreshold;


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
 *         &lt;element name="batteryPackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="batteryGroupThreshold" type="{http://schemas.datacontract.org/2004/07/BPMDevices}BatteryPackThreshold" minOccurs="0"/>
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
    "batteryPackId",
    "batteryGroupThreshold"
})
@XmlRootElement(name = "UpdateBatteryGroupThreshold")
public class UpdateBatteryGroupThreshold {

    protected Long batteryPackId;
    @XmlElementRef(name = "batteryGroupThreshold", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<BatteryPackThreshold> batteryGroupThreshold;

    /**
     * ��ȡbatteryPackId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBatteryPackId() {
        return batteryPackId;
    }

    /**
     * ����batteryPackId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBatteryPackId(Long value) {
        this.batteryPackId = value;
    }

    /**
     * ��ȡbatteryGroupThreshold���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BatteryPackThreshold }{@code >}
     *     
     */
    public JAXBElement<BatteryPackThreshold> getBatteryGroupThreshold() {
        return batteryGroupThreshold;
    }

    /**
     * ����batteryGroupThreshold���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BatteryPackThreshold }{@code >}
     *     
     */
    public void setBatteryGroupThreshold(JAXBElement<BatteryPackThreshold> value) {
        this.batteryGroupThreshold = value;
    }

}
