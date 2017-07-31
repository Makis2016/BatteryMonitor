
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Battery.BatteryType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="Battery.BatteryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Lithium"/>
 *     &lt;enumeration value="Nicad"/>
 *     &lt;enumeration value="Leadacid"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Battery.BatteryType")
@XmlEnum
public enum BatteryBatteryType {

    @XmlEnumValue("Lithium")
    LITHIUM("Lithium"),
    @XmlEnumValue("Nicad")
    NICAD("Nicad"),
    @XmlEnumValue("Leadacid")
    LEADACID("Leadacid");
    private final String value;

    BatteryBatteryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BatteryBatteryType fromValue(String v) {
        for (BatteryBatteryType c: BatteryBatteryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
