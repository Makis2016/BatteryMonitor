
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BatteryPack.HotStates�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="BatteryPack.HotStates">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Security"/>
 *     &lt;enumeration value="Danger"/>
 *     &lt;enumeration value="HighRisk"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BatteryPack.HotStates")
@XmlEnum
public enum BatteryPackHotStates {

    @XmlEnumValue("Security")
    SECURITY("Security"),
    @XmlEnumValue("Danger")
    DANGER("Danger"),
    @XmlEnumValue("HighRisk")
    HIGH_RISK("HighRisk");
    private final String value;

    BatteryPackHotStates(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BatteryPackHotStates fromValue(String v) {
        for (BatteryPackHotStates c: BatteryPackHotStates.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
