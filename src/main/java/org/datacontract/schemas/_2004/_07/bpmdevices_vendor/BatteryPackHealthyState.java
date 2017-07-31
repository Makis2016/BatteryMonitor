
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BatteryPack.HealthyState的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="BatteryPack.HealthyState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoBattLifeAlarm"/>
 *     &lt;enumeration value="BattLifeAlarm1"/>
 *     &lt;enumeration value="BattLifeAlarm2"/>
 *     &lt;enumeration value="BattLifeAlarm3"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BatteryPack.HealthyState")
@XmlEnum
public enum BatteryPackHealthyState {

    @XmlEnumValue("NoBattLifeAlarm")
    NO_BATT_LIFE_ALARM("NoBattLifeAlarm"),
    @XmlEnumValue("BattLifeAlarm1")
    BATT_LIFE_ALARM_1("BattLifeAlarm1"),
    @XmlEnumValue("BattLifeAlarm2")
    BATT_LIFE_ALARM_2("BattLifeAlarm2"),
    @XmlEnumValue("BattLifeAlarm3")
    BATT_LIFE_ALARM_3("BattLifeAlarm3");
    private final String value;

    BatteryPackHealthyState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BatteryPackHealthyState fromValue(String v) {
        for (BatteryPackHealthyState c: BatteryPackHealthyState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
