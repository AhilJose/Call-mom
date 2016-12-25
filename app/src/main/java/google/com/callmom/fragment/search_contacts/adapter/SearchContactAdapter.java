package google.com.callmom.fragment.search_contacts.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import google.com.callmom.R;

/**
 * Created by Sergey on 25.12.2016.
 */

public class SearchContactAdapter extends RecyclerView.Adapter<SearchContactViewHolder>{
    @Override
    public SearchContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_contact, parent, false);
        return new SearchContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchContactViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
