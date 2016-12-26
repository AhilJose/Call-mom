package google.com.callmom.fragment.contacts_screen.presenter;

import android.view.View;

import google.com.callmom.R;
import google.com.callmom.activity.MainActivity;
import google.com.callmom.fragment.base_fragment.presenter.BasePresenter;
import google.com.callmom.fragment.base_fragment.view.IBaseView;
import google.com.callmom.fragment.contacts_screen.view.ContactView;
import google.com.callmom.fragment.search_contacts.presenter.SearchContactsPresenter;

/**
 * Created by Sergey on 25.12.2016.
 */

public class ContactPresenter extends BasePresenter implements IContactPresenter {
    private ContactView view;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_contacts;
    }

    @Override
    protected IBaseView createView(View root) {
        view = new ContactView(this, root, getActivity());
        return view;
    }

    @Override
    public void onAddBackClicked() {
        ((MainActivity)getActivity()).showFragmentFromRight(new SearchContactsPresenter(), true, null);
    }
}
