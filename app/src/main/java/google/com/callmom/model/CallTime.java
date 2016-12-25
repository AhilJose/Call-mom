package google.com.callmom.model;

import io.realm.RealmObject;

/**
 * Created by Sergey on 25.12.2016.
 */

public class CallTime extends RealmObject {

    private int hour;
    private int minute;

    public CallTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
