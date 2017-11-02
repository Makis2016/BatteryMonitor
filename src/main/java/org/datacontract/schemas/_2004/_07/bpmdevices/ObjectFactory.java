
package org.datacontract.schemas._2004._07.bpmdevices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.bpmdevices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BatteryPackThreshold_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "BatteryPackThreshold");
    private final static QName _BatteryThreshold_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "BatteryThreshold");
    private final static QName _BatteryThresholdRippleVoltage_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "RippleVoltage");
    private final static QName _BatteryThresholdVoltageThresholdDown_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "VoltageThresholdDown");
    private final static QName _BatteryThresholdCreatTime_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "CreatTime");
    private final static QName _BatteryThresholdTemperature_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "Temperature");
    private final static QName _BatteryThresholdVoltageThresholdUp_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "VoltageThresholdUp");
    private final static QName _BatteryThresholdConfig_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "Config");
    private final static QName _BatteryThresholdResistanceLevel1_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "ResistanceLevel1");
    private final static QName _BatteryThresholdResistanceLevel2_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "ResistanceLevel2");
    private final static QName _BatteryPackThresholdGroupVoltageUp_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "GroupVoltageUp");
    private final static QName _BatteryPackThresholdEnvirTeaperature_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "EnvirTeaperature");
    private final static QName _BatteryPackThresholdGroupLeakageCurrent_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "GroupLeakageCurrent");
    private final static QName _BatteryPackThresholdGroupCurrentThreshold_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "GroupCurrentThreshold");
    private final static QName _BatteryPackThresholdGroupRippleCurrent_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "GroupRippleCurrent");
    private final static QName _BatteryPackThresholdGroupRippleVoltage_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "GroupRippleVoltage");
    private final static QName _BatteryPackThresholdGroupVoltageDown_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices", "GroupVoltageDown");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.bpmdevices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BatteryThreshold }
     * 
     */
    public BatteryThreshold createBatteryThreshold() {
        return new BatteryThreshold();
    }

    /**
     * Create an instance of {@link BatteryPackThreshold }
     * 
     */
    public BatteryPackThreshold createBatteryPackThreshold() {
        return new BatteryPackThreshold();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPackThreshold }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "BatteryPackThreshold")
    public JAXBElement<BatteryPackThreshold> createBatteryPackThreshold(BatteryPackThreshold value) {
        return new JAXBElement<BatteryPackThreshold>(_BatteryPackThreshold_QNAME, BatteryPackThreshold.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryThreshold }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "BatteryThreshold")
    public JAXBElement<BatteryThreshold> createBatteryThreshold(BatteryThreshold value) {
        return new JAXBElement<BatteryThreshold>(_BatteryThreshold_QNAME, BatteryThreshold.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "RippleVoltage", scope = BatteryThreshold.class)
    public JAXBElement<Double> createBatteryThresholdRippleVoltage(Double value) {
        return new JAXBElement<Double>(_BatteryThresholdRippleVoltage_QNAME, Double.class, BatteryThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "VoltageThresholdDown", scope = BatteryThreshold.class)
    public JAXBElement<Double> createBatteryThresholdVoltageThresholdDown(Double value) {
        return new JAXBElement<Double>(_BatteryThresholdVoltageThresholdDown_QNAME, Double.class, BatteryThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "CreatTime", scope = BatteryThreshold.class)
    public JAXBElement<XMLGregorianCalendar> createBatteryThresholdCreatTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_BatteryThresholdCreatTime_QNAME, XMLGregorianCalendar.class, BatteryThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "Temperature", scope = BatteryThreshold.class)
    public JAXBElement<Double> createBatteryThresholdTemperature(Double value) {
        return new JAXBElement<Double>(_BatteryThresholdTemperature_QNAME, Double.class, BatteryThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "VoltageThresholdUp", scope = BatteryThreshold.class)
    public JAXBElement<Double> createBatteryThresholdVoltageThresholdUp(Double value) {
        return new JAXBElement<Double>(_BatteryThresholdVoltageThresholdUp_QNAME, Double.class, BatteryThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "Config", scope = BatteryThreshold.class)
    public JAXBElement<String> createBatteryThresholdConfig(String value) {
        return new JAXBElement<String>(_BatteryThresholdConfig_QNAME, String.class, BatteryThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "ResistanceLevel1", scope = BatteryThreshold.class)
    public JAXBElement<Double> createBatteryThresholdResistanceLevel1(Double value) {
        return new JAXBElement<Double>(_BatteryThresholdResistanceLevel1_QNAME, Double.class, BatteryThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "ResistanceLevel2", scope = BatteryThreshold.class)
    public JAXBElement<Double> createBatteryThresholdResistanceLevel2(Double value) {
        return new JAXBElement<Double>(_BatteryThresholdResistanceLevel2_QNAME, Double.class, BatteryThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "GroupVoltageUp", scope = BatteryPackThreshold.class)
    public JAXBElement<Double> createBatteryPackThresholdGroupVoltageUp(Double value) {
        return new JAXBElement<Double>(_BatteryPackThresholdGroupVoltageUp_QNAME, Double.class, BatteryPackThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "EnvirTeaperature", scope = BatteryPackThreshold.class)
    public JAXBElement<Double> createBatteryPackThresholdEnvirTeaperature(Double value) {
        return new JAXBElement<Double>(_BatteryPackThresholdEnvirTeaperature_QNAME, Double.class, BatteryPackThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "GroupLeakageCurrent", scope = BatteryPackThreshold.class)
    public JAXBElement<Double> createBatteryPackThresholdGroupLeakageCurrent(Double value) {
        return new JAXBElement<Double>(_BatteryPackThresholdGroupLeakageCurrent_QNAME, Double.class, BatteryPackThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "GroupCurrentThreshold", scope = BatteryPackThreshold.class)
    public JAXBElement<Double> createBatteryPackThresholdGroupCurrentThreshold(Double value) {
        return new JAXBElement<Double>(_BatteryPackThresholdGroupCurrentThreshold_QNAME, Double.class, BatteryPackThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "GroupRippleCurrent", scope = BatteryPackThreshold.class)
    public JAXBElement<Double> createBatteryPackThresholdGroupRippleCurrent(Double value) {
        return new JAXBElement<Double>(_BatteryPackThresholdGroupRippleCurrent_QNAME, Double.class, BatteryPackThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "GroupRippleVoltage", scope = BatteryPackThreshold.class)
    public JAXBElement<Double> createBatteryPackThresholdGroupRippleVoltage(Double value) {
        return new JAXBElement<Double>(_BatteryPackThresholdGroupRippleVoltage_QNAME, Double.class, BatteryPackThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "GroupVoltageDown", scope = BatteryPackThreshold.class)
    public JAXBElement<Double> createBatteryPackThresholdGroupVoltageDown(Double value) {
        return new JAXBElement<Double>(_BatteryPackThresholdGroupVoltageDown_QNAME, Double.class, BatteryPackThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices", name = "Config", scope = BatteryPackThreshold.class)
    public JAXBElement<String> createBatteryPackThresholdConfig(String value) {
        return new JAXBElement<String>(_BatteryThresholdConfig_QNAME, String.class, BatteryPackThreshold.class, value);
    }

}
