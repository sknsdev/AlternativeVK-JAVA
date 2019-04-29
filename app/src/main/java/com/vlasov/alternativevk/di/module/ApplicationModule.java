package com.vlasov.alternativevk.di.module;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application){
        mApplication = application;
    }


    @Singleton //будет всего 1 экз
    @Provides //показывает, что объект нужен для внедрения зависимости, для будущего инжекта
    public Context provideContext(){
        return mApplication;
    }

}
