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
    private String avatarUri;
    private CallSchedule callSchedule;

    public Contact() {
    }

    public Contact(String name, String number, String avatarUri) {
        this.name = name;
        this.number = number;
        this.avatarUri = avatarUri;
    }

    public Contact(String name, String number, String avatarUri, CallSchedule callSchedule) {
        this.name = name;
        this.number = number;
        this.avatarUri = avatarUri;
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

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }
}
