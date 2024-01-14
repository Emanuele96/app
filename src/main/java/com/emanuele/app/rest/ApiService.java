package com.emanuele.app.rest;

import com.emanuele.app.model.interfaces.EnergiDataServiceApi;
import com.emanuele.app.model.PowerSystemRightNowResponse;
import com.emanuele.app.model.PowerSystemTimepoint;
import com.emanuele.app.model.customSerialization.PowerSystemRightNowResponseDeserializer;
import com.emanuele.app.model.customSerialization.PowerSystemRightNowResponseSerializer;
import com.emanuele.app.model.customSerialization.PowerSystemTimepointDeserializer;
import com.google.gson.*;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;


@Service
public class ApiService {

    private EnergiDataServiceApi energiDataServiceApi;

    Gson getGson() {
        return new GsonBuilder().registerTypeAdapter(PowerSystemRightNowResponse.class, new PowerSystemRightNowResponseDeserializer())
                .registerTypeAdapter(PowerSystemRightNowResponse.class, new PowerSystemRightNowResponseSerializer())
                .registerTypeAdapter(PowerSystemTimepoint.class, new PowerSystemTimepointDeserializer())
                .create();

    }
    ApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.energidataservice.dk/")
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        energiDataServiceApi = retrofit.create(EnergiDataServiceApi.class);
    }

    public Observable<PowerSystemRightNowResponse> getPowerSystemStatus(int limit, int offset, String sort){
        return energiDataServiceApi.getPowerSystemRightNowStatus(limit, offset, sort);
    }
}
