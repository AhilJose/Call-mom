package google.com.callmom.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import google.com.callmom.R;

/**
 * Created by Sergey on 25.12.2016.
 */

public class ViewHelper {

    public static void showFragmentWithFadeWithoutReplace(FragmentManager fragmentManager, Fragment fragment, boolean isAddToBackStack, String backStackKey) {
        FragmentTransaction transaction =
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.animator.fade_in, R.animator.stay_in_place, R.animator.stay_in_place, R.animator.fade_out)
                        .add(R.id.body_fragment, fragment);

        if (isAddToBackStack)
            transaction.addToBackStack(backStackKey);
        transaction.commit();
    }

    public static void showFirstFragment(FragmentManager fragmentManager, Fragment fragment) {
        showFragmentWithoutAnimation(fragmentManager, fragment, false, null);
    }

    public static void showFragmentLeftRight(FragmentManager fragmentManager, Fragment fragment, boolean addToBackStack, String backStackKey) {
        FragmentTransaction transaction =
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left, R.animator.slide_in_right, R.animator.slide_out_right)
                        .replace(R.id.body_fragment, fragment);
        if (addToBackStack)
            transaction.addToBackStack(backStackKey);
        transaction.commitAllowingStateLoss();
    }

    public static void showFragmentWithoutAnimation(FragmentManager fragmentManager, Fragment fragment, boolean addToBackStack, String backStackKey) {
        FragmentTransaction transaction =
                fragmentManager
                        .beginTransaction()
                        .add(R.id.body_fragment, fragment);
        if (addToBackStack)
            transaction.addToBackStack(backStackKey);
        transaction.commit();
    }
}
