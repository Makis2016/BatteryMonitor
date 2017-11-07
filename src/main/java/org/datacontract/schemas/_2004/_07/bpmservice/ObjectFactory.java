
package org.datacontract.schemas._2004._07.bpmservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.ArrayOfBattery;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.bpmservice package. 
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

    private final static QName _DcdcData_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "DcdcData");
    private final static QName _BatteryPackInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "BatteryPackInfo");
    private final static QName _DataAccuracyInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "DataAccuracyInfo");
    private final static QName _CurentDucer_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "CurentDucer");
    private final static QName _BatteryPackInfoMBatteries_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "mBatteries");
    private final static QName _BatteryPackInfoBatteryResistanceLevelBaseLine1_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "BatteryResistanceLevelBaseLine1");
    private final static QName _BatteryPackInfoBatteryResistanceLevelBaseLine2_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "BatteryResistanceLevelBaseLine2");
    private final static QName _BatteryPackInfoEnvironmentTemperature_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "EnvironmentTemperature");
    private final static QName _BatteryPackInfoCurrent_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "Current");
    private final static QName _BatteryPackInfoBatteryVoltageLevelBaseLine2_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "BatteryVoltageLevelBaseLine2");
    private final static QName _BatteryPackInfoBatteryTeamperatureLevelBaseLine2_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "BatteryTeamperatureLevelBaseLine2");
    private final static QName _BatteryPackInfoBatteryVoltageLevelBaseLine1_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "BatteryVoltageLevelBaseLine1");
    private final static QName _BatteryPackInfoBatteryTeamperatureLevelBaseLine1_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "BatteryTeamperatureLevelBaseLine1");
    private final static QName _BatteryPackInfoVoltage_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "Voltage");
    private final static QName _BatteryPackInfoBatteries_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "Batteries");
    private final static QName _BatteryPackInfoName_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "Name");
    private final static QName _BatteryPackInfoWaterTemperature_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "WaterTemperature");
    private final static QName _DcdcDataCraftIndex_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "CraftIndex");
    private final static QName _DcdcDataTotalTimeSeconds_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "TotalTimeSeconds");
    private final static QName _DcdcDataStageTimeSeconds_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "StageTimeSeconds");
    private final static QName _DcdcDataTotalElectricity_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "TotalElectricity");
    private final static QName _DcdcDataCrafStep_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "CrafStep");
    private final static QName _DcdcDataCycleTimes_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "CycleTimes");
    private final static QName _DcdcDataStageElectricity_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMService.Model", "StageElectricity");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.bpmservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BatteryPackInfo }
     * 
     */
    public BatteryPackInfo createBatteryPackInfo() {
        return new BatteryPackInfo();
    }

    /**
     * Create an instance of {@link CurentDucer }
     * 
     */
    public CurentDucer createCurentDucer() {
        return new CurentDucer();
    }

    /**
     * Create an instance of {@link DcdcData }
     * 
     */
    public DcdcData createDcdcData() {
        return new DcdcData();
    }

    /**
     * Create an instance of {@link DataAccuracyInfo }
     * 
     */
    public DataAccuracyInfo createDataAccuracyInfo() {
        return new DataAccuracyInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DcdcData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "DcdcData")
    public JAXBElement<DcdcData> createDcdcData(DcdcData value) {
        return new JAXBElement<DcdcData>(_DcdcData_QNAME, DcdcData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPackInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "BatteryPackInfo")
    public JAXBElement<BatteryPackInfo> createBatteryPackInfo(BatteryPackInfo value) {
        return new JAXBElement<BatteryPackInfo>(_BatteryPackInfo_QNAME, BatteryPackInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataAccuracyInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "DataAccuracyInfo")
    public JAXBElement<DataAccuracyInfo> createDataAccuracyInfo(DataAccuracyInfo value) {
        return new JAXBElement<DataAccuracyInfo>(_DataAccuracyInfo_QNAME, DataAccuracyInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurentDucer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "CurentDucer")
    public JAXBElement<CurentDucer> createCurentDucer(CurentDucer value) {
        return new JAXBElement<CurentDucer>(_CurentDucer_QNAME, CurentDucer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "mBatteries", scope = BatteryPackInfo.class)
    public JAXBElement<ArrayOfBattery> createBatteryPackInfoMBatteries(ArrayOfBattery value) {
        return new JAXBElement<ArrayOfBattery>(_BatteryPackInfoMBatteries_QNAME, ArrayOfBattery.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "BatteryResistanceLevelBaseLine1", scope = BatteryPackInfo.class)
    public JAXBElement<Double> createBatteryPackInfoBatteryResistanceLevelBaseLine1(Double value) {
        return new JAXBElement<Double>(_BatteryPackInfoBatteryResistanceLevelBaseLine1_QNAME, Double.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "BatteryResistanceLevelBaseLine2", scope = BatteryPackInfo.class)
    public JAXBElement<Double> createBatteryPackInfoBatteryResistanceLevelBaseLine2(Double value) {
        return new JAXBElement<Double>(_BatteryPackInfoBatteryResistanceLevelBaseLine2_QNAME, Double.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "EnvironmentTemperature", scope = BatteryPackInfo.class)
    public JAXBElement<Double> createBatteryPackInfoEnvironmentTemperature(Double value) {
        return new JAXBElement<Double>(_BatteryPackInfoEnvironmentTemperature_QNAME, Double.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "Current", scope = BatteryPackInfo.class)
    public JAXBElement<Double> createBatteryPackInfoCurrent(Double value) {
        return new JAXBElement<Double>(_BatteryPackInfoCurrent_QNAME, Double.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "BatteryVoltageLevelBaseLine2", scope = BatteryPackInfo.class)
    public JAXBElement<Double> createBatteryPackInfoBatteryVoltageLevelBaseLine2(Double value) {
        return new JAXBElement<Double>(_BatteryPackInfoBatteryVoltageLevelBaseLine2_QNAME, Double.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "BatteryTeamperatureLevelBaseLine2", scope = BatteryPackInfo.class)
    public JAXBElement<Double> createBatteryPackInfoBatteryTeamperatureLevelBaseLine2(Double value) {
        return new JAXBElement<Double>(_BatteryPackInfoBatteryTeamperatureLevelBaseLine2_QNAME, Double.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "BatteryVoltageLevelBaseLine1", scope = BatteryPackInfo.class)
    public JAXBElement<Double> createBatteryPackInfoBatteryVoltageLevelBaseLine1(Double value) {
        return new JAXBElement<Double>(_BatteryPackInfoBatteryVoltageLevelBaseLine1_QNAME, Double.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "BatteryTeamperatureLevelBaseLine1", scope = BatteryPackInfo.class)
    public JAXBElement<Double> createBatteryPackInfoBatteryTeamperatureLevelBaseLine1(Double value) {
        return new JAXBElement<Double>(_BatteryPackInfoBatteryTeamperatureLevelBaseLine1_QNAME, Double.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "Voltage", scope = BatteryPackInfo.class)
    public JAXBElement<Double> createBatteryPackInfoVoltage(Double value) {
        return new JAXBElement<Double>(_BatteryPackInfoVoltage_QNAME, Double.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "Batteries", scope = BatteryPackInfo.class)
    public JAXBElement<ArrayOfBattery> createBatteryPackInfoBatteries(ArrayOfBattery value) {
        return new JAXBElement<ArrayOfBattery>(_BatteryPackInfoBatteries_QNAME, ArrayOfBattery.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "Name", scope = BatteryPackInfo.class)
    public JAXBElement<String> createBatteryPackInfoName(String value) {
        return new JAXBElement<String>(_BatteryPackInfoName_QNAME, String.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "WaterTemperature", scope = BatteryPackInfo.class)
    public JAXBElement<Double> createBatteryPackInfoWaterTemperature(Double value) {
        return new JAXBElement<Double>(_BatteryPackInfoWaterTemperature_QNAME, Double.class, BatteryPackInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "CraftIndex", scope = DcdcData.class)
    public JAXBElement<Short> createDcdcDataCraftIndex(Short value) {
        return new JAXBElement<Short>(_DcdcDataCraftIndex_QNAME, Short.class, DcdcData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "TotalTimeSeconds", scope = DcdcData.class)
    public JAXBElement<Long> createDcdcDataTotalTimeSeconds(Long value) {
        return new JAXBElement<Long>(_DcdcDataTotalTimeSeconds_QNAME, Long.class, DcdcData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "Current", scope = DcdcData.class)
    public JAXBElement<Double> createDcdcDataCurrent(Double value) {
        return new JAXBElement<Double>(_BatteryPackInfoCurrent_QNAME, Double.class, DcdcData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "StageTimeSeconds", scope = DcdcData.class)
    public JAXBElement<Long> createDcdcDataStageTimeSeconds(Long value) {
        return new JAXBElement<Long>(_DcdcDataStageTimeSeconds_QNAME, Long.class, DcdcData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "TotalElectricity", scope = DcdcData.class)
    public JAXBElement<Double> createDcdcDataTotalElectricity(Double value) {
        return new JAXBElement<Double>(_DcdcDataTotalElectricity_QNAME, Double.class, DcdcData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "CrafStep", scope = DcdcData.class)
    public JAXBElement<String> createDcdcDataCrafStep(String value) {
        return new JAXBElement<String>(_DcdcDataCrafStep_QNAME, String.class, DcdcData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "CycleTimes", scope = DcdcData.class)
    public JAXBElement<Short> createDcdcDataCycleTimes(Short value) {
        return new JAXBElement<Short>(_DcdcDataCycleTimes_QNAME, Short.class, DcdcData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "StageElectricity", scope = DcdcData.class)
    public JAXBElement<Double> createDcdcDataStageElectricity(Double value) {
        return new JAXBElement<Double>(_DcdcDataStageElectricity_QNAME, Double.class, DcdcData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMService.Model", name = "Voltage", scope = DcdcData.class)
    public JAXBElement<Double> createDcdcDataVoltage(Double value) {
        return new JAXBElement<Double>(_BatteryPackInfoVoltage_QNAME, Double.class, DcdcData.class, value);
    }

}
