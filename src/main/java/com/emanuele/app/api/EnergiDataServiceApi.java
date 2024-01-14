package com.emanuele.app.api;
import com.emanuele.app.model.PowerSystemRightNowResponse;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface EnergiDataServiceApi {
    @GET("dataset/PowerSystemRightNow")
    Observable<PowerSystemRightNowResponse> getPowerSystemRightNowStatus();

}
