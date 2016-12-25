package google.com.callmom.fragment.search_contacts.presenter;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import google.com.callmom.R;
import google.com.callmom.fragment.base_fragment.presenter.BasePresenter;
import google.com.callmom.fragment.search_contacts.view.ISearchContactsView;
import google.com.callmom.fragment.search_contacts.view.SearchContactsView;

/**
 * Created by Sergey on 25.12.2016.
 */

public class SearchContactsPresenter extends BasePresenter implements ISearchContactsPresenter {

    private ISearchContactsView view;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_contacts;
    }

    @Override
    protected ISearchContactsView createView(View root) {
        view = new SearchContactsView(this, root, getActivity());
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.search_contact_menu, menu);
        view.setupSearchView(menu);
    }

    @Override
    public void onQuerySearchTextSubmit(String query) {

    }

    @Override
    public void onQuerySearchTextChange(String newText) {

    }
}
