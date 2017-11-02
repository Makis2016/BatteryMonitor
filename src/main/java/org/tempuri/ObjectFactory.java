
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfanyType;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryPackThreshold;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryThreshold;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.ArrayOfAlarm;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.ArrayOfBattery;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.ArrayOfBatteryPack;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.ArrayOfCircuitInfo;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.Battery;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.BatteryPack;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.CircuitInfo;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.SfBCU;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.SfECU;
import org.datacontract.schemas._2004._07.bpmservice.BatteryPackInfo;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _UpdateCircuitCircuitInfo_QNAME = new QName("http://tempuri.org/", "circuitInfo");
    private final static QName _GetBatteryAlarmCalcAssemblyObjectResponseGetBatteryAlarmCalcAssemblyObjectResult_QNAME = new QName("http://tempuri.org/", "GetBatteryAlarmCalcAssemblyObjectResult");
    private final static QName _GetRealTimeAlarmResponseGetRealTimeAlarmResult_QNAME = new QName("http://tempuri.org/", "GetRealTimeAlarmResult");
    private final static QName _SetSfECUConfigEcu_QNAME = new QName("http://tempuri.org/", "ecu");
    private final static QName _GetSfECUConfigDataResponseGetSfECUConfigDataResult_QNAME = new QName("http://tempuri.org/", "GetSfECUConfigDataResult");
    private final static QName _AddBatteryPackBatteryPack_QNAME = new QName("http://tempuri.org/", "batteryPack");
    private final static QName _GetCircuitInfoListResponseGetCircuitInfoListResult_QNAME = new QName("http://tempuri.org/", "GetCircuitInfoListResult");
    private final static QName _GetBatteryCalcAlarmDllVersionResponseGetBatteryCalcAlarmDllVersionResult_QNAME = new QName("http://tempuri.org/", "GetBatteryCalcAlarmDllVersionResult");
    private final static QName _GetBatteryPackByAreaResponseGetBatteryPackByAreaResult_QNAME = new QName("http://tempuri.org/", "GetBatteryPackByAreaResult");
    private final static QName _GetBatteryGroupThresholdResponseGetBatteryGroupThresholdResult_QNAME = new QName("http://tempuri.org/", "GetBatteryGroupThresholdResult");
    private final static QName _AddBatteryBattery_QNAME = new QName("http://tempuri.org/", "battery");
    private final static QName _GetCircuitListResponseGetCircuitListResult_QNAME = new QName("http://tempuri.org/", "GetCircuitListResult");
    private final static QName _GetBatteryThresholdResponseGetBatteryThresholdResult_QNAME = new QName("http://tempuri.org/", "GetBatteryThresholdResult");
    private final static QName _GetBatteriesResponseGetBatteriesResult_QNAME = new QName("http://tempuri.org/", "GetBatteriesResult");
    private final static QName _GetSfBCUConfigDataResponseGetSfBCUConfigDataResult_QNAME = new QName("http://tempuri.org/", "GetSfBCUConfigDataResult");
    private final static QName _GetCircuitResponseGetCircuitResult_QNAME = new QName("http://tempuri.org/", "GetCircuitResult");
    private final static QName _GetCircuitsResponseGetCircuitsResult_QNAME = new QName("http://tempuri.org/", "GetCircuitsResult");
    private final static QName _GetECUVersionResponseGetECUVersionResult_QNAME = new QName("http://tempuri.org/", "GetECUVersionResult");
    private final static QName _LoadBatteryAlarmDllBatteryAlarmDllByteBuff_QNAME = new QName("http://tempuri.org/", "batteryAlarmDllByteBuff");
    private final static QName _GetBatteryPackAlarmCalcAssemblyObjectResponseGetBatteryPackAlarmCalcAssemblyObjectResult_QNAME = new QName("http://tempuri.org/", "GetBatteryPackAlarmCalcAssemblyObjectResult");
    private final static QName _GetBatteryPackCalcAlarmDllVersionResponseGetBatteryPackCalcAlarmDllVersionResult_QNAME = new QName("http://tempuri.org/", "GetBatteryPackCalcAlarmDllVersionResult");
    private final static QName _GetVoltageCalibrationInfoListResponseGetVoltageCalibrationInfoListResult_QNAME = new QName("http://tempuri.org/", "GetVoltageCalibrationInfoListResult");
    private final static QName _UpdateBatteryThresholdBatteryThreshold_QNAME = new QName("http://tempuri.org/", "batteryThreshold");
    private final static QName _UpdateDeviceConfig_QNAME = new QName("http://tempuri.org/", "config");
    private final static QName _GetBatteryPackResponseGetBatteryPackResult_QNAME = new QName("http://tempuri.org/", "GetBatteryPackResult");
    private final static QName _LoadBatteryPackAlarmDllBatteryPackAlarmDllByteBuff_QNAME = new QName("http://tempuri.org/", "batteryPackAlarmDllByteBuff");
    private final static QName _AddDeviceName_QNAME = new QName("http://tempuri.org/", "name");
    private final static QName _AddDeviceType_QNAME = new QName("http://tempuri.org/", "type");
    private final static QName _UpdateBatteryGroupThresholdBatteryGroupThreshold_QNAME = new QName("http://tempuri.org/", "batteryGroupThreshold");
    private final static QName _SetSfBCUConfigBcu_QNAME = new QName("http://tempuri.org/", "bcu");
    private final static QName _GetCircuitInfosResponseGetCircuitInfosResult_QNAME = new QName("http://tempuri.org/", "GetCircuitInfosResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRealTimeAlarmCountResponse }
     * 
     */
    public GetRealTimeAlarmCountResponse createGetRealTimeAlarmCountResponse() {
        return new GetRealTimeAlarmCountResponse();
    }

    /**
     * Create an instance of {@link RecoveryBatteryResponse }
     * 
     */
    public RecoveryBatteryResponse createRecoveryBatteryResponse() {
        return new RecoveryBatteryResponse();
    }

    /**
     * Create an instance of {@link GetRealTimeAlarmResponse }
     * 
     */
    public GetRealTimeAlarmResponse createGetRealTimeAlarmResponse() {
        return new GetRealTimeAlarmResponse();
    }

    /**
     * Create an instance of {@link GetBatteryPack }
     * 
     */
    public GetBatteryPack createGetBatteryPack() {
        return new GetBatteryPack();
    }

    /**
     * Create an instance of {@link GetBatteryThresholdResponse }
     * 
     */
    public GetBatteryThresholdResponse createGetBatteryThresholdResponse() {
        return new GetBatteryThresholdResponse();
    }

    /**
     * Create an instance of {@link JumpToStage }
     * 
     */
    public JumpToStage createJumpToStage() {
        return new JumpToStage();
    }

    /**
     * Create an instance of {@link GetCircuitResponse }
     * 
     */
    public GetCircuitResponse createGetCircuitResponse() {
        return new GetCircuitResponse();
    }

    /**
     * Create an instance of {@link GetCircuitInfosResponse }
     * 
     */
    public GetCircuitInfosResponse createGetCircuitInfosResponse() {
        return new GetCircuitInfosResponse();
    }

    /**
     * Create an instance of {@link IgnoreAlarm }
     * 
     */
    public IgnoreAlarm createIgnoreAlarm() {
        return new IgnoreAlarm();
    }

    /**
     * Create an instance of {@link IgnoreAlarmTypeResponse }
     * 
     */
    public IgnoreAlarmTypeResponse createIgnoreAlarmTypeResponse() {
        return new IgnoreAlarmTypeResponse();
    }

    /**
     * Create an instance of {@link CalibrationVoltageResponse }
     * 
     */
    public CalibrationVoltageResponse createCalibrationVoltageResponse() {
        return new CalibrationVoltageResponse();
    }

    /**
     * Create an instance of {@link AddCircuit }
     * 
     */
    public AddCircuit createAddCircuit() {
        return new AddCircuit();
    }

    /**
     * Create an instance of {@link GetBatteries }
     * 
     */
    public GetBatteries createGetBatteries() {
        return new GetBatteries();
    }

    /**
     * Create an instance of {@link GetVoltageCalibrationInfoListResponse }
     * 
     */
    public GetVoltageCalibrationInfoListResponse createGetVoltageCalibrationInfoListResponse() {
        return new GetVoltageCalibrationInfoListResponse();
    }

    /**
     * Create an instance of {@link GetBatteryAlarmCalcAssemblyObjectResponse }
     * 
     */
    public GetBatteryAlarmCalcAssemblyObjectResponse createGetBatteryAlarmCalcAssemblyObjectResponse() {
        return new GetBatteryAlarmCalcAssemblyObjectResponse();
    }

    /**
     * Create an instance of {@link SetCircuitBatteryPack }
     * 
     */
    public SetCircuitBatteryPack createSetCircuitBatteryPack() {
        return new SetCircuitBatteryPack();
    }

    /**
     * Create an instance of {@link UpdateCraft }
     * 
     */
    public UpdateCraft createUpdateCraft() {
        return new UpdateCraft();
    }

    /**
     * Create an instance of {@link GetBatteryPackResponse }
     * 
     */
    public GetBatteryPackResponse createGetBatteryPackResponse() {
        return new GetBatteryPackResponse();
    }

    /**
     * Create an instance of {@link AddBatteryResponse }
     * 
     */
    public AddBatteryResponse createAddBatteryResponse() {
        return new AddBatteryResponse();
    }

    /**
     * Create an instance of {@link StopFormation }
     * 
     */
    public StopFormation createStopFormation() {
        return new StopFormation();
    }

    /**
     * Create an instance of {@link RemoveCircuitResponse }
     * 
     */
    public RemoveCircuitResponse createRemoveCircuitResponse() {
        return new RemoveCircuitResponse();
    }

    /**
     * Create an instance of {@link LoadBatteryAlarmDll }
     * 
     */
    public LoadBatteryAlarmDll createLoadBatteryAlarmDll() {
        return new LoadBatteryAlarmDll();
    }

    /**
     * Create an instance of {@link GetBatteriesResponse }
     * 
     */
    public GetBatteriesResponse createGetBatteriesResponse() {
        return new GetBatteriesResponse();
    }

    /**
     * Create an instance of {@link AddDevice }
     * 
     */
    public AddDevice createAddDevice() {
        return new AddDevice();
    }

    /**
     * Create an instance of {@link ResetDCDCResponse }
     * 
     */
    public ResetDCDCResponse createResetDCDCResponse() {
        return new ResetDCDCResponse();
    }

    /**
     * Create an instance of {@link StopFormationResponse }
     * 
     */
    public StopFormationResponse createStopFormationResponse() {
        return new StopFormationResponse();
    }

    /**
     * Create an instance of {@link UpdateBatteryThreshold }
     * 
     */
    public UpdateBatteryThreshold createUpdateBatteryThreshold() {
        return new UpdateBatteryThreshold();
    }

    /**
     * Create an instance of {@link SetSfBCUConfig }
     * 
     */
    public SetSfBCUConfig createSetSfBCUConfig() {
        return new SetSfBCUConfig();
    }

    /**
     * Create an instance of {@link CheckResistance }
     * 
     */
    public CheckResistance createCheckResistance() {
        return new CheckResistance();
    }

    /**
     * Create an instance of {@link SetCurrentDucerResponse }
     * 
     */
    public SetCurrentDucerResponse createSetCurrentDucerResponse() {
        return new SetCurrentDucerResponse();
    }

    /**
     * Create an instance of {@link RemoveCircuit }
     * 
     */
    public RemoveCircuit createRemoveCircuit() {
        return new RemoveCircuit();
    }

    /**
     * Create an instance of {@link LoadBatteryPackAlarmDll }
     * 
     */
    public LoadBatteryPackAlarmDll createLoadBatteryPackAlarmDll() {
        return new LoadBatteryPackAlarmDll();
    }

    /**
     * Create an instance of {@link JumpToNextStageResponse }
     * 
     */
    public JumpToNextStageResponse createJumpToNextStageResponse() {
        return new JumpToNextStageResponse();
    }

    /**
     * Create an instance of {@link RemoveBatteryPackResponse }
     * 
     */
    public RemoveBatteryPackResponse createRemoveBatteryPackResponse() {
        return new RemoveBatteryPackResponse();
    }

    /**
     * Create an instance of {@link GetBatteryPackAlarmCalcAssemblyObjectResponse }
     * 
     */
    public GetBatteryPackAlarmCalcAssemblyObjectResponse createGetBatteryPackAlarmCalcAssemblyObjectResponse() {
        return new GetBatteryPackAlarmCalcAssemblyObjectResponse();
    }

    /**
     * Create an instance of {@link GetCircuitList }
     * 
     */
    public GetCircuitList createGetCircuitList() {
        return new GetCircuitList();
    }

    /**
     * Create an instance of {@link GetBatteryPackAlarmCalcAssemblyObject }
     * 
     */
    public GetBatteryPackAlarmCalcAssemblyObject createGetBatteryPackAlarmCalcAssemblyObject() {
        return new GetBatteryPackAlarmCalcAssemblyObject();
    }

    /**
     * Create an instance of {@link PauseFormation }
     * 
     */
    public PauseFormation createPauseFormation() {
        return new PauseFormation();
    }

    /**
     * Create an instance of {@link SetCircuitBatteryPackResponse }
     * 
     */
    public SetCircuitBatteryPackResponse createSetCircuitBatteryPackResponse() {
        return new SetCircuitBatteryPackResponse();
    }

    /**
     * Create an instance of {@link ResumeFormationResponse }
     * 
     */
    public ResumeFormationResponse createResumeFormationResponse() {
        return new ResumeFormationResponse();
    }

    /**
     * Create an instance of {@link GetCircuitInfoList }
     * 
     */
    public GetCircuitInfoList createGetCircuitInfoList() {
        return new GetCircuitInfoList();
    }

    /**
     * Create an instance of {@link GetSfBCUConfig }
     * 
     */
    public GetSfBCUConfig createGetSfBCUConfig() {
        return new GetSfBCUConfig();
    }

    /**
     * Create an instance of {@link LoadBatteryPackAlarmDllResponse }
     * 
     */
    public LoadBatteryPackAlarmDllResponse createLoadBatteryPackAlarmDllResponse() {
        return new LoadBatteryPackAlarmDllResponse();
    }

    /**
     * Create an instance of {@link UpdateBatteryPackResponse }
     * 
     */
    public UpdateBatteryPackResponse createUpdateBatteryPackResponse() {
        return new UpdateBatteryPackResponse();
    }

    /**
     * Create an instance of {@link DisableBattery }
     * 
     */
    public DisableBattery createDisableBattery() {
        return new DisableBattery();
    }

    /**
     * Create an instance of {@link GetVoltageCalibrationInfoList }
     * 
     */
    public GetVoltageCalibrationInfoList createGetVoltageCalibrationInfoList() {
        return new GetVoltageCalibrationInfoList();
    }

    /**
     * Create an instance of {@link GetBatteryAlarmCalcAssemblyObject }
     * 
     */
    public GetBatteryAlarmCalcAssemblyObject createGetBatteryAlarmCalcAssemblyObject() {
        return new GetBatteryAlarmCalcAssemblyObject();
    }

    /**
     * Create an instance of {@link GetRealTimeAlarmCount }
     * 
     */
    public GetRealTimeAlarmCount createGetRealTimeAlarmCount() {
        return new GetRealTimeAlarmCount();
    }

    /**
     * Create an instance of {@link GetBatteryPackCalcAlarmDllVersionResponse }
     * 
     */
    public GetBatteryPackCalcAlarmDllVersionResponse createGetBatteryPackCalcAlarmDllVersionResponse() {
        return new GetBatteryPackCalcAlarmDllVersionResponse();
    }

    /**
     * Create an instance of {@link SetCurrentDucer }
     * 
     */
    public SetCurrentDucer createSetCurrentDucer() {
        return new SetCurrentDucer();
    }

    /**
     * Create an instance of {@link AddBatteryPack }
     * 
     */
    public AddBatteryPack createAddBatteryPack() {
        return new AddBatteryPack();
    }

    /**
     * Create an instance of {@link DisableBatteryResponse }
     * 
     */
    public DisableBatteryResponse createDisableBatteryResponse() {
        return new DisableBatteryResponse();
    }

    /**
     * Create an instance of {@link IgnoreAlarmType }
     * 
     */
    public IgnoreAlarmType createIgnoreAlarmType() {
        return new IgnoreAlarmType();
    }

    /**
     * Create an instance of {@link CalibrationTime }
     * 
     */
    public CalibrationTime createCalibrationTime() {
        return new CalibrationTime();
    }

    /**
     * Create an instance of {@link GetBatteryThreshold }
     * 
     */
    public GetBatteryThreshold createGetBatteryThreshold() {
        return new GetBatteryThreshold();
    }

    /**
     * Create an instance of {@link UpdateBatteryPack }
     * 
     */
    public UpdateBatteryPack createUpdateBatteryPack() {
        return new UpdateBatteryPack();
    }

    /**
     * Create an instance of {@link GetSfECUConfigDataResponse }
     * 
     */
    public GetSfECUConfigDataResponse createGetSfECUConfigDataResponse() {
        return new GetSfECUConfigDataResponse();
    }

    /**
     * Create an instance of {@link GetSfBCUConfigData }
     * 
     */
    public GetSfBCUConfigData createGetSfBCUConfigData() {
        return new GetSfBCUConfigData();
    }

    /**
     * Create an instance of {@link GetSfECUConfigData }
     * 
     */
    public GetSfECUConfigData createGetSfECUConfigData() {
        return new GetSfECUConfigData();
    }

    /**
     * Create an instance of {@link CalibrationCurrentResponse }
     * 
     */
    public CalibrationCurrentResponse createCalibrationCurrentResponse() {
        return new CalibrationCurrentResponse();
    }

    /**
     * Create an instance of {@link CalibrationCurrent }
     * 
     */
    public CalibrationCurrent createCalibrationCurrent() {
        return new CalibrationCurrent();
    }

    /**
     * Create an instance of {@link CircuitAddDevice }
     * 
     */
    public CircuitAddDevice createCircuitAddDevice() {
        return new CircuitAddDevice();
    }

    /**
     * Create an instance of {@link StartFormationResponse }
     * 
     */
    public StartFormationResponse createStartFormationResponse() {
        return new StartFormationResponse();
    }

    /**
     * Create an instance of {@link ResumeFormation }
     * 
     */
    public ResumeFormation createResumeFormation() {
        return new ResumeFormation();
    }

    /**
     * Create an instance of {@link AddCircuitResponse }
     * 
     */
    public AddCircuitResponse createAddCircuitResponse() {
        return new AddCircuitResponse();
    }

    /**
     * Create an instance of {@link CalibrationTimeResponse }
     * 
     */
    public CalibrationTimeResponse createCalibrationTimeResponse() {
        return new CalibrationTimeResponse();
    }

    /**
     * Create an instance of {@link UpdateSfBCUConfig }
     * 
     */
    public UpdateSfBCUConfig createUpdateSfBCUConfig() {
        return new UpdateSfBCUConfig();
    }

    /**
     * Create an instance of {@link RemoveCircuitBatteryPack }
     * 
     */
    public RemoveCircuitBatteryPack createRemoveCircuitBatteryPack() {
        return new RemoveCircuitBatteryPack();
    }

    /**
     * Create an instance of {@link RemoveBatteryPack }
     * 
     */
    public RemoveBatteryPack createRemoveBatteryPack() {
        return new RemoveBatteryPack();
    }

    /**
     * Create an instance of {@link GetCircuitListResponse }
     * 
     */
    public GetCircuitListResponse createGetCircuitListResponse() {
        return new GetCircuitListResponse();
    }

    /**
     * Create an instance of {@link AddDeviceResponse }
     * 
     */
    public AddDeviceResponse createAddDeviceResponse() {
        return new AddDeviceResponse();
    }

    /**
     * Create an instance of {@link UpdateDeviceResponse }
     * 
     */
    public UpdateDeviceResponse createUpdateDeviceResponse() {
        return new UpdateDeviceResponse();
    }

    /**
     * Create an instance of {@link JumpToStageResponse }
     * 
     */
    public JumpToStageResponse createJumpToStageResponse() {
        return new JumpToStageResponse();
    }

    /**
     * Create an instance of {@link RemoveCircuitBatteryPackResponse }
     * 
     */
    public RemoveCircuitBatteryPackResponse createRemoveCircuitBatteryPackResponse() {
        return new RemoveCircuitBatteryPackResponse();
    }

    /**
     * Create an instance of {@link GetBatteryGroupThresholdResponse }
     * 
     */
    public GetBatteryGroupThresholdResponse createGetBatteryGroupThresholdResponse() {
        return new GetBatteryGroupThresholdResponse();
    }

    /**
     * Create an instance of {@link CalibrationVoltage }
     * 
     */
    public CalibrationVoltage createCalibrationVoltage() {
        return new CalibrationVoltage();
    }

    /**
     * Create an instance of {@link GetSfBCUConfigResponse }
     * 
     */
    public GetSfBCUConfigResponse createGetSfBCUConfigResponse() {
        return new GetSfBCUConfigResponse();
    }

    /**
     * Create an instance of {@link CircuitAddDeviceResponse }
     * 
     */
    public CircuitAddDeviceResponse createCircuitAddDeviceResponse() {
        return new CircuitAddDeviceResponse();
    }

    /**
     * Create an instance of {@link GetCircuitsResponse }
     * 
     */
    public GetCircuitsResponse createGetCircuitsResponse() {
        return new GetCircuitsResponse();
    }

    /**
     * Create an instance of {@link RemoveDevice }
     * 
     */
    public RemoveDevice createRemoveDevice() {
        return new RemoveDevice();
    }

    /**
     * Create an instance of {@link RemoveDeviceResponse }
     * 
     */
    public RemoveDeviceResponse createRemoveDeviceResponse() {
        return new RemoveDeviceResponse();
    }

    /**
     * Create an instance of {@link GetCircuitsCountResponse }
     * 
     */
    public GetCircuitsCountResponse createGetCircuitsCountResponse() {
        return new GetCircuitsCountResponse();
    }

    /**
     * Create an instance of {@link GetCircuit }
     * 
     */
    public GetCircuit createGetCircuit() {
        return new GetCircuit();
    }

    /**
     * Create an instance of {@link AddBattery }
     * 
     */
    public AddBattery createAddBattery() {
        return new AddBattery();
    }

    /**
     * Create an instance of {@link SetSfBCUConfigResponse }
     * 
     */
    public SetSfBCUConfigResponse createSetSfBCUConfigResponse() {
        return new SetSfBCUConfigResponse();
    }

    /**
     * Create an instance of {@link GetBatteryPackByAreaResponse }
     * 
     */
    public GetBatteryPackByAreaResponse createGetBatteryPackByAreaResponse() {
        return new GetBatteryPackByAreaResponse();
    }

    /**
     * Create an instance of {@link GetECUVersion }
     * 
     */
    public GetECUVersion createGetECUVersion() {
        return new GetECUVersion();
    }

    /**
     * Create an instance of {@link SetSfECUConfigResponse }
     * 
     */
    public SetSfECUConfigResponse createSetSfECUConfigResponse() {
        return new SetSfECUConfigResponse();
    }

    /**
     * Create an instance of {@link GetCircuitInfoListResponse }
     * 
     */
    public GetCircuitInfoListResponse createGetCircuitInfoListResponse() {
        return new GetCircuitInfoListResponse();
    }

    /**
     * Create an instance of {@link StartFormation }
     * 
     */
    public StartFormation createStartFormation() {
        return new StartFormation();
    }

    /**
     * Create an instance of {@link GetBatteryGroupThreshold }
     * 
     */
    public GetBatteryGroupThreshold createGetBatteryGroupThreshold() {
        return new GetBatteryGroupThreshold();
    }

    /**
     * Create an instance of {@link UpdateCircuitResponse }
     * 
     */
    public UpdateCircuitResponse createUpdateCircuitResponse() {
        return new UpdateCircuitResponse();
    }

    /**
     * Create an instance of {@link PauseFormationResponse }
     * 
     */
    public PauseFormationResponse createPauseFormationResponse() {
        return new PauseFormationResponse();
    }

    /**
     * Create an instance of {@link GetCircuitInfos }
     * 
     */
    public GetCircuitInfos createGetCircuitInfos() {
        return new GetCircuitInfos();
    }

    /**
     * Create an instance of {@link GetSfBCUConfigDataResponse }
     * 
     */
    public GetSfBCUConfigDataResponse createGetSfBCUConfigDataResponse() {
        return new GetSfBCUConfigDataResponse();
    }

    /**
     * Create an instance of {@link UpdateDevice }
     * 
     */
    public UpdateDevice createUpdateDevice() {
        return new UpdateDevice();
    }

    /**
     * Create an instance of {@link UpdateCraftResponse }
     * 
     */
    public UpdateCraftResponse createUpdateCraftResponse() {
        return new UpdateCraftResponse();
    }

    /**
     * Create an instance of {@link GetBatteryPackCalcAlarmDllVersion }
     * 
     */
    public GetBatteryPackCalcAlarmDllVersion createGetBatteryPackCalcAlarmDllVersion() {
        return new GetBatteryPackCalcAlarmDllVersion();
    }

    /**
     * Create an instance of {@link GetECUVersionResponse }
     * 
     */
    public GetECUVersionResponse createGetECUVersionResponse() {
        return new GetECUVersionResponse();
    }

    /**
     * Create an instance of {@link RemoveCircuitDeviceResponse }
     * 
     */
    public RemoveCircuitDeviceResponse createRemoveCircuitDeviceResponse() {
        return new RemoveCircuitDeviceResponse();
    }

    /**
     * Create an instance of {@link AddBatteryPackResponse }
     * 
     */
    public AddBatteryPackResponse createAddBatteryPackResponse() {
        return new AddBatteryPackResponse();
    }

    /**
     * Create an instance of {@link RecoveryBattery }
     * 
     */
    public RecoveryBattery createRecoveryBattery() {
        return new RecoveryBattery();
    }

    /**
     * Create an instance of {@link RemoveCircuitDevice }
     * 
     */
    public RemoveCircuitDevice createRemoveCircuitDevice() {
        return new RemoveCircuitDevice();
    }

    /**
     * Create an instance of {@link GetBatteryCalcAlarmDllVersion }
     * 
     */
    public GetBatteryCalcAlarmDllVersion createGetBatteryCalcAlarmDllVersion() {
        return new GetBatteryCalcAlarmDllVersion();
    }

    /**
     * Create an instance of {@link GetRealTimeAlarm }
     * 
     */
    public GetRealTimeAlarm createGetRealTimeAlarm() {
        return new GetRealTimeAlarm();
    }

    /**
     * Create an instance of {@link GetBatteryCalcAlarmDllVersionResponse }
     * 
     */
    public GetBatteryCalcAlarmDllVersionResponse createGetBatteryCalcAlarmDllVersionResponse() {
        return new GetBatteryCalcAlarmDllVersionResponse();
    }

    /**
     * Create an instance of {@link UpdateCircuit }
     * 
     */
    public UpdateCircuit createUpdateCircuit() {
        return new UpdateCircuit();
    }

    /**
     * Create an instance of {@link IgnoreAlarmResponse }
     * 
     */
    public IgnoreAlarmResponse createIgnoreAlarmResponse() {
        return new IgnoreAlarmResponse();
    }

    /**
     * Create an instance of {@link RemoveBatteryResponse }
     * 
     */
    public RemoveBatteryResponse createRemoveBatteryResponse() {
        return new RemoveBatteryResponse();
    }

    /**
     * Create an instance of {@link JumpToNextStage }
     * 
     */
    public JumpToNextStage createJumpToNextStage() {
        return new JumpToNextStage();
    }

    /**
     * Create an instance of {@link ResetDCDC }
     * 
     */
    public ResetDCDC createResetDCDC() {
        return new ResetDCDC();
    }

    /**
     * Create an instance of {@link CheckResistanceResponse }
     * 
     */
    public CheckResistanceResponse createCheckResistanceResponse() {
        return new CheckResistanceResponse();
    }

    /**
     * Create an instance of {@link LoadBatteryAlarmDllResponse }
     * 
     */
    public LoadBatteryAlarmDllResponse createLoadBatteryAlarmDllResponse() {
        return new LoadBatteryAlarmDllResponse();
    }

    /**
     * Create an instance of {@link UpdateBatteryGroupThresholdResponse }
     * 
     */
    public UpdateBatteryGroupThresholdResponse createUpdateBatteryGroupThresholdResponse() {
        return new UpdateBatteryGroupThresholdResponse();
    }

    /**
     * Create an instance of {@link RemoveBattery }
     * 
     */
    public RemoveBattery createRemoveBattery() {
        return new RemoveBattery();
    }

    /**
     * Create an instance of {@link UpdateBatteryThresholdResponse }
     * 
     */
    public UpdateBatteryThresholdResponse createUpdateBatteryThresholdResponse() {
        return new UpdateBatteryThresholdResponse();
    }

    /**
     * Create an instance of {@link GetCircuitsCount }
     * 
     */
    public GetCircuitsCount createGetCircuitsCount() {
        return new GetCircuitsCount();
    }

    /**
     * Create an instance of {@link GetCircuits }
     * 
     */
    public GetCircuits createGetCircuits() {
        return new GetCircuits();
    }

    /**
     * Create an instance of {@link GetBatteryPackByArea }
     * 
     */
    public GetBatteryPackByArea createGetBatteryPackByArea() {
        return new GetBatteryPackByArea();
    }

    /**
     * Create an instance of {@link UpdateBatteryGroupThreshold }
     * 
     */
    public UpdateBatteryGroupThreshold createUpdateBatteryGroupThreshold() {
        return new UpdateBatteryGroupThreshold();
    }

    /**
     * Create an instance of {@link SetSfECUConfig }
     * 
     */
    public SetSfECUConfig createSetSfECUConfig() {
        return new SetSfECUConfig();
    }

    /**
     * Create an instance of {@link UpdateSfBCUConfigResponse }
     * 
     */
    public UpdateSfBCUConfigResponse createUpdateSfBCUConfigResponse() {
        return new UpdateSfBCUConfigResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CircuitInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "circuitInfo", scope = UpdateCircuit.class)
    public JAXBElement<CircuitInfo> createUpdateCircuitCircuitInfo(CircuitInfo value) {
        return new JAXBElement<CircuitInfo>(_UpdateCircuitCircuitInfo_QNAME, CircuitInfo.class, UpdateCircuit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBatteryAlarmCalcAssemblyObjectResult", scope = GetBatteryAlarmCalcAssemblyObjectResponse.class)
    public JAXBElement<String> createGetBatteryAlarmCalcAssemblyObjectResponseGetBatteryAlarmCalcAssemblyObjectResult(String value) {
        return new JAXBElement<String>(_GetBatteryAlarmCalcAssemblyObjectResponseGetBatteryAlarmCalcAssemblyObjectResult_QNAME, String.class, GetBatteryAlarmCalcAssemblyObjectResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CircuitInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "circuitInfo", scope = AddCircuit.class)
    public JAXBElement<CircuitInfo> createAddCircuitCircuitInfo(CircuitInfo value) {
        return new JAXBElement<CircuitInfo>(_UpdateCircuitCircuitInfo_QNAME, CircuitInfo.class, AddCircuit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAlarm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetRealTimeAlarmResult", scope = GetRealTimeAlarmResponse.class)
    public JAXBElement<ArrayOfAlarm> createGetRealTimeAlarmResponseGetRealTimeAlarmResult(ArrayOfAlarm value) {
        return new JAXBElement<ArrayOfAlarm>(_GetRealTimeAlarmResponseGetRealTimeAlarmResult_QNAME, ArrayOfAlarm.class, GetRealTimeAlarmResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SfECU }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ecu", scope = SetSfECUConfig.class)
    public JAXBElement<SfECU> createSetSfECUConfigEcu(SfECU value) {
        return new JAXBElement<SfECU>(_SetSfECUConfigEcu_QNAME, SfECU.class, SetSfECUConfig.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SfECU }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSfECUConfigDataResult", scope = GetSfECUConfigDataResponse.class)
    public JAXBElement<SfECU> createGetSfECUConfigDataResponseGetSfECUConfigDataResult(SfECU value) {
        return new JAXBElement<SfECU>(_GetSfECUConfigDataResponseGetSfECUConfigDataResult_QNAME, SfECU.class, GetSfECUConfigDataResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPack }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "batteryPack", scope = AddBatteryPack.class)
    public JAXBElement<BatteryPack> createAddBatteryPackBatteryPack(BatteryPack value) {
        return new JAXBElement<BatteryPack>(_AddBatteryPackBatteryPack_QNAME, BatteryPack.class, AddBatteryPack.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCircuitInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCircuitInfoListResult", scope = GetCircuitInfoListResponse.class)
    public JAXBElement<ArrayOfCircuitInfo> createGetCircuitInfoListResponseGetCircuitInfoListResult(ArrayOfCircuitInfo value) {
        return new JAXBElement<ArrayOfCircuitInfo>(_GetCircuitInfoListResponseGetCircuitInfoListResult_QNAME, ArrayOfCircuitInfo.class, GetCircuitInfoListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBatteryCalcAlarmDllVersionResult", scope = GetBatteryCalcAlarmDllVersionResponse.class)
    public JAXBElement<String> createGetBatteryCalcAlarmDllVersionResponseGetBatteryCalcAlarmDllVersionResult(String value) {
        return new JAXBElement<String>(_GetBatteryCalcAlarmDllVersionResponseGetBatteryCalcAlarmDllVersionResult_QNAME, String.class, GetBatteryCalcAlarmDllVersionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBatteryPack }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBatteryPackByAreaResult", scope = GetBatteryPackByAreaResponse.class)
    public JAXBElement<ArrayOfBatteryPack> createGetBatteryPackByAreaResponseGetBatteryPackByAreaResult(ArrayOfBatteryPack value) {
        return new JAXBElement<ArrayOfBatteryPack>(_GetBatteryPackByAreaResponseGetBatteryPackByAreaResult_QNAME, ArrayOfBatteryPack.class, GetBatteryPackByAreaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPackThreshold }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBatteryGroupThresholdResult", scope = GetBatteryGroupThresholdResponse.class)
    public JAXBElement<BatteryPackThreshold> createGetBatteryGroupThresholdResponseGetBatteryGroupThresholdResult(BatteryPackThreshold value) {
        return new JAXBElement<BatteryPackThreshold>(_GetBatteryGroupThresholdResponseGetBatteryGroupThresholdResult_QNAME, BatteryPackThreshold.class, GetBatteryGroupThresholdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Battery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "battery", scope = AddBattery.class)
    public JAXBElement<Battery> createAddBatteryBattery(Battery value) {
        return new JAXBElement<Battery>(_AddBatteryBattery_QNAME, Battery.class, AddBattery.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCircuitInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCircuitListResult", scope = GetCircuitListResponse.class)
    public JAXBElement<ArrayOfCircuitInfo> createGetCircuitListResponseGetCircuitListResult(ArrayOfCircuitInfo value) {
        return new JAXBElement<ArrayOfCircuitInfo>(_GetCircuitListResponseGetCircuitListResult_QNAME, ArrayOfCircuitInfo.class, GetCircuitListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryThreshold }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBatteryThresholdResult", scope = GetBatteryThresholdResponse.class)
    public JAXBElement<BatteryThreshold> createGetBatteryThresholdResponseGetBatteryThresholdResult(BatteryThreshold value) {
        return new JAXBElement<BatteryThreshold>(_GetBatteryThresholdResponseGetBatteryThresholdResult_QNAME, BatteryThreshold.class, GetBatteryThresholdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBattery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBatteriesResult", scope = GetBatteriesResponse.class)
    public JAXBElement<ArrayOfBattery> createGetBatteriesResponseGetBatteriesResult(ArrayOfBattery value) {
        return new JAXBElement<ArrayOfBattery>(_GetBatteriesResponseGetBatteriesResult_QNAME, ArrayOfBattery.class, GetBatteriesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SfBCU }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSfBCUConfigDataResult", scope = GetSfBCUConfigDataResponse.class)
    public JAXBElement<SfBCU> createGetSfBCUConfigDataResponseGetSfBCUConfigDataResult(SfBCU value) {
        return new JAXBElement<SfBCU>(_GetSfBCUConfigDataResponseGetSfBCUConfigDataResult_QNAME, SfBCU.class, GetSfBCUConfigDataResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CircuitInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCircuitResult", scope = GetCircuitResponse.class)
    public JAXBElement<CircuitInfo> createGetCircuitResponseGetCircuitResult(CircuitInfo value) {
        return new JAXBElement<CircuitInfo>(_GetCircuitResponseGetCircuitResult_QNAME, CircuitInfo.class, GetCircuitResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCircuitInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCircuitsResult", scope = GetCircuitsResponse.class)
    public JAXBElement<ArrayOfCircuitInfo> createGetCircuitsResponseGetCircuitsResult(ArrayOfCircuitInfo value) {
        return new JAXBElement<ArrayOfCircuitInfo>(_GetCircuitsResponseGetCircuitsResult_QNAME, ArrayOfCircuitInfo.class, GetCircuitsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetECUVersionResult", scope = GetECUVersionResponse.class)
    public JAXBElement<String> createGetECUVersionResponseGetECUVersionResult(String value) {
        return new JAXBElement<String>(_GetECUVersionResponseGetECUVersionResult_QNAME, String.class, GetECUVersionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "batteryAlarmDllByteBuff", scope = LoadBatteryAlarmDll.class)
    public JAXBElement<byte[]> createLoadBatteryAlarmDllBatteryAlarmDllByteBuff(byte[] value) {
        return new JAXBElement<byte[]>(_LoadBatteryAlarmDllBatteryAlarmDllByteBuff_QNAME, byte[].class, LoadBatteryAlarmDll.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBatteryPackAlarmCalcAssemblyObjectResult", scope = GetBatteryPackAlarmCalcAssemblyObjectResponse.class)
    public JAXBElement<String> createGetBatteryPackAlarmCalcAssemblyObjectResponseGetBatteryPackAlarmCalcAssemblyObjectResult(String value) {
        return new JAXBElement<String>(_GetBatteryPackAlarmCalcAssemblyObjectResponseGetBatteryPackAlarmCalcAssemblyObjectResult_QNAME, String.class, GetBatteryPackAlarmCalcAssemblyObjectResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBatteryPackCalcAlarmDllVersionResult", scope = GetBatteryPackCalcAlarmDllVersionResponse.class)
    public JAXBElement<String> createGetBatteryPackCalcAlarmDllVersionResponseGetBatteryPackCalcAlarmDllVersionResult(String value) {
        return new JAXBElement<String>(_GetBatteryPackCalcAlarmDllVersionResponseGetBatteryPackCalcAlarmDllVersionResult_QNAME, String.class, GetBatteryPackCalcAlarmDllVersionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfanyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetVoltageCalibrationInfoListResult", scope = GetVoltageCalibrationInfoListResponse.class)
    public JAXBElement<ArrayOfanyType> createGetVoltageCalibrationInfoListResponseGetVoltageCalibrationInfoListResult(ArrayOfanyType value) {
        return new JAXBElement<ArrayOfanyType>(_GetVoltageCalibrationInfoListResponseGetVoltageCalibrationInfoListResult_QNAME, ArrayOfanyType.class, GetVoltageCalibrationInfoListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryThreshold }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "batteryThreshold", scope = UpdateBatteryThreshold.class)
    public JAXBElement<BatteryThreshold> createUpdateBatteryThresholdBatteryThreshold(BatteryThreshold value) {
        return new JAXBElement<BatteryThreshold>(_UpdateBatteryThresholdBatteryThreshold_QNAME, BatteryThreshold.class, UpdateBatteryThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "config", scope = UpdateDevice.class)
    public JAXBElement<String> createUpdateDeviceConfig(String value) {
        return new JAXBElement<String>(_UpdateDeviceConfig_QNAME, String.class, UpdateDevice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPackInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBatteryPackResult", scope = GetBatteryPackResponse.class)
    public JAXBElement<BatteryPackInfo> createGetBatteryPackResponseGetBatteryPackResult(BatteryPackInfo value) {
        return new JAXBElement<BatteryPackInfo>(_GetBatteryPackResponseGetBatteryPackResult_QNAME, BatteryPackInfo.class, GetBatteryPackResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "batteryPackAlarmDllByteBuff", scope = LoadBatteryPackAlarmDll.class)
    public JAXBElement<byte[]> createLoadBatteryPackAlarmDllBatteryPackAlarmDllByteBuff(byte[] value) {
        return new JAXBElement<byte[]>(_LoadBatteryPackAlarmDllBatteryPackAlarmDllByteBuff_QNAME, byte[].class, LoadBatteryPackAlarmDll.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "name", scope = AddDevice.class)
    public JAXBElement<String> createAddDeviceName(String value) {
        return new JAXBElement<String>(_AddDeviceName_QNAME, String.class, AddDevice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "config", scope = AddDevice.class)
    public JAXBElement<String> createAddDeviceConfig(String value) {
        return new JAXBElement<String>(_UpdateDeviceConfig_QNAME, String.class, AddDevice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "type", scope = AddDevice.class)
    public JAXBElement<String> createAddDeviceType(String value) {
        return new JAXBElement<String>(_AddDeviceType_QNAME, String.class, AddDevice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPackThreshold }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "batteryGroupThreshold", scope = UpdateBatteryGroupThreshold.class)
    public JAXBElement<BatteryPackThreshold> createUpdateBatteryGroupThresholdBatteryGroupThreshold(BatteryPackThreshold value) {
        return new JAXBElement<BatteryPackThreshold>(_UpdateBatteryGroupThresholdBatteryGroupThreshold_QNAME, BatteryPackThreshold.class, UpdateBatteryGroupThreshold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SfBCU }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "bcu", scope = SetSfBCUConfig.class)
    public JAXBElement<SfBCU> createSetSfBCUConfigBcu(SfBCU value) {
        return new JAXBElement<SfBCU>(_SetSfBCUConfigBcu_QNAME, SfBCU.class, SetSfBCUConfig.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCircuitInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCircuitInfosResult", scope = GetCircuitInfosResponse.class)
    public JAXBElement<ArrayOfCircuitInfo> createGetCircuitInfosResponseGetCircuitInfosResult(ArrayOfCircuitInfo value) {
        return new JAXBElement<ArrayOfCircuitInfo>(_GetCircuitInfosResponseGetCircuitInfosResult_QNAME, ArrayOfCircuitInfo.class, GetCircuitInfosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SfBCU }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "bcu", scope = UpdateSfBCUConfig.class)
    public JAXBElement<SfBCU> createUpdateSfBCUConfigBcu(SfBCU value) {
        return new JAXBElement<SfBCU>(_SetSfBCUConfigBcu_QNAME, SfBCU.class, UpdateSfBCUConfig.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatteryPack }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "batteryPack", scope = UpdateBatteryPack.class)
    public JAXBElement<BatteryPack> createUpdateBatteryPackBatteryPack(BatteryPack value) {
        return new JAXBElement<BatteryPack>(_AddBatteryPackBatteryPack_QNAME, BatteryPack.class, UpdateBatteryPack.class, value);
    }

}
