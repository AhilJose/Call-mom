package google.com.callmom.model;

import io.realm.RealmObject;

/**
 * Created by Sergey on 25.12.2016.
 */

public class CallSchedule extends RealmObject{

    private int callInWeek;
    private CallTime from;
    private CallTime to;

    public CallSchedule(int callInWeek, CallTime from, CallTime to) {
        this.callInWeek = callInWeek;
        this.from = from;
        this.to = to;
    }

    public int getCallInWeek() {
        return callInWeek;
    }

    public void setCallInWeek(int callInWeek) {
        this.callInWeek = callInWeek;
    }

    public CallTime getFrom() {
        return from;
    }

    public void setFrom(CallTime from) {
        this.from = from;
    }

    public CallTime getTo() {
        return to;
    }

    public void setTo(CallTime to) {
        this.to = to;
    }
}
