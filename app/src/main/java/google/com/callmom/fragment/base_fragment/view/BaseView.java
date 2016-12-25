package google.com.callmom.fragment.base_fragment.view;

import android.content.Context;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Sergey on 25.12.2016.
 */

public class BaseView implements IBaseView {

    private final View root;
    private final Context context;

    protected BaseView(View root, Context context){
        this.root = root;
        this.context = context;
        initButterKnife();
    }

    private void initButterKnife() {
        ButterKnife.bind(this, root);
    }

    public View getRoot() {
        return root;
    }

    public Context getContext() {
        return context;
    }
}
