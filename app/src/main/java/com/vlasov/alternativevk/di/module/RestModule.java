package com.vlasov.alternativevk.di.module;


import com.vlasov.alternativevk.rest.RestClient;
import com.vlasov.alternativevk.rest.api.WallApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RestModule {
    private RestClient mRestClient;

    public RestModule(){
        mRestClient = new RestClient();
    }

    @Singleton
    @Provides
    public RestClient provideRestClient(){
        return mRestClient;
    }
    @Singleton
    @Provides
    public WallApi provideWallApi(){
        return mRestClient.createService(WallApi.class);
    }
}
