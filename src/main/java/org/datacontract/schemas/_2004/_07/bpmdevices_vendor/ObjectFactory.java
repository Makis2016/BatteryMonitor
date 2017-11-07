
package org.datacontract.schemas._2004._07.bpmdevices_vendor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryPackThreshold;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryThreshold;
import org.datacontract.schemas._2004._07.bpmservice.BatteryPackInfo;
import org.datacontract.schemas._2004._07.bpmservice.DataAccuracyInfo;
import org.datacontract.schemas._2004._07.bpmservice.DcdcData;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.bpmdevices_vendor package. 
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

    private final static QName _BatteryBatteryType_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Battery.BatteryType");
    private final static QName _Alarm_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Alarm");
    private final static QName _CircuitFormattingStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Circuit.FormattingStatus");
    private final static QName _ArrayOfBatteryPack_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "ArrayOfBatteryPack");
    private final static QName _ArrayOfAlarm_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "ArrayOfAlarm");
    private final static QName _BatteryPack_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryPack");
    private final static QName _AlarmAlarmType_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Alarm.AlarmType");
    private final static QName _BatteryPackHealthyState_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryPack.HealthyState");
    private final static QName _BatteryPackHotStates_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryPack.HotStates");
    private final static QName _ArrayOfCircuitInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", "ArrayOfCircuitInfo");
    private final static QName _CircuitInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", "CircuitInfo");
    private final static QName _Battery_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Battery");
    private final static QName _SfECU_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", "SfECU");
    private final static QName _BatteryBatteryState_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Battery.BatteryState");
    private final static QName _CircuitBatteryPackStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Circuit.BatteryPackStatus");
    private final static QName _SfBCU_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", "SfBCU");
    private final static QName _AlarmAlarmLevel_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Alarm.AlarmLevel");
    private final static QName _BatteryPackBatterySpecification_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryPack.BatterySpecification");
    private final static QName _ArrayOfBattery_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "ArrayOfBattery");
    private final static QName _SfBCUMac_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", "Mac");
    private final static QName _SfBCUReserve_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", "Reserve");
    private final static QName _CircuitInfoAreaName_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", "AreaName");
    private final static QName _CircuitInfoDCDCId_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", "DCDCId");
    private final static QName _CircuitInfoBatteryPackInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", "BatteryPackInfo");
    private final static QName _CircuitInfoACDCId_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", "ACDCId");
    private final static QName _CircuitInfoAreaIdPath_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", "AreaIdPath");
    private final static QName _CircuitInfoMonitorId_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", "MonitorId");
    private final static QName _CircuitInfoDataAccuracyInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", "DataAccuracyInfo");
    private final static QName _CircuitInfoDcdcInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", "DcdcInfo");
    private final static QName _CircuitInfoName_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", "Name");
    private final static QName _AlarmMAlarmMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "mAlarmMessage");
    private final static QName _AlarmMMaintainAdvise_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "mMaintainAdvise");
    private final static QName _AlarmMAreaName_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "mAreaName");
    private final static QName _BatteryPackBatteryTeamperatureLevelBaseLine1_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryTeamperatureLevelBaseLine1");
    private final static QName _BatteryPackBatteryTeamperatureLevelBaseLine2_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryTeamperatureLevelBaseLine2");
    private final static QName _BatteryPackBatteryVoltageLevelBaseLine1_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryVoltageLevelBaseLine1");
    private final static QName _BatteryPackBatteryVoltageLevelBaseLine2_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryVoltageLevelBaseLine2");
    private final static QName _BatteryPackCapacity_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Capacity");
    private final static QName _BatteryPackVoltage_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Voltage");
    private final static QName _BatteryPackBatteryResistanceLevelBaseLine2_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryResistanceLevelBaseLine2");
    private final static QName _BatteryPackEnvironmentTemperature_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "EnvironmentTemperature");
    private final static QName _BatteryPackBatteryResistanceLevelBaseLine1_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryResistanceLevelBaseLine1");
    private final static QName _BatteryPackCurrent_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Current");
    private final static QName _BatteryPackBatteryTemperature_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryTemperature");
    private final static QName _BatteryPackCharacter_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Character");
    private final static QName _BatteryPackBatteryGroupThreshold_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryGroupThreshold");
    private final static QName _BatteryPackWaterTemperature_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "WaterTemperature");
    private final static QName _BatteryPackBatteries_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Batteries");
    private final static QName _BatteryPackName_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Name");
    private final static QName _BatteryResistance_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Resistance");
    private final static QName _BatterySerialNum_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "SerialNum");
    private final static QName _BatteryDesignVoltage_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "DesignVoltage");
    private final static QName _BatteryInitCapacity_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "InitCapacity");
    private final static QName _BatteryBarcode_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Barcode");
    private final static QName _BatteryCapacityCheckPoInt32_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "CapacityCheckPoInt32");
    private final static QName _BatteryFloatChargeVolt_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "FloatChargeVolt");
    private final static QName _BatteryProducerName_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "ProducerName");
    private final static QName _BatteryResistanceBaseValue_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "ResistanceBaseValue");
    private final static QName _BatteryCellNum_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "CellNum");
    private final static QName _BatteryCircleLife_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "CircleLife");
    private final static QName _BatteryProductionDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "ProductionDate");
    private final static QName _BatteryVirtualAmp_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "VirtualAmp");
    private final static QName _BatterySchedulingCycle_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "SchedulingCycle");
    private final static QName _BatteryFirstTime_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "FirstTime");
    private final static QName _BatteryTemperature_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "Temperature");
    private final static QName _BatteryChargeRate_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "ChargeRate");
    private final static QName _BatteryChemicalComposition_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "ChemicalComposition");
    private final static QName _BatteryEqualChargeVolt_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "EqualChargeVolt");
    private final static QName _BatteryVirtualCapacity_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "VirtualCapacity");
    private final static QName _BatteryFloatChargeLife_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "FloatChargeLife");
    private final static QName _BatteryBatteryThreshold_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", "BatteryThreshold");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.bpmdevices_vendor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfAlarm }
     * 
     */
    public ArrayOfAlarm createArrayOfAlarm() {
        return new ArrayOfAlarm();
    }

    /**
     * Create an instance of {@link CircuitInfo }
     * 
     */
    public CircuitInfo createCircuitInfo() {
        return new CircuitInfo();
    }

    /**
     * Create an instance of {@link ArrayOfCircuitInfo }
     * 
     */
    public ArrayOfCircuitInfo createArrayOfCircuitInfo() {
        return new ArrayOfCircuitInfo();
    }

    /**
     * Create an instance of {@link ArrayOfBattery }
     * 
     */
    public ArrayOfBattery createArrayOfBattery() {
        return new ArrayOfBattery();
    }

    /**
     * Create an instance of {@link SfBCU }
     * 
     */
    public SfBCU createSfBCU() {
        return new SfBCU();
    }

    /**
     * Create an instance of {@link BatteryPack }
     * 
     */
    public BatteryPack createBatteryPack() {
        return new BatteryPack();
    }

    /**
     * Create an instance of {@link SfECU }
     * 
     */
    public SfECU createSfECU() {
        return new SfECU();
    }

    /**
     * Create an instance of {@link Battery }
     * 
     */
    public Battery createBattery() {
        return new Battery();
    }

    /**
     * Create an instance of {@link ArrayOfBatteryPack }
     * 
     */
    public ArrayOfBatteryPack createArrayOfBatteryPack() {
        return new ArrayOfBatteryPack();
    }

    /**
     * Create an instance of {@link Alarm }
     * 
     */
    public Alarm createAlarm() {
        return new Alarm();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryBatteryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Battery.BatteryType")
    public JAXBElement<BatteryBatteryType> createBatteryBatteryType(BatteryBatteryType value) {
        return new JAXBElement<BatteryBatteryType>(_BatteryBatteryType_QNAME, BatteryBatteryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Alarm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Alarm")
    public JAXBElement<Alarm> createAlarm(Alarm value) {
        return new JAXBElement<Alarm>(_Alarm_QNAME, Alarm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CircuitFormattingStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Circuit.FormattingStatus")
    public JAXBElement<CircuitFormattingStatus> createCircuitFormattingStatus(CircuitFormattingStatus value) {
        return new JAXBElement<CircuitFormattingStatus>(_CircuitFormattingStatus_QNAME, CircuitFormattingStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBatteryPack }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "ArrayOfBatteryPack")
    public JAXBElement<ArrayOfBatteryPack> createArrayOfBatteryPack(ArrayOfBatteryPack value) {
        return new JAXBElement<ArrayOfBatteryPack>(_ArrayOfBatteryPack_QNAME, ArrayOfBatteryPack.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAlarm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "ArrayOfAlarm")
    public JAXBElement<ArrayOfAlarm> createArrayOfAlarm(ArrayOfAlarm value) {
        return new JAXBElement<ArrayOfAlarm>(_ArrayOfAlarm_QNAME, ArrayOfAlarm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPack }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryPack")
    public JAXBElement<BatteryPack> createBatteryPack(BatteryPack value) {
        return new JAXBElement<BatteryPack>(_BatteryPack_QNAME, BatteryPack.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AlarmAlarmType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Alarm.AlarmType")
    public JAXBElement<AlarmAlarmType> createAlarmAlarmType(AlarmAlarmType value) {
        return new JAXBElement<AlarmAlarmType>(_AlarmAlarmType_QNAME, AlarmAlarmType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPackHealthyState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryPack.HealthyState")
    public JAXBElement<BatteryPackHealthyState> createBatteryPackHealthyState(BatteryPackHealthyState value) {
        return new JAXBElement<BatteryPackHealthyState>(_BatteryPackHealthyState_QNAME, BatteryPackHealthyState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPackHotStates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryPack.HotStates")
    public JAXBElement<BatteryPackHotStates> createBatteryPackHotStates(BatteryPackHotStates value) {
        return new JAXBElement<BatteryPackHotStates>(_BatteryPackHotStates_QNAME, BatteryPackHotStates.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCircuitInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", name = "ArrayOfCircuitInfo")
    public JAXBElement<ArrayOfCircuitInfo> createArrayOfCircuitInfo(ArrayOfCircuitInfo value) {
        return new JAXBElement<ArrayOfCircuitInfo>(_ArrayOfCircuitInfo_QNAME, ArrayOfCircuitInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CircuitInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", name = "CircuitInfo")
    public JAXBElement<CircuitInfo> createCircuitInfo(CircuitInfo value) {
        return new JAXBElement<CircuitInfo>(_CircuitInfo_QNAME, CircuitInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Battery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Battery")
    public JAXBElement<Battery> createBattery(Battery value) {
        return new JAXBElement<Battery>(_Battery_QNAME, Battery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SfECU }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", name = "SfECU")
    public JAXBElement<SfECU> createSfECU(SfECU value) {
        return new JAXBElement<SfECU>(_SfECU_QNAME, SfECU.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryBatteryState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Battery.BatteryState")
    public JAXBElement<BatteryBatteryState> createBatteryBatteryState(BatteryBatteryState value) {
        return new JAXBElement<BatteryBatteryState>(_BatteryBatteryState_QNAME, BatteryBatteryState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CircuitBatteryPackStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Circuit.BatteryPackStatus")
    public JAXBElement<CircuitBatteryPackStatus> createCircuitBatteryPackStatus(CircuitBatteryPackStatus value) {
        return new JAXBElement<CircuitBatteryPackStatus>(_CircuitBatteryPackStatus_QNAME, CircuitBatteryPackStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SfBCU }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", name = "SfBCU")
    public JAXBElement<SfBCU> createSfBCU(SfBCU value) {
        return new JAXBElement<SfBCU>(_SfBCU_QNAME, SfBCU.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AlarmAlarmLevel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Alarm.AlarmLevel")
    public JAXBElement<AlarmAlarmLevel> createAlarmAlarmLevel(AlarmAlarmLevel value) {
        return new JAXBElement<AlarmAlarmLevel>(_AlarmAlarmLevel_QNAME, AlarmAlarmLevel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPackBatterySpecification }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryPack.BatterySpecification")
    public JAXBElement<BatteryPackBatterySpecification> createBatteryPackBatterySpecification(BatteryPackBatterySpecification value) {
        return new JAXBElement<BatteryPackBatterySpecification>(_BatteryPackBatterySpecification_QNAME, BatteryPackBatterySpecification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "ArrayOfBattery")
    public JAXBElement<ArrayOfBattery> createArrayOfBattery(ArrayOfBattery value) {
        return new JAXBElement<ArrayOfBattery>(_ArrayOfBattery_QNAME, ArrayOfBattery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", name = "Mac", scope = SfBCU.class)
    public JAXBElement<byte[]> createSfBCUMac(byte[] value) {
        return new JAXBElement<byte[]>(_SfBCUMac_QNAME, byte[].class, SfBCU.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", name = "Reserve", scope = SfBCU.class)
    public JAXBElement<byte[]> createSfBCUReserve(byte[] value) {
        return new JAXBElement<byte[]>(_SfBCUReserve_QNAME, byte[].class, SfBCU.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", name = "AreaName", scope = CircuitInfo.class)
    public JAXBElement<String> createCircuitInfoAreaName(String value) {
        return new JAXBElement<String>(_CircuitInfoAreaName_QNAME, String.class, CircuitInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", name = "DCDCId", scope = CircuitInfo.class)
    public JAXBElement<Long> createCircuitInfoDCDCId(Long value) {
        return new JAXBElement<Long>(_CircuitInfoDCDCId_QNAME, Long.class, CircuitInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPackInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", name = "BatteryPackInfo", scope = CircuitInfo.class)
    public JAXBElement<BatteryPackInfo> createCircuitInfoBatteryPackInfo(BatteryPackInfo value) {
        return new JAXBElement<BatteryPackInfo>(_CircuitInfoBatteryPackInfo_QNAME, BatteryPackInfo.class, CircuitInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", name = "ACDCId", scope = CircuitInfo.class)
    public JAXBElement<Long> createCircuitInfoACDCId(Long value) {
        return new JAXBElement<Long>(_CircuitInfoACDCId_QNAME, Long.class, CircuitInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", name = "AreaIdPath", scope = CircuitInfo.class)
    public JAXBElement<String> createCircuitInfoAreaIdPath(String value) {
        return new JAXBElement<String>(_CircuitInfoAreaIdPath_QNAME, String.class, CircuitInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", name = "MonitorId", scope = CircuitInfo.class)
    public JAXBElement<Long> createCircuitInfoMonitorId(Long value) {
        return new JAXBElement<Long>(_CircuitInfoMonitorId_QNAME, Long.class, CircuitInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataAccuracyInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", name = "DataAccuracyInfo", scope = CircuitInfo.class)
    public JAXBElement<DataAccuracyInfo> createCircuitInfoDataAccuracyInfo(DataAccuracyInfo value) {
        return new JAXBElement<DataAccuracyInfo>(_CircuitInfoDataAccuracyInfo_QNAME, DataAccuracyInfo.class, CircuitInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DcdcData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", name = "DcdcInfo", scope = CircuitInfo.class)
    public JAXBElement<DcdcData> createCircuitInfoDcdcInfo(DcdcData value) {
        return new JAXBElement<DcdcData>(_CircuitInfoDcdcInfo_QNAME, DcdcData.class, CircuitInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel", name = "Name", scope = CircuitInfo.class)
    public JAXBElement<String> createCircuitInfoName(String value) {
        return new JAXBElement<String>(_CircuitInfoName_QNAME, String.class, CircuitInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "mAlarmMessage", scope = Alarm.class)
    public JAXBElement<String> createAlarmMAlarmMessage(String value) {
        return new JAXBElement<String>(_AlarmMAlarmMessage_QNAME, String.class, Alarm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "mMaintainAdvise", scope = Alarm.class)
    public JAXBElement<String> createAlarmMMaintainAdvise(String value) {
        return new JAXBElement<String>(_AlarmMMaintainAdvise_QNAME, String.class, Alarm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "mAreaName", scope = Alarm.class)
    public JAXBElement<String> createAlarmMAreaName(String value) {
        return new JAXBElement<String>(_AlarmMAreaName_QNAME, String.class, Alarm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", name = "Mac", scope = SfECU.class)
    public JAXBElement<byte[]> createSfECUMac(byte[] value) {
        return new JAXBElement<byte[]>(_SfBCUMac_QNAME, byte[].class, SfECU.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", name = "Reserve", scope = SfECU.class)
    public JAXBElement<byte[]> createSfECUReserve(byte[] value) {
        return new JAXBElement<byte[]>(_SfBCUReserve_QNAME, byte[].class, SfECU.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryTeamperatureLevelBaseLine1", scope = BatteryPack.class)
    public JAXBElement<Double> createBatteryPackBatteryTeamperatureLevelBaseLine1(Double value) {
        return new JAXBElement<Double>(_BatteryPackBatteryTeamperatureLevelBaseLine1_QNAME, Double.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryTeamperatureLevelBaseLine2", scope = BatteryPack.class)
    public JAXBElement<Double> createBatteryPackBatteryTeamperatureLevelBaseLine2(Double value) {
        return new JAXBElement<Double>(_BatteryPackBatteryTeamperatureLevelBaseLine2_QNAME, Double.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryVoltageLevelBaseLine1", scope = BatteryPack.class)
    public JAXBElement<Double> createBatteryPackBatteryVoltageLevelBaseLine1(Double value) {
        return new JAXBElement<Double>(_BatteryPackBatteryVoltageLevelBaseLine1_QNAME, Double.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryVoltageLevelBaseLine2", scope = BatteryPack.class)
    public JAXBElement<Double> createBatteryPackBatteryVoltageLevelBaseLine2(Double value) {
        return new JAXBElement<Double>(_BatteryPackBatteryVoltageLevelBaseLine2_QNAME, Double.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Capacity", scope = BatteryPack.class)
    public JAXBElement<Double> createBatteryPackCapacity(Double value) {
        return new JAXBElement<Double>(_BatteryPackCapacity_QNAME, Double.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Voltage", scope = BatteryPack.class)
    public JAXBElement<Double> createBatteryPackVoltage(Double value) {
        return new JAXBElement<Double>(_BatteryPackVoltage_QNAME, Double.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryResistanceLevelBaseLine2", scope = BatteryPack.class)
    public JAXBElement<Double> createBatteryPackBatteryResistanceLevelBaseLine2(Double value) {
        return new JAXBElement<Double>(_BatteryPackBatteryResistanceLevelBaseLine2_QNAME, Double.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "EnvironmentTemperature", scope = BatteryPack.class)
    public JAXBElement<Double> createBatteryPackEnvironmentTemperature(Double value) {
        return new JAXBElement<Double>(_BatteryPackEnvironmentTemperature_QNAME, Double.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryResistanceLevelBaseLine1", scope = BatteryPack.class)
    public JAXBElement<Double> createBatteryPackBatteryResistanceLevelBaseLine1(Double value) {
        return new JAXBElement<Double>(_BatteryPackBatteryResistanceLevelBaseLine1_QNAME, Double.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Current", scope = BatteryPack.class)
    public JAXBElement<Double> createBatteryPackCurrent(Double value) {
        return new JAXBElement<Double>(_BatteryPackCurrent_QNAME, Double.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryTemperature", scope = BatteryPack.class)
    public JAXBElement<Double> createBatteryPackBatteryTemperature(Double value) {
        return new JAXBElement<Double>(_BatteryPackBatteryTemperature_QNAME, Double.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Character", scope = BatteryPack.class)
    public JAXBElement<ArrayOfdouble> createBatteryPackCharacter(ArrayOfdouble value) {
        return new JAXBElement<ArrayOfdouble>(_BatteryPackCharacter_QNAME, ArrayOfdouble.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPackThreshold }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryGroupThreshold", scope = BatteryPack.class)
    public JAXBElement<BatteryPackThreshold> createBatteryPackBatteryGroupThreshold(BatteryPackThreshold value) {
        return new JAXBElement<BatteryPackThreshold>(_BatteryPackBatteryGroupThreshold_QNAME, BatteryPackThreshold.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "WaterTemperature", scope = BatteryPack.class)
    public JAXBElement<Double> createBatteryPackWaterTemperature(Double value) {
        return new JAXBElement<Double>(_BatteryPackWaterTemperature_QNAME, Double.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Batteries", scope = BatteryPack.class)
    public JAXBElement<ArrayOfBattery> createBatteryPackBatteries(ArrayOfBattery value) {
        return new JAXBElement<ArrayOfBattery>(_BatteryPackBatteries_QNAME, ArrayOfBattery.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Name", scope = BatteryPack.class)
    public JAXBElement<String> createBatteryPackName(String value) {
        return new JAXBElement<String>(_BatteryPackName_QNAME, String.class, BatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Resistance", scope = Battery.class)
    public JAXBElement<Double> createBatteryResistance(Double value) {
        return new JAXBElement<Double>(_BatteryResistance_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "SerialNum", scope = Battery.class)
    public JAXBElement<String> createBatterySerialNum(String value) {
        return new JAXBElement<String>(_BatterySerialNum_QNAME, String.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "DesignVoltage", scope = Battery.class)
    public JAXBElement<Double> createBatteryDesignVoltage(Double value) {
        return new JAXBElement<Double>(_BatteryDesignVoltage_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "InitCapacity", scope = Battery.class)
    public JAXBElement<Double> createBatteryInitCapacity(Double value) {
        return new JAXBElement<Double>(_BatteryInitCapacity_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Barcode", scope = Battery.class)
    public JAXBElement<String> createBatteryBarcode(String value) {
        return new JAXBElement<String>(_BatteryBarcode_QNAME, String.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Voltage", scope = Battery.class)
    public JAXBElement<Double> createBatteryVoltage(Double value) {
        return new JAXBElement<Double>(_BatteryPackVoltage_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "CapacityCheckPoInt32", scope = Battery.class)
    public JAXBElement<Double> createBatteryCapacityCheckPoInt32(Double value) {
        return new JAXBElement<Double>(_BatteryCapacityCheckPoInt32_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "FloatChargeVolt", scope = Battery.class)
    public JAXBElement<Double> createBatteryFloatChargeVolt(Double value) {
        return new JAXBElement<Double>(_BatteryFloatChargeVolt_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "ProducerName", scope = Battery.class)
    public JAXBElement<String> createBatteryProducerName(String value) {
        return new JAXBElement<String>(_BatteryProducerName_QNAME, String.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "ResistanceBaseValue", scope = Battery.class)
    public JAXBElement<Double> createBatteryResistanceBaseValue(Double value) {
        return new JAXBElement<Double>(_BatteryResistanceBaseValue_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "CellNum", scope = Battery.class)
    public JAXBElement<Integer> createBatteryCellNum(Integer value) {
        return new JAXBElement<Integer>(_BatteryCellNum_QNAME, Integer.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "CircleLife", scope = Battery.class)
    public JAXBElement<Double> createBatteryCircleLife(Double value) {
        return new JAXBElement<Double>(_BatteryCircleLife_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "ProductionDate", scope = Battery.class)
    public JAXBElement<XMLGregorianCalendar> createBatteryProductionDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_BatteryProductionDate_QNAME, XMLGregorianCalendar.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "VirtualAmp", scope = Battery.class)
    public JAXBElement<Double> createBatteryVirtualAmp(Double value) {
        return new JAXBElement<Double>(_BatteryVirtualAmp_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "SchedulingCycle", scope = Battery.class)
    public JAXBElement<Double> createBatterySchedulingCycle(Double value) {
        return new JAXBElement<Double>(_BatterySchedulingCycle_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "FirstTime", scope = Battery.class)
    public JAXBElement<XMLGregorianCalendar> createBatteryFirstTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_BatteryFirstTime_QNAME, XMLGregorianCalendar.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Temperature", scope = Battery.class)
    public JAXBElement<Double> createBatteryTemperature(Double value) {
        return new JAXBElement<Double>(_BatteryTemperature_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "ChargeRate", scope = Battery.class)
    public JAXBElement<Double> createBatteryChargeRate(Double value) {
        return new JAXBElement<Double>(_BatteryChargeRate_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "ChemicalComposition", scope = Battery.class)
    public JAXBElement<String> createBatteryChemicalComposition(String value) {
        return new JAXBElement<String>(_BatteryChemicalComposition_QNAME, String.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "EqualChargeVolt", scope = Battery.class)
    public JAXBElement<Double> createBatteryEqualChargeVolt(Double value) {
        return new JAXBElement<Double>(_BatteryEqualChargeVolt_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "VirtualCapacity", scope = Battery.class)
    public JAXBElement<Double> createBatteryVirtualCapacity(Double value) {
        return new JAXBElement<Double>(_BatteryVirtualCapacity_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "FloatChargeLife", scope = Battery.class)
    public JAXBElement<Double> createBatteryFloatChargeLife(Double value) {
        return new JAXBElement<Double>(_BatteryFloatChargeLife_QNAME, Double.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryThreshold }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "BatteryThreshold", scope = Battery.class)
    public JAXBElement<BatteryThreshold> createBatteryBatteryThreshold(BatteryThreshold value) {
        return new JAXBElement<BatteryThreshold>(_BatteryBatteryThreshold_QNAME, BatteryThreshold.class, Battery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common", name = "Name", scope = Battery.class)
    public JAXBElement<String> createBatteryName(String value) {
        return new JAXBElement<String>(_BatteryPackName_QNAME, String.class, Battery.class, value);
    }

}
