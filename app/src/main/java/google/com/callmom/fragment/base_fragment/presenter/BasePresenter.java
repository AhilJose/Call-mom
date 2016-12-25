package google.com.callmom.fragment.base_fragment.presenter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sergey on 25.12.2016.
 */

public abstract class BasePresenter extends Fragment implements IBasePresenter {

    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        this.root = root;
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createView(view);
        onFinishCreatingView();
    }

    protected void onFinishCreatingView(){

    }

    protected abstract int getLayoutId();

    protected abstract void createView(View root);

    public View getRoot() {
        return root;
    }
}
