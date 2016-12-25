package google.com.callmom.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import google.com.callmom.R;

/**
 * Created by Sergey on 25.12.2016.
 */

public class PermissionUpdateHelper {

    private static final String TAG = PermissionUpdateHelper.class.getSimpleName();
    private final Activity activity;
    private static final int REQUEST_CODE_PERMISSION = 99;
    private final String messagePermissionRationale;
    private final String messagePermissionStorageRationale;
    private String[] arrayPermissions;
    private OnPermissionRequestFinishListener permissionRequestFinishListener;

    public PermissionUpdateHelper(Activity activity, String messagePermissionRationale, String messagePermissionStorageRationale){
        this.activity = activity;
        this.messagePermissionRationale = messagePermissionRationale;
        this.messagePermissionStorageRationale = messagePermissionStorageRationale;
    }

    public interface OnPermissionRequestFinishListener{
        void onRequestFinish(boolean isPermissionGranted);
    }

    public void tryRequestPermission(String[] arrayPermissions, OnPermissionRequestFinishListener listener) {
        this.arrayPermissions = arrayPermissions;
        if (isNeedHandlePermissions()) {
            this.permissionRequestFinishListener = listener;
            updatePermissionState();
        }else{
            listener.onRequestFinish(true);
        }
    }

    public static boolean isNeedHandlePermissions() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void updatePermissionState() {
        List<String> permissions = getDeniedPermissionForAndroidM();
        if (permissions.size() != 0) {
            activity.requestPermissions(permissions.toArray(new String[permissions.size()]), REQUEST_CODE_PERMISSION);
        } else {
            permissionRequestFinishListener.onRequestFinish(true);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private List<String> getDeniedPermissionForAndroidM() {
        List<String> permissions = new ArrayList<>();
        for (int i = 0; i < arrayPermissions.length; i++) {
            if (ContextCompat.checkSelfPermission(activity, arrayPermissions[i]) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(arrayPermissions[i]);
            }
        }
        return permissions;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSION: {
                List<String> deniedPermissions = new ArrayList<>();
                for (int i = 0; i < permissions.length; i++) {
                    Log.d(TAG, "Permission receive" + permissions[i]);
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        Log.d(TAG, "Permission Granted: " + permissions[i]);
                    } else {
                        Log.d(TAG, "Permission Denied: " + permissions[i]);
                        deniedPermissions.add(permissions[i]);
                    }
                }
                if (deniedPermissions.size() != 0) {
                    repeatPermissionRequest(deniedPermissions);
                } else {
                    permissionRequestFinishListener.onRequestFinish(true);
                }
                return true;
            }
            default: {
                return false;
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void repeatPermissionRequest(final List<String> deniedPermissions) {
        // if all of denied permission is neverAskAgainPermission we don't need repeat usual request permission
        if (deniedPermissions.size() != getNeverAskAgainPermission(deniedPermissions).size()) {
            showPermissionRationaleDialog(deniedPermissions);
        } else {
            requestCancelNeverAskAgainPermission(deniedPermissions);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void showPermissionRationaleDialog(final List<String> deniedPermissions) {
        new AlertDialog.Builder(activity)
                .setMessage(messagePermissionRationale)
                .setPositiveButton(activity.getString(R.string.retry_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.requestPermissions(deniedPermissions.toArray(new String[deniedPermissions.size()]), REQUEST_CODE_PERMISSION);
                    }
                })
                .setNegativeButton(activity.getString(R.string.im_sure_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        permissionRequestFinishListener.onRequestFinish(false);
                    }
                })
                .create()
                .show();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void requestCancelNeverAskAgainPermission(List<String> deniedPermissions) {
        if (getNeverAskAgainPermission(deniedPermissions).size() == 0) {
            return;
        }
        showStoragePermissionRationaleDialog();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void showStoragePermissionRationaleDialog() {
        new AlertDialog.Builder(activity)
                .setMessage(messagePermissionStorageRationale)
                .setPositiveButton(activity.getString(R.string.allow_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openAppSettings();
                    }
                })
                .setNegativeButton(activity.getString(R.string.i_dont_want_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        permissionRequestFinishListener.onRequestFinish(false);
                    }
                })
                .create()
                .show();
    }


    private void openAppSettings() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
        intent.setData(uri);
        activity.startActivity(intent);
    }

    @TargetApi(Build.VERSION_CODES.M)
    private List<String> getNeverAskAgainPermission(List<String> deniedPermissions) {
        List<String> neverAskAgainPermission = new ArrayList<>();
        for (String deniedPermission : deniedPermissions) {
            if (!activity.shouldShowRequestPermissionRationale(deniedPermission)) {
                neverAskAgainPermission.add(deniedPermission);
            }
        }
        return neverAskAgainPermission;
    }

    public static boolean isPermissionGranted(Context context, String[] arrayPermissions){
        if(isNeedHandlePermissions()){
            return true;
        }
        for (int i = 0; i < arrayPermissions.length; i++) {
            if (ContextCompat.checkSelfPermission(context, arrayPermissions[i]) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

}
