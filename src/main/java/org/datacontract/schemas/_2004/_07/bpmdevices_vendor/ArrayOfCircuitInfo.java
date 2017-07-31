
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfCircuitInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCircuitInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CircuitInfo" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel}CircuitInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCircuitInfo", namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", propOrder = {
    "circuitInfo"
})
public class ArrayOfCircuitInfo {

    @XmlElement(name = "CircuitInfo", nillable = true)
    protected List<CircuitInfo> circuitInfo;

    /**
     * Gets the value of the circuitInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the circuitInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCircuitInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CircuitInfo }
     * 
     * 
     */
    public List<CircuitInfo> getCircuitInfo() {
        if (circuitInfo == null) {
            circuitInfo = new ArrayList<CircuitInfo>();
        }
        return this.circuitInfo;
    }

}
