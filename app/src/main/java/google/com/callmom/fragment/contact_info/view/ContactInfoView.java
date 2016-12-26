package google.com.callmom.fragment.contact_info.view;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import google.com.callmom.R;
import google.com.callmom.fragment.base_fragment.view.BaseView;
import google.com.callmom.fragment.contact_info.presenter.IContactInfoPresenter;
import google.com.callmom.model.CallTime;
import google.com.callmom.utils.DateUtils;

/**
 * Created by Sergey on 26.12.2016.
 */

public class ContactInfoView extends BaseView implements IContactInfoView {

    private final IContactInfoPresenter presenter;

    @BindView(R.id.avatar_image_view)
    CircleImageView avatarImageView;

    @BindView(R.id.name_text_view)
    TextView nameTextView;

    @BindView(R.id.phone_text_view)
    TextView phoneTextView;

    @BindView(R.id.time_from_text_view)
    TextView timeFromTextView;

    @BindView(R.id.time_to_text_view)
    TextView timeToTextView;

    public ContactInfoView(View root, Context context, IContactInfoPresenter presenter) {
        super(root, context);
        this.presenter = presenter;
        setupView();
    }

    private void setupView() {
        setupData();
    }

    private void setupData() {
        updateAvatar();
        updateTextData();
        updateTimeView();
    }

    private void updateTextData() {
        nameTextView.setText(presenter.getContactName());
        phoneTextView.setText(presenter.getContactPhoneNumber());
    }

    private void updateAvatar() {
        String uri = presenter.getContactAvatarUri();
        if (uri != null) {
            Picasso.with(getContext()).load(Uri.parse(uri)).into(avatarImageView);
        } else {
            Picasso.with(getContext()).load(R.drawable.avatar_placeholder).into(avatarImageView);
        }
    }

    @Override
    public void updateTimeView() {
        timeFromTextView.setText(DateUtils.getSimpleTime(presenter.getTimeFrom()));
        timeToTextView.setText(DateUtils.getSimpleTime(presenter.getTimeTo()));
    }

    @OnClick(R.id.time_from_text_view)
    void onFromTimeClicked() {
        presenter.onFromTimeClicked();
    }

    @OnClick(R.id.time_to_text_view)
    void onToTimeClicked() {
        presenter.onToTimeClicked();
    }

    @OnClick(R.id.add_button)
    void onAddButtonClicked() {
        presenter.onAddButtonClicked();
    }

    @OnClick(R.id.cancel_button)
    void onCancelButtonClicked() {
        presenter.onCancelButtonClicked();
    }
}
