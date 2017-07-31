
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Battery.BatteryState�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="Battery.BatteryState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Disabled"/>
 *     &lt;enumeration value="Enabled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Battery.BatteryState")
@XmlEnum
public enum BatteryBatteryState {

    @XmlEnumValue("Disabled")
    DISABLED("Disabled"),
    @XmlEnumValue("Enabled")
    ENABLED("Enabled");
    private final String value;

    BatteryBatteryState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BatteryBatteryState fromValue(String v) {
        for (BatteryBatteryState c: BatteryBatteryState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
