
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryThreshold;


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
 *         &lt;element name="batteryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="batteryThreshold" type="{http://schemas.datacontract.org/2004/07/BPMDevices}BatteryThreshold" minOccurs="0"/>
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
    "batteryId",
    "batteryThreshold"
})
@XmlRootElement(name = "UpdateBatteryThreshold")
public class UpdateBatteryThreshold {

    protected Long batteryPackId;
    protected Long batteryId;
    @XmlElementRef(name = "batteryThreshold", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<BatteryThreshold> batteryThreshold;

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
     * ��ȡbatteryId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBatteryId() {
        return batteryId;
    }

    /**
     * ����batteryId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBatteryId(Long value) {
        this.batteryId = value;
    }

    /**
     * ��ȡbatteryThreshold���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BatteryThreshold }{@code >}
     *     
     */
    public JAXBElement<BatteryThreshold> getBatteryThreshold() {
        return batteryThreshold;
    }

    /**
     * ����batteryThreshold���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BatteryThreshold }{@code >}
     *     
     */
    public void setBatteryThreshold(JAXBElement<BatteryThreshold> value) {
        this.batteryThreshold = value;
    }

}
