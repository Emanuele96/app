package com.emanuele.app.model.customSerialization;

import com.emanuele.app.model.PowerSystemRightNowResponse;
import com.emanuele.app.model.PowerSystemTimepoint;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class PowerSystemRightNowResponseDeserializer implements JsonDeserializer<PowerSystemRightNowResponse> {

    @Override
    public PowerSystemRightNowResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();
        int total = obj.get("total").getAsInt();
        String dataset = obj.get("dataset").getAsString();

        Type timepointListType = new TypeToken<List<PowerSystemTimepoint>>() {}.getType();
        JsonArray recordsArray = obj.getAsJsonArray("records");
        List<PowerSystemTimepoint> records = context.deserialize(recordsArray, timepointListType);

        return PowerSystemRightNowResponse.builder()
                .total(total)
                .dataset(dataset)
                .records(records)
                .build();
    }

}


