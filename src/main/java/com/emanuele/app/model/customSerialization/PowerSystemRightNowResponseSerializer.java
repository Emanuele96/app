package com.emanuele.app.model.customSerialization;

import com.emanuele.app.model.PowerSystemRightNowResponse;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class PowerSystemRightNowResponseSerializer implements JsonSerializer<PowerSystemRightNowResponse> {
    @Override
    public JsonElement serialize(PowerSystemRightNowResponse src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject obj = new JsonObject();
        return obj;
    }
}