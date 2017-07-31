
package org.datacontract.schemas._2004._07.bpmdevices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AlarmManager.AlarmLevel�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="AlarmManager.AlarmLevel">
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
@XmlType(name = "AlarmManager.AlarmLevel")
@XmlEnum
public enum AlarmManagerAlarmLevel {

    @XmlEnumValue("NoAlarm")
    NO_ALARM("NoAlarm"),
    @XmlEnumValue("Level1")
    LEVEL_1("Level1"),
    @XmlEnumValue("Level2")
    LEVEL_2("Level2"),
    @XmlEnumValue("Level3")
    LEVEL_3("Level3");
    private final String value;

    AlarmManagerAlarmLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AlarmManagerAlarmLevel fromValue(String v) {
        for (AlarmManagerAlarmLevel c: AlarmManagerAlarmLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
