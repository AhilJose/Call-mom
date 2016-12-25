package google.com.callmom.view.custom_layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Sergey on 25.12.2016.
 */

public class CustomLinearLayout extends LinearLayout {
    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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
