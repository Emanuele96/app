package com.emanuele.app.model.customSerialization;

import com.emanuele.app.model.PowerSystemRightNowResponse;
import com.google.gson.*;

import java.lang.reflect.Type;

public class PowerSystemTimepointDeserializer implements JsonDeserializer<PowerSystemRightNowResponse.PowerSystemTimepoint> {

    public PowerSystemRightNowResponse.PowerSystemTimepoint deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        PowerSystemRightNowResponse.PowerSystemTimepoint timepoint = new PowerSystemRightNowResponse.PowerSystemTimepoint();
        timepoint.setMinutes1UTC(jsonObject.get("Minutes1UTC").getAsString());
        timepoint.setMinutes1DK(jsonObject.get("Minutes1DK").getAsString());
        timepoint.setCo2Emission(getDoubleValue(jsonObject, "CO2Emission"));
        timepoint.setProductionGe100MW(getDoubleValue(jsonObject, "ProductionGe100MW"));
        timepoint.setProductionLt100MW(getDoubleValue(jsonObject, "ProductionLt100MW"));
        timepoint.setSolarPower(getDoubleValue(jsonObject, "SolarPower"));
        timepoint.setOffshoreWindPower(getDoubleValue(jsonObject, "OffshoreWindPower"));
        timepoint.setOnshoreWindPower(getDoubleValue(jsonObject, "OnshoreWindPower"));
        timepoint.setExchangeSum(getDoubleValue(jsonObject, "Exchange_Sum"));
        timepoint.setExchangeDK1DE(getDoubleValue(jsonObject, "Exchange_DK1_DE"));
        // Add similar lines for other properties

        return timepoint;
    }

    private static Double getDoubleValue(JsonObject jsonObject, String propertyName) {
        JsonElement element = jsonObject.get(propertyName);
        return (element != null && !element.isJsonNull()) ? element.getAsDouble() : null;
    }
}
