package google.com.callmom.view.custom_layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by Sergey on 25.12.2016.
 */

public class CustomFrameLayout extends FrameLayout {

    public CustomFrameLayout(Context context) {
        super(context);
    }

    public CustomFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public float getXFraction() {
        return CustomLayoutHelper.getXFraction(this);
    }

    public void setXFraction(float xFraction) {
        CustomLayoutHelper.setXFraction(this, xFraction);
    }

    public float getYFraction() {
        return CustomLayoutHelper.getYFraction(this);
    }

    public void setYFraction(float yFraction) {
        CustomLayoutHelper.setYFraction(this, yFraction);
    }
}