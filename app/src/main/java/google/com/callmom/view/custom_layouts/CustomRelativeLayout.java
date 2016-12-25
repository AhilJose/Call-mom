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
