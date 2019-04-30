package com.vlasov.alternativevk.di.component;


import com.vlasov.alternativevk.di.module.ApplicationModule;
import com.vlasov.alternativevk.di.module.ManagerModule;
import com.vlasov.alternativevk.ui.activity.BaseActivity;
import com.vlasov.alternativevk.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity activity);
    void inject(MainActivity activity);

}
