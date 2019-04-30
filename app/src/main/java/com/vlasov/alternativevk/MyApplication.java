package com.vlasov.alternativevk;

import android.app.Application;

import com.vk.sdk.VKSdk;
import com.vlasov.alternativevk.di.component.ApplicationComponent;
import com.vlasov.alternativevk.di.component.DaggerApplicationComponent;
import com.vlasov.alternativevk.di.module.ApplicationModule;

//import com.vk.api.sdk.VK;
//import com.vk.api.sdk.auth.VKScope;


public class MyApplication extends Application {

    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        VKSdk.initialize(this);
    }

    private void initComponent(){
        sApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getsApplicationComponent(){
        return sApplicationComponent;
    }

}
