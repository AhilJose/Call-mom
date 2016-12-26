package google.com.callmom.utils;

import android.util.Log;

import io.realm.Realm;

/**
 * Created by Sergey on 26.12.2016.
 */

public class DataHelper {

    private static final String TAG = DataHelper.class.getSimpleName();

    public static void startChangeOperation(Action<Realm> listener){
        Realm r = Realm.getDefaultInstance();
        try {
            r.beginTransaction();
            listener.call(r);
            r.commitTransaction();
        } catch (Exception ex) {
            Log.e(TAG, "onResponse: ", ex);
            ex.printStackTrace();
            if(r.isInTransaction())
                r.cancelTransaction();
        } finally {
            r.close();
        }
    }

}
