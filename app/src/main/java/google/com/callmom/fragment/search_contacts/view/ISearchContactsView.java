package google.com.callmom.fragment.search_contacts.view;

import android.view.Menu;

import google.com.callmom.fragment.base_fragment.view.IBaseView;
import google.com.callmom.fragment.search_contacts.adapter.SearchContactAdapter;

/**
 * Created by Sergey on 25.12.2016.
 */
public interface ISearchContactsView extends IBaseView{
    void setupSearchView(Menu menu);

    void showEmptyContactsMessage();

    void setupAdapter(SearchContactAdapter adapter);
}
