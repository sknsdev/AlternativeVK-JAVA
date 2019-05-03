package com.vlasov.alternativevk.di.component;


import com.vlasov.alternativevk.ui.fragment.NewsFeedFragment;
import com.vlasov.alternativevk.di.module.ApplicationModule;
import com.vlasov.alternativevk.di.module.ManagerModule;
import com.vlasov.alternativevk.di.module.RestModule;
import com.vlasov.alternativevk.ui.activity.BaseActivity;
import com.vlasov.alternativevk.ui.activity.MainActivity;
import com.vlasov.alternativevk.ui.holder.NewsItemBodyHolder;
import com.vlasov.alternativevk.ui.holder.NewsItemFooterHolder;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    void inject(NewsFeedFragment fragment);


    void inject(NewsItemBodyHolder holder);
    void inject(NewsItemFooterHolder holder);
}
