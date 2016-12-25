package google.com.callmom.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import google.com.callmom.view.ViewHelper;

/**
 * Created by Sergey on 25.12.2016.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (isShowFirstFragmentImmediately()) {
            showFirstFragment();
        }
    }

    protected boolean isShowFirstFragmentImmediately() {
        return true;
    }

    protected void showFirstFragment() {
        ViewHelper.showFirstFragment(getFragmentManager(), getFirstFragment());
    }

    protected abstract Fragment getFirstFragment();

    protected abstract int getLayoutId();

    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() != 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

}
