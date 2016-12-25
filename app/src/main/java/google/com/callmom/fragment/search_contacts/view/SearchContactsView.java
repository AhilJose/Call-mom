package google.com.callmom.fragment.search_contacts.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import butterknife.BindView;
import google.com.callmom.R;
import google.com.callmom.fragment.base_fragment.view.BaseView;
import google.com.callmom.fragment.search_contacts.presenter.ISearchContactsPresenter;

/**
 * Created by Sergey on 25.12.2016.
 */

public class SearchContactsView extends BaseView implements ISearchContactsView {

    private final ISearchContactsPresenter presenter;

    @BindView(R.id.search_view)
    MaterialSearchView searchView;

    public SearchContactsView(ISearchContactsPresenter presenter, View root, Context context) {
        super(root, context);
        this.presenter = presenter;
    }


    @Override
    public void setupSearchView(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.onQuerySearchTextSubmit(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                presenter.onQuerySearchTextChange(newText);
                return false;
            }
        });
    }
}
