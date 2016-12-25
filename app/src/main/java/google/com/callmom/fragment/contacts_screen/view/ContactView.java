package google.com.callmom.fragment.contacts_screen.view;

import android.content.Context;
import android.view.View;

import butterknife.OnClick;
import google.com.callmom.R;
import google.com.callmom.fragment.base_fragment.view.BaseView;
import google.com.callmom.fragment.contacts_screen.presenter.IContactPresenter;

/**
 * Created by Sergey on 25.12.2016.
 */

public class ContactView extends BaseView implements IContactView {

    private final IContactPresenter presenter;

    public ContactView(IContactPresenter presenter, View root, Context context) {
        super(root, context);
        this.presenter = presenter;
    }

    @OnClick(R.id.add_button)
    void onAddBackClicked(){
        presenter.onAddBackClicked();
    }

}
