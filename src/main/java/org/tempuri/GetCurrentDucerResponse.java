
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bpmservice.CurentDucer;


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
 *         &lt;element name="GetCurrentDucerResult" type="{http://schemas.datacontract.org/2004/07/BPMService.Model}CurentDucer" minOccurs="0"/>
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
    "getCurrentDucerResult"
})
@XmlRootElement(name = "GetCurrentDucerResponse")
public class GetCurrentDucerResponse {

    @XmlElementRef(name = "GetCurrentDucerResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<CurentDucer> getCurrentDucerResult;

    /**
     * 获取getCurrentDucerResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CurentDucer }{@code >}
     *     
     */
    public JAXBElement<CurentDucer> getGetCurrentDucerResult() {
        return getCurrentDucerResult;
    }

    /**
     * 设置getCurrentDucerResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CurentDucer }{@code >}
     *     
     */
    public void setGetCurrentDucerResult(JAXBElement<CurentDucer> value) {
        this.getCurrentDucerResult = value;
    }

}
