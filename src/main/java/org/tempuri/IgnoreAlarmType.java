
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.AlarmAlarmType;


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
 *         &lt;element name="alarmType" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}Alarm.AlarmType" minOccurs="0"/>
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
    "alarmType"
})
@XmlRootElement(name = "IgnoreAlarmType")
public class IgnoreAlarmType {

    @XmlSchemaType(name = "string")
    protected AlarmAlarmType alarmType;

    /**
     * ��ȡalarmType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AlarmAlarmType }
     *     
     */
    public AlarmAlarmType getAlarmType() {
        return alarmType;
    }

    /**
     * ����alarmType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmAlarmType }
     *     
     */
    public void setAlarmType(AlarmAlarmType value) {
        this.alarmType = value;
    }

}
