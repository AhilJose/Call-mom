package google.com.callmom.fragment.search_contacts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import google.com.callmom.R;
import google.com.callmom.model.Contact;
import google.com.callmom.utils.Action;

/**
 * Created by Sergey on 25.12.2016.
 */

public class SearchContactAdapter extends RecyclerView.Adapter<SearchContactViewHolder>{

    private final Action<Contact> contactClickedListener;
    private final Context context;
    ArrayList<Contact> listContacts;
    ArrayList<Contact> additionalListContacts;

    public SearchContactAdapter(Context context, ArrayList<Contact> listContacts, Action<Contact> contactClickedListener){
        this.context = context;
        this.listContacts = listContacts;
        this.additionalListContacts = listContacts;
        this.contactClickedListener = contactClickedListener;
    }

    @Override
    public SearchContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_contact, parent, false);
        return new SearchContactViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(SearchContactViewHolder holder, int position) {
        holder.bind(getElement(position), contactClickedListener);
    }

    private Contact getElement(int position) {
        return additionalListContacts.get(position);
    }

    @Override
    public int getItemCount() {
        return additionalListContacts.size();
    }

    public void setContactList(ArrayList<Contact> listContacts) {
        this.additionalListContacts = listContacts;
        this.listContacts = listContacts;
    }

    public void setSearchText(String newText) {
        additionalListContacts = new ArrayList<>();
        for(Contact contact : listContacts){
            if(contact.getName().toLowerCase().contains(newText.toLowerCase())){
                additionalListContacts.add(contact);
            }
        }
    }
}
