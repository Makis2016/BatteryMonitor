
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="LoadBatteryPackAlarmDllResult" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "loadBatteryPackAlarmDllResult"
})
@XmlRootElement(name = "LoadBatteryPackAlarmDllResponse")
public class LoadBatteryPackAlarmDllResponse {

    @XmlElement(name = "LoadBatteryPackAlarmDllResult")
    protected Boolean loadBatteryPackAlarmDllResult;

    /**
     * ��ȡloadBatteryPackAlarmDllResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLoadBatteryPackAlarmDllResult() {
        return loadBatteryPackAlarmDllResult;
    }

    /**
     * ����loadBatteryPackAlarmDllResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLoadBatteryPackAlarmDllResult(Boolean value) {
        this.loadBatteryPackAlarmDllResult = value;
    }

}
