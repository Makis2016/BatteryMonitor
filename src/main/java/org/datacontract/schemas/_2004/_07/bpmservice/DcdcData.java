
package org.datacontract.schemas._2004._07.bpmservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DcdcData complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DcdcData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CrafStep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CraftId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CraftIndex" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="Current" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CycleTimes" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="StageElectricity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="StageTimeSeconds" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="TotalElectricity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="TotalTimeSeconds" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Voltage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DcdcData", propOrder = {
    "crafStep",
    "craftId",
    "craftIndex",
    "current",
    "cycleTimes",
    "id",
    "stageElectricity",
    "stageTimeSeconds",
    "totalElectricity",
    "totalTimeSeconds",
    "voltage"
})
public class DcdcData {

    @XmlElementRef(name = "CrafStep", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<String> crafStep;
    @XmlElement(name = "CraftId")
    protected Long craftId;
    @XmlElementRef(name = "CraftIndex", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Short> craftIndex;
    @XmlElementRef(name = "Current", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> current;
    @XmlElementRef(name = "CycleTimes", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Short> cycleTimes;
    @XmlElement(name = "Id")
    protected Long id;
    @XmlElementRef(name = "StageElectricity", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> stageElectricity;
    @XmlElementRef(name = "StageTimeSeconds", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> stageTimeSeconds;
    @XmlElementRef(name = "TotalElectricity", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> totalElectricity;
    @XmlElementRef(name = "TotalTimeSeconds", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> totalTimeSeconds;
    @XmlElementRef(name = "Voltage", namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Double> voltage;

    /**
     * ��ȡcrafStep���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCrafStep() {
        return crafStep;
    }

    /**
     * ����crafStep���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCrafStep(JAXBElement<String> value) {
        this.crafStep = value;
    }

    /**
     * ��ȡcraftId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCraftId() {
        return craftId;
    }

    /**
     * ����craftId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCraftId(Long value) {
        this.craftId = value;
    }

    /**
     * ��ȡcraftIndex���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public JAXBElement<Short> getCraftIndex() {
        return craftIndex;
    }

    /**
     * ����craftIndex���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public void setCraftIndex(JAXBElement<Short> value) {
        this.craftIndex = value;
    }

    /**
     * ��ȡcurrent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getCurrent() {
        return current;
    }

    /**
     * ����current���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setCurrent(JAXBElement<Double> value) {
        this.current = value;
    }

    /**
     * ��ȡcycleTimes���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public JAXBElement<Short> getCycleTimes() {
        return cycleTimes;
    }

    /**
     * ����cycleTimes���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public void setCycleTimes(JAXBElement<Short> value) {
        this.cycleTimes = value;
    }

    /**
     * ��ȡid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * ����id���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * ��ȡstageElectricity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getStageElectricity() {
        return stageElectricity;
    }

    /**
     * ����stageElectricity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setStageElectricity(JAXBElement<Double> value) {
        this.stageElectricity = value;
    }

    /**
     * ��ȡstageTimeSeconds���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getStageTimeSeconds() {
        return stageTimeSeconds;
    }

    /**
     * ����stageTimeSeconds���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setStageTimeSeconds(JAXBElement<Long> value) {
        this.stageTimeSeconds = value;
    }

    /**
     * ��ȡtotalElectricity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getTotalElectricity() {
        return totalElectricity;
    }

    /**
     * ����totalElectricity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setTotalElectricity(JAXBElement<Double> value) {
        this.totalElectricity = value;
    }

    /**
     * ��ȡtotalTimeSeconds���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getTotalTimeSeconds() {
        return totalTimeSeconds;
    }

    /**
     * ����totalTimeSeconds���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setTotalTimeSeconds(JAXBElement<Long> value) {
        this.totalTimeSeconds = value;
    }

    /**
     * ��ȡvoltage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getVoltage() {
        return voltage;
    }

    /**
     * ����voltage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setVoltage(JAXBElement<Double> value) {
        this.voltage = value;
    }

}
