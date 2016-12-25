package google.com.callmom.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sergey on 25.12.2016.
 */

public class Contact extends RealmObject {

    @PrimaryKey
    private String name;
    private String number;
    private CallSchedule callSchedule;

    public Contact(String name, String number, CallSchedule callSchedule) {
        this.name = name;
        this.number = number;
        this.callSchedule = callSchedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CallSchedule getCallSchedule() {
        return callSchedule;
    }

    public void setCallSchedule(CallSchedule callSchedule) {
        this.callSchedule = callSchedule;
    }
}
