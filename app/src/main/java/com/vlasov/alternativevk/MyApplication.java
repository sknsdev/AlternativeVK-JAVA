package com.vlasov.alternativevk;

import android.app.Application;

import com.vk.sdk.VKSdk;

//import com.vk.api.sdk.VK;
//import com.vk.api.sdk.auth.VKScope;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
