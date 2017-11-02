
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="circuit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="inputCurrent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="outputVoltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
    "circuit",
    "inputCurrent",
    "outputVoltage"
})
@XmlRootElement(name = "SetCurrentDucer")
public class SetCurrentDucer {

    protected Long circuit;
    protected Double inputCurrent;
    protected Double outputVoltage;

    /**
     * ��ȡcircuit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCircuit() {
        return circuit;
    }

    /**
     * ����circuit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCircuit(Long value) {
        this.circuit = value;
    }

    /**
     * ��ȡinputCurrent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInputCurrent() {
        return inputCurrent;
    }

    /**
     * ����inputCurrent���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInputCurrent(Double value) {
        this.inputCurrent = value;
    }

    /**
     * ��ȡoutputVoltage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOutputVoltage() {
        return outputVoltage;
    }

    /**
     * ����outputVoltage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOutputVoltage(Double value) {
        this.outputVoltage = value;
    }

}
