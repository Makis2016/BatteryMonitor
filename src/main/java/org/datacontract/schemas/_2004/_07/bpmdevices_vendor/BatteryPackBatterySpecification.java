
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BatteryPack.BatterySpecification�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="BatteryPack.BatterySpecification">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VoltageLevel2V"/>
 *     &lt;enumeration value="VoltageLevel12V"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BatteryPack.BatterySpecification")
@XmlEnum
public enum BatteryPackBatterySpecification {

    @XmlEnumValue("VoltageLevel2V")
    VOLTAGE_LEVEL_2_V("VoltageLevel2V"),
    @XmlEnumValue("VoltageLevel12V")
    VOLTAGE_LEVEL_12_V("VoltageLevel12V");
    private final String value;

    BatteryPackBatterySpecification(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BatteryPackBatterySpecification fromValue(String v) {
        for (BatteryPackBatterySpecification c: BatteryPackBatterySpecification.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
