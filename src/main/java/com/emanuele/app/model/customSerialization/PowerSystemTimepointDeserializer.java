package com.emanuele.app.model.customSerialization;

import com.emanuele.app.model.PowerSystemTimepoint;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.Instant;

public class PowerSystemTimepointDeserializer implements JsonDeserializer<PowerSystemTimepoint> {

    public PowerSystemTimepoint deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        PowerSystemTimepoint timepoint = new PowerSystemTimepoint();
        timepoint.setTimestamp(Instant.parse(jsonObject.get("Minutes1UTC").getAsString() + 'Z').getEpochSecond());
        timepoint.setCo2Emission(getDoubleValue(jsonObject, "CO2Emission"));
        timepoint.setProductionGe100MW(getDoubleValue(jsonObject, "ProductionGe100MW"));
        timepoint.setProductionLt100MW(getDoubleValue(jsonObject, "ProductionLt100MW"));
        timepoint.setSolarPower(getDoubleValue(jsonObject, "SolarPower"));
        timepoint.setOffshoreWindPower(getDoubleValue(jsonObject, "OffshoreWindPower"));
        timepoint.setOnshoreWindPower(getDoubleValue(jsonObject, "OnshoreWindPower"));
        timepoint.setExchangeSum(getDoubleValue(jsonObject, "Exchange_Sum"));
        timepoint.setExchangeDK1DE(getDoubleValue(jsonObject, "Exchange_DK1_DE"));
        timepoint.setExchangeDK1NL(getDoubleValue(jsonObject, "Exchange_DK1_NL"));
        timepoint.setExchangeDK1GB(getDoubleValue(jsonObject, "Exchange_DK1_GB"));
        timepoint.setExchangeDK1NO(getDoubleValue(jsonObject, "Exchange_DK1_NO"));
        timepoint.setExchangeDK1SE(getDoubleValue(jsonObject, "Exchange_DK1_SE"));
        timepoint.setExchangeDK1DK2(getDoubleValue(jsonObject, "Exchange_DK1_DK2"));
        timepoint.setExchangeDK2DE(getDoubleValue(jsonObject, "Exchange_DK2_DE"));
        timepoint.setExchangeDK2SE(getDoubleValue(jsonObject, "Exchange_DK2_SE"));
        timepoint.setExchangeBornholmSE(getDoubleValue(jsonObject, "Exchange_Bornholm_SE"));
        return timepoint;
    }

    private static Double getDoubleValue(JsonObject jsonObject, String propertyName) {
        JsonElement element = jsonObject.get(propertyName);
        return (element != null && !element.isJsonNull()) ? element.getAsDouble() : null;
    }
}
