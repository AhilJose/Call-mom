package google.com.callmom.fragment.search_contacts.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import google.com.callmom.R;
import google.com.callmom.model.Contact;
import google.com.callmom.utils.Action;

/**
 * Created by Sergey on 25.12.2016.
 */

public class SearchContactViewHolder extends RecyclerView.ViewHolder {

    private final Context context;
    @BindView(R.id.avatar_image_view)
    CircleImageView avatarImageView;

    @BindView(R.id.name_text_view)
    TextView nameTextView;

    public SearchContactViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);
        setupView();
    }

    private void setupView() {
        Typeface type = Typeface.createFromAsset(context.getAssets(),"font/avenir/Anonymous_Pro.ttf");
        nameTextView.setTypeface(type);
    }

    public void bind(Contact contact, Action<Contact> contactClickedListener) {
        if(contact.getAvatarUri() != null) {
            Picasso.with(context).load(Uri.parse(contact.getAvatarUri())).into(avatarImageView);
        }else{
            Picasso.with(context).load(R.drawable.avatar_placeholder).into(avatarImageView);
        }
        nameTextView.setText(contact.getName());
        itemView.setOnClickListener(view -> contactClickedListener.call(contact));
    }
}
