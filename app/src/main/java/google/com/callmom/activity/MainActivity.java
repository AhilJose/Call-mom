package google.com.callmom.activity;

import android.app.Fragment;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import google.com.callmom.R;
import google.com.callmom.fragment.contacts_screen.presenter.ContactPresenter;
import google.com.callmom.view.ViewHelper;

public class MainActivity extends BaseActivity {

    private Fragment currentFragment;

    @Override
    protected Fragment getFirstFragment() {
        currentFragment = new ContactPresenter();
        return currentFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        currentFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void showFragmentFromRight(Fragment fragment, boolean addToBackStack, String backStackKey) {
        currentFragment = fragment;
        ViewHelper.showFragmentLeftRight(getFragmentManager(), currentFragment, addToBackStack, backStackKey);
    }
}
