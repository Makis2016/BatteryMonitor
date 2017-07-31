
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Circuit.BatteryPackStatus的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="Circuit.BatteryPackStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoBatteryPack"/>
 *     &lt;enumeration value="Charge"/>
 *     &lt;enumeration value="Discharge"/>
 *     &lt;enumeration value="FloatCharge"/>
 *     &lt;enumeration value="Neither"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Circuit.BatteryPackStatus")
@XmlEnum
public enum CircuitBatteryPackStatus {

    @XmlEnumValue("NoBatteryPack")
    NO_BATTERY_PACK("NoBatteryPack"),
    @XmlEnumValue("Charge")
    CHARGE("Charge"),
    @XmlEnumValue("Discharge")
    DISCHARGE("Discharge"),
    @XmlEnumValue("FloatCharge")
    FLOAT_CHARGE("FloatCharge"),
    @XmlEnumValue("Neither")
    NEITHER("Neither");
    private final String value;

    CircuitBatteryPackStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CircuitBatteryPackStatus fromValue(String v) {
        for (CircuitBatteryPackStatus c: CircuitBatteryPackStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
