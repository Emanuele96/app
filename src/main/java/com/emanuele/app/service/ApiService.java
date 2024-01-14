package com.emanuele.app.service;

import com.emanuele.app.api.EnergiDataServiceApi;
import com.emanuele.app.model.PowerSystemRightNowResponse;
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
                .registerTypeAdapter(PowerSystemRightNowResponse.PowerSystemTimepoint.class, new PowerSystemTimepointDeserializer())
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

    public Observable<PowerSystemRightNowResponse> getPowerSystemStatus(){
        return energiDataServiceApi.getPowerSystemRightNowStatus();
    }
}
