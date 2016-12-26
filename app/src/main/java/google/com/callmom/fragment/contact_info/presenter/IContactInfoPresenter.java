package google.com.callmom.fragment.contact_info.presenter;

import google.com.callmom.fragment.base_fragment.presenter.IBasePresenter;
import google.com.callmom.model.CallTime;

/**
 * Created by Sergey on 26.12.2016.
 */
public interface IContactInfoPresenter extends IBasePresenter{
    String getContactAvatarUri();

    String getContactName();

    String getContactPhoneNumber();

    void onFromTimeClicked();

    void onToTimeClicked();

    void onAddButtonClicked();

    void onCancelButtonClicked();

    CallTime getTimeFrom();

    CallTime getTimeTo();
}
