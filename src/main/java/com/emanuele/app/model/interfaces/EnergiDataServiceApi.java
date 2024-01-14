package com.emanuele.app.model.interfaces;
import com.emanuele.app.model.PowerSystemRightNowResponse;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface EnergiDataServiceApi {
    @GET("dataset/PowerSystemRightNow")
    Observable<PowerSystemRightNowResponse> getPowerSystemRightNowStatus(@Query("limit") int limit, @Query("offset") int offset, @Query("sort")String sort);

}
