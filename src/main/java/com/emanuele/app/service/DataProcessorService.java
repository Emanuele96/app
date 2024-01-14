package com.emanuele.app.service;

import com.emanuele.app.model.PowerSystemTimepoint;
import com.emanuele.app.service.utils.PowerSystemTimepointUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataProcessorService {

    @Autowired
    private DataProcessorArchiver dataProcessorArchiver;

    DataProcessorService(){}
    /**
     * Calculates the average of each property of a list of PowerSystemTimepoint
     * returning an unique datapoint with average values.
     * Timestamp of the latest datapoint is used.
     *
     * @param  values {@code List<PowerSystemTimepoint>} with the elements to include in the average
     * @return      {@code PowerSystemTimepoint} A datapoint with the average of all the properties
     */
    public PowerSystemTimepoint calculateAveragePowerSystemValues(List<PowerSystemTimepoint> values ){
        PowerSystemTimepoint timepoint = new PowerSystemTimepoint();
        timepoint.setTimestamp(values.getFirst().getTimestamp());
        timepoint.setCo2Emission(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values, "getCo2Emission"));
        timepoint.setProductionGe100MW(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values, "getProductionGe100MW"));
        timepoint.setProductionLt100MW(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values, "getProductionLt100MW"));
        timepoint.setSolarPower(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values,  "getSolarPower"));
        timepoint.setOffshoreWindPower(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values,  "getOffshoreWindPower"));
        timepoint.setOnshoreWindPower(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values, "getOnshoreWindPower"));
        timepoint.setExchangeSum(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values,  "getExchangeSum"));
        timepoint.setExchangeDK1DE(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values,  "getExchangeDK1DE"));
        timepoint.setExchangeDK1NL(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values,  "getExchangeDK1NL"));
        timepoint.setExchangeDK1GB(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values,  "getExchangeDK1GB"));
        timepoint.setExchangeDK1NO(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values,  "getExchangeDK1NO"));
        timepoint.setExchangeDK1SE(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values,  "getExchangeDK1SE"));
        timepoint.setExchangeDK1DK2(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values, "getExchangeDK1DK2"));
        timepoint.setExchangeDK2DE(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values, "getExchangeDK2DE"));
        timepoint.setExchangeDK2SE(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values,  "getExchangeDK2SE"));
        timepoint.setExchangeBornholmSE(PowerSystemTimepointUtils.calculateAverageOnPropertyName(values,  "getExchangeBornholmSE"));
        return timepoint;
    }

    public void saveDataPoint(PowerSystemTimepoint dataPoint){
        // Here I could do some validation on the entity, but I avoid to save time
        dataProcessorArchiver.persistEntity(dataPoint);
    }
}
