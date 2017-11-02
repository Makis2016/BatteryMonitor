
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Alarm.AlarmLevel的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="Alarm.AlarmLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoAlarm"/>
 *     &lt;enumeration value="Level1"/>
 *     &lt;enumeration value="Level2"/>
 *     &lt;enumeration value="Level3"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Alarm.AlarmLevel")
@XmlEnum
public enum AlarmAlarmLevel {

    @XmlEnumValue("NoAlarm")
    NO_ALARM("NoAlarm"),
    @XmlEnumValue("Level1")
    LEVEL_1("Level1"),
    @XmlEnumValue("Level2")
    LEVEL_2("Level2"),
    @XmlEnumValue("Level3")
    LEVEL_3("Level3");
    private final String value;

    AlarmAlarmLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AlarmAlarmLevel fromValue(String v) {
        for (AlarmAlarmLevel c: AlarmAlarmLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
