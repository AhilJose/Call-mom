package google.com.callmom;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Sergey on 25.12.2016.
 */
public class CallMomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
