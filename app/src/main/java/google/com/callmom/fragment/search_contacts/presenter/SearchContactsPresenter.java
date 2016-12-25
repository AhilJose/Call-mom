package google.com.callmom.fragment.search_contacts.presenter;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import java.util.ArrayList;

import google.com.callmom.R;
import google.com.callmom.fragment.base_fragment.presenter.BasePresenter;
import google.com.callmom.fragment.search_contacts.adapter.SearchContactAdapter;
import google.com.callmom.fragment.search_contacts.view.ISearchContactsView;
import google.com.callmom.fragment.search_contacts.view.SearchContactsView;
import google.com.callmom.model.Contact;
import google.com.callmom.utils.ContactsHelper;
import google.com.callmom.utils.PermissionUpdateHelper;

/**
 * Created by Sergey on 25.12.2016.
 */

public class SearchContactsPresenter extends BasePresenter implements ISearchContactsPresenter {

    private ISearchContactsView view;
    private SearchContactAdapter adapter;
    private PermissionUpdateHelper permissionUpdateHelper;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_contacts;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAdapter();
    }

    @Override
    protected ISearchContactsView createView(View root) {
        view = new SearchContactsView(this, root, getActivity());
        return view;
    }

    @Override
    protected void onFinishCreatingView() {
        super.onFinishCreatingView();
    }

    @Override
    public void onStart() {
        super.onStart();
        setupAdapter();

    }

    private void setupAdapter() {
        tryGetContactList();
        view.setupAdapter(adapter);
    }

    private void initAdapter() {
        adapter = new SearchContactAdapter(getActivity(), new ArrayList<>(), this::onContactClicked);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(permissionUpdateHelper == null || !permissionUpdateHelper.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void tryGetContactList() {
        permissionUpdateHelper = new PermissionUpdateHelper(getActivity(), getString(R.string.permission_rationale), getString(R.string.permission_rationale_storage));
        permissionUpdateHelper.tryRequestPermission(new String[]{ContactsHelper.READ_CONTACT_PERMISSION}, this::onPermissionRequestFinished);
    }

    private void onPermissionRequestFinished(boolean isGranted) {
        if(isGranted) {
            adapter.setContactList(ContactsHelper.getTelephonNumber(getActivity()));
            adapter.notifyDataSetChanged();
        }else{
            view.showEmptyContactsMessage();
        }
    }

    private void onContactClicked(Contact contact){

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
        adapter.setSearchText(newText);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackButtonClicked() {
        getActivity().onBackPressed();
    }
}
