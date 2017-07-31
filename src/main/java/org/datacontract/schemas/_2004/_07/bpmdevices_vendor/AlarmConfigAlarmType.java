
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AlarmConfig.AlarmType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="AlarmConfig.AlarmType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FloatVoltWarning"/>
 *     &lt;enumeration value="FloatVoltFault"/>
 *     &lt;enumeration value="BattVoltAbnormal"/>
 *     &lt;enumeration value="LoadLevelWarning"/>
 *     &lt;enumeration value="LoadLevelFault"/>
 *     &lt;enumeration value="ChargeLevelWarning"/>
 *     &lt;enumeration value="ChargeLevelFault"/>
 *     &lt;enumeration value="BattResistorWarning"/>
 *     &lt;enumeration value="BattResistorFault"/>
 *     &lt;enumeration value="BattTmpWarning"/>
 *     &lt;enumeration value="BattTmpFault"/>
 *     &lt;enumeration value="BattTmpBurst"/>
 *     &lt;enumeration value="SOCLevelWarning"/>
 *     &lt;enumeration value="SOCLevelFault"/>
 *     &lt;enumeration value="BattLifeAlarm1"/>
 *     &lt;enumeration value="BattLifeAlarm2"/>
 *     &lt;enumeration value="BattLifeAlarm3"/>
 *     &lt;enumeration value="DeviceAlarm"/>
 *     &lt;enumeration value="BCUCommunicationError"/>
 *     &lt;enumeration value="BCUCurrentError"/>
 *     &lt;enumeration value="BCUConfigError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AlarmConfig.AlarmType")
@XmlEnum
public enum AlarmConfigAlarmType {

    @XmlEnumValue("FloatVoltWarning")
    FLOAT_VOLT_WARNING("FloatVoltWarning"),
    @XmlEnumValue("FloatVoltFault")
    FLOAT_VOLT_FAULT("FloatVoltFault"),
    @XmlEnumValue("BattVoltAbnormal")
    BATT_VOLT_ABNORMAL("BattVoltAbnormal"),
    @XmlEnumValue("LoadLevelWarning")
    LOAD_LEVEL_WARNING("LoadLevelWarning"),
    @XmlEnumValue("LoadLevelFault")
    LOAD_LEVEL_FAULT("LoadLevelFault"),
    @XmlEnumValue("ChargeLevelWarning")
    CHARGE_LEVEL_WARNING("ChargeLevelWarning"),
    @XmlEnumValue("ChargeLevelFault")
    CHARGE_LEVEL_FAULT("ChargeLevelFault"),
    @XmlEnumValue("BattResistorWarning")
    BATT_RESISTOR_WARNING("BattResistorWarning"),
    @XmlEnumValue("BattResistorFault")
    BATT_RESISTOR_FAULT("BattResistorFault"),
    @XmlEnumValue("BattTmpWarning")
    BATT_TMP_WARNING("BattTmpWarning"),
    @XmlEnumValue("BattTmpFault")
    BATT_TMP_FAULT("BattTmpFault"),
    @XmlEnumValue("BattTmpBurst")
    BATT_TMP_BURST("BattTmpBurst"),
    @XmlEnumValue("SOCLevelWarning")
    SOC_LEVEL_WARNING("SOCLevelWarning"),
    @XmlEnumValue("SOCLevelFault")
    SOC_LEVEL_FAULT("SOCLevelFault"),
    @XmlEnumValue("BattLifeAlarm1")
    BATT_LIFE_ALARM_1("BattLifeAlarm1"),
    @XmlEnumValue("BattLifeAlarm2")
    BATT_LIFE_ALARM_2("BattLifeAlarm2"),
    @XmlEnumValue("BattLifeAlarm3")
    BATT_LIFE_ALARM_3("BattLifeAlarm3"),
    @XmlEnumValue("DeviceAlarm")
    DEVICE_ALARM("DeviceAlarm"),
    @XmlEnumValue("BCUCommunicationError")
    BCU_COMMUNICATION_ERROR("BCUCommunicationError"),
    @XmlEnumValue("BCUCurrentError")
    BCU_CURRENT_ERROR("BCUCurrentError"),
    @XmlEnumValue("BCUConfigError")
    BCU_CONFIG_ERROR("BCUConfigError");
    private final String value;

    AlarmConfigAlarmType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AlarmConfigAlarmType fromValue(String v) {
        for (AlarmConfigAlarmType c: AlarmConfigAlarmType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
