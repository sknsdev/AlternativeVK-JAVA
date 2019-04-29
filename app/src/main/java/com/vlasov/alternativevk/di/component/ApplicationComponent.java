package com.vlasov.alternativevk.di.component;


import com.vlasov.alternativevk.di.module.ApplicationModule;
import com.vlasov.alternativevk.di.module.ManagerModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class})
public interface ApplicationComponent {
}
