package google.com.callmom.fragment.contacts_screen.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import google.com.callmom.model.Contact;

/**
 * Created by Sergey on 26.12.2016.
 */
public class ContactsViewHolder extends RecyclerView.ViewHolder {

    private final Context context;

    public ContactsViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
    }

    public void bind(Contact contact) {

    }
}
