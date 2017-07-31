
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetRealTimeAlarmCountResult" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "getRealTimeAlarmCountResult"
})
@XmlRootElement(name = "GetRealTimeAlarmCountResponse")
public class GetRealTimeAlarmCountResponse {

    @XmlElement(name = "GetRealTimeAlarmCountResult")
    protected Long getRealTimeAlarmCountResult;

    /**
     * 获取getRealTimeAlarmCountResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGetRealTimeAlarmCountResult() {
        return getRealTimeAlarmCountResult;
    }

    /**
     * 设置getRealTimeAlarmCountResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGetRealTimeAlarmCountResult(Long value) {
        this.getRealTimeAlarmCountResult = value;
    }

}
