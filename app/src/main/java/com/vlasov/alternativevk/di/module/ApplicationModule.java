package com.vlasov.alternativevk.di.module;


import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application){
        mApplication = application;
    }


    @Singleton //всего 1 экз
    @Provides // объект нужен для внедрения зависимости, для будущего инжекта
    public Context provideContext(){
        return mApplication;
    }
    @Singleton
    @Provides
    Typeface provideGoogleTypeFace(Context context){
        return Typeface.createFromAsset(context.getAssets(),"MaterialIcons-Regular.ttf");
    }

}
