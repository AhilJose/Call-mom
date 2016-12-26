package google.com.callmom.fragment.contacts_screen.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import google.com.callmom.R;
import google.com.callmom.model.Contact;

/**
 * Created by Sergey on 26.12.2016.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsViewHolder> {

    private final Context context;
    private ArrayList<Contact> listContacts;

    public ContactsAdapter(Context context, ArrayList<Contact> listContacts){
        this.context = context;
        this.listContacts = listContacts;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_info, parent, false);
        return new ContactsViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {
        holder.bind(listContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return listContacts.size();
    }
}
