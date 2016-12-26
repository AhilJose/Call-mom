package google.com.callmom.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import google.com.callmom.model.CallTime;

/**
 * Created by Sergey on 26.12.2016.
 */

public class DateUtils {

    public static final String SIMPLE_DATA_FORMAT = "HH:mm";
    private static final SimpleDateFormat shortDateFormatter = new SimpleDateFormat(SIMPLE_DATA_FORMAT);

    public static String getSimpleTime(CallTime time) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, time.getHour());
        calendar.set(Calendar.MINUTE, time.getMinute());
        return shortDateFormatter.format(calendar.getTime());
    }
}
