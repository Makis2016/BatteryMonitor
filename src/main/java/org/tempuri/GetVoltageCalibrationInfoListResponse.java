
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfanyType;


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
 *         &lt;element name="GetVoltageCalibrationInfoListResult" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfanyType" minOccurs="0"/>
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
    "getVoltageCalibrationInfoListResult"
})
@XmlRootElement(name = "GetVoltageCalibrationInfoListResponse")
public class GetVoltageCalibrationInfoListResponse {

    @XmlElementRef(name = "GetVoltageCalibrationInfoListResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfanyType> getVoltageCalibrationInfoListResult;

    /**
     * ��ȡgetVoltageCalibrationInfoListResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfanyType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfanyType> getGetVoltageCalibrationInfoListResult() {
        return getVoltageCalibrationInfoListResult;
    }

    /**
     * ����getVoltageCalibrationInfoListResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfanyType }{@code >}
     *     
     */
    public void setGetVoltageCalibrationInfoListResult(JAXBElement<ArrayOfanyType> value) {
        this.getVoltageCalibrationInfoListResult = value;
    }

}
