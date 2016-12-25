package google.com.callmom.utils;

/**
 * Created by Sergey on 25.12.2016.
 */

public interface Action<T> {
    void call(T result);
}
