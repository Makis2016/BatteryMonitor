
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfBatteryPack complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBatteryPack">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BatteryPack" type="{http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common}BatteryPack" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBatteryPack", propOrder = {
    "batteryPack"
})
public class ArrayOfBatteryPack {

    @XmlElement(name = "BatteryPack", nillable = true)
    protected List<BatteryPack> batteryPack;

    /**
     * Gets the value of the batteryPack property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the batteryPack property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBatteryPack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BatteryPack }
     * 
     * 
     */
    public List<BatteryPack> getBatteryPack() {
        if (batteryPack == null) {
            batteryPack = new ArrayList<BatteryPack>();
        }
        return this.batteryPack;
    }

}
