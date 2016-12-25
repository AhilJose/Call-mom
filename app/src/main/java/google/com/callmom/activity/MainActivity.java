package google.com.callmom.activity;

import android.app.Fragment;

import google.com.callmom.R;

public class MainActivity extends BaseActivity {

    @Override
    protected Fragment getFirstFragment() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
