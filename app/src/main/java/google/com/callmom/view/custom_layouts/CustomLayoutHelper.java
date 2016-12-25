package google.com.callmom.view.custom_layouts;

import android.view.View;

/**
 * Created by Sergey on 25.12.2016.
 */

public class CustomLayoutHelper {
    public static float getXFraction(View view) {
        if (view.getWidth() != 0)
            return view.getX() / view.getWidth();
        else return 0;
    }

    public static void setXFraction(View view, float xFraction) {
        int width = view.getWidth();
        view.setTranslationX((width > 0) ? (xFraction * width) : -9999);
    }

    public static float getYFraction(View view) {
        if (view.getHeight() != 0)
            return view.getY() / view.getHeight();
        else return 0;
    }

    public static void setYFraction(View view, float yFraction) {
        final int height = view.getHeight();
        view.setTranslationY((height > 0) ? (yFraction * height) : -9999);
    }
}
