package google.com.callmom.view.custom_layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Sergey on 26.12.2016.
 */

public class CustomScrollView extends ScrollView {

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
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
