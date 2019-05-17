package com.vlasov.alternativevk.rest.api;

import com.vlasov.alternativevk.rest.model.response.GetWallResponse;

import java.util.Map;
//import java.util.Observable;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WallApi {


    @GET(ApiMethods.WALL_GET)
    Observable<GetWallResponse> get(@QueryMap Map<String,String> map);
}
