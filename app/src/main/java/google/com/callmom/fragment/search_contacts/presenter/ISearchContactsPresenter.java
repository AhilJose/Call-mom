package google.com.callmom.fragment.search_contacts.presenter;

import google.com.callmom.fragment.base_fragment.presenter.IBasePresenter;

/**
 * Created by Sergey on 25.12.2016.
 */
public interface ISearchContactsPresenter extends IBasePresenter {
    void onQuerySearchTextSubmit(String query);

    void onQuerySearchTextChange(String newText);

    void onBackButtonClicked();
}
