package google.com.callmom.view.custom_layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Sergey on 25.12.2016.
 */

public class CustomRelativeLayout extends RelativeLayout {
    float xFraction;
    float yFraction;

    public CustomRelativeLayout(Context context) {
        super(context);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public float getXFraction() {
        if (getWidth() != 0)
            return getX() / getWidth();
        else return 0;// TODO: guard divide-by-zero
    }

    public void setXFraction(float xFraction) {
        // TODO: cache width
        final int width = getWidth();
        setTranslationX((width > 0) ? (xFraction * width) : -9999);
    }

    public float getYFraction() {
        if (getHeight() != 0)
            return getY() / getHeight();
        else return 0;
    }

    public void setYFraction(float yFraction) {
        final int height = getHeight();
        setTranslationY((height > 0) ? (yFraction * height) : -9999);
    }
}
