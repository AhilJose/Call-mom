package google.com.callmom.activity;

import android.app.Fragment;
import android.support.annotation.NonNull;

import google.com.callmom.R;
import google.com.callmom.fragment.contacts_screen.presenter.ContactPresenter;
import google.com.callmom.fragment.search_contacts.presenter.SearchContactsPresenter;
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        currentFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void showSearchContactFragment() {
        currentFragment = new SearchContactsPresenter();
        ViewHelper.showFragmentLeftRight(getFragmentManager(), currentFragment, true, null);

    }
}
