package com.vlasov.alternativevk.di.module;


import com.vlasov.alternativevk.common.manager.MyFragmentManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagerModule {

    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager(){
        return new MyFragmentManager();
    }
}
