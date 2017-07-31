
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Circuit.FormattingStatus的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="Circuit.FormattingStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Standby"/>
 *     &lt;enumeration value="Preparing"/>
 *     &lt;enumeration value="Formating"/>
 *     &lt;enumeration value="Jumping"/>
 *     &lt;enumeration value="Pausing"/>
 *     &lt;enumeration value="Paused"/>
 *     &lt;enumeration value="Resuming"/>
 *     &lt;enumeration value="Stopping"/>
 *     &lt;enumeration value="Reseting"/>
 *     &lt;enumeration value="Fault"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Circuit.FormattingStatus")
@XmlEnum
public enum CircuitFormattingStatus {

    @XmlEnumValue("Standby")
    STANDBY("Standby"),
    @XmlEnumValue("Preparing")
    PREPARING("Preparing"),
    @XmlEnumValue("Formating")
    FORMATING("Formating"),
    @XmlEnumValue("Jumping")
    JUMPING("Jumping"),
    @XmlEnumValue("Pausing")
    PAUSING("Pausing"),
    @XmlEnumValue("Paused")
    PAUSED("Paused"),
    @XmlEnumValue("Resuming")
    RESUMING("Resuming"),
    @XmlEnumValue("Stopping")
    STOPPING("Stopping"),
    @XmlEnumValue("Reseting")
    RESETING("Reseting"),
    @XmlEnumValue("Fault")
    FAULT("Fault");
    private final String value;

    CircuitFormattingStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CircuitFormattingStatus fromValue(String v) {
        for (CircuitFormattingStatus c: CircuitFormattingStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
