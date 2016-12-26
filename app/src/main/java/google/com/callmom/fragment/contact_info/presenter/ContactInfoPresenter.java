package google.com.callmom.fragment.contact_info.presenter;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;

import google.com.callmom.R;
import google.com.callmom.fragment.base_fragment.presenter.BasePresenter;
import google.com.callmom.fragment.base_fragment.view.IBaseView;
import google.com.callmom.fragment.contact_info.view.ContactInfoView;
import google.com.callmom.fragment.contact_info.view.IContactInfoView;
import google.com.callmom.model.CallSchedule;
import google.com.callmom.model.CallTime;
import google.com.callmom.model.Contact;
import google.com.callmom.utils.Constants;
import google.com.callmom.utils.DataHelper;

/**
 * Created by Sergey on 26.12.2016.
 */

public class ContactInfoPresenter extends BasePresenter implements IContactInfoPresenter {

    private Contact contact;
    private IContactInfoView view;
    private CallTime newFrom;
    private CallTime newTo;

    public static ContactInfoPresenter createInstance(Contact contact) {
        ContactInfoPresenter presenter = new ContactInfoPresenter();
        presenter.contact = contact;
        return presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        if (contact.getCallSchedule() != null) {
            newFrom = contact.getCallSchedule().getFrom();
            newTo = contact.getCallSchedule().getTo();
        } else {
            newFrom = Constants.DEFAULT_FROM_TIME;
            newTo = Constants.DEFAULT_TO_TIME;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_contact_info;
    }

    @Override
    protected IBaseView createView(View root) {
        view = new ContactInfoView(root, getActivity(), this);
        return view;
    }

    @Override
    public String getContactAvatarUri() {
        return contact.getAvatarUri();
    }

    @Override
    public String getContactName() {
        return contact.getName();
    }

    @Override
    public String getContactPhoneNumber() {
        return contact.getNumber();
    }

    @Override
    public void onFromTimeClicked() {
        showTimePicker(newFrom.getHour(), newFrom.getMinute(), (timePicker, hour, minute) -> {
                    newFrom = new CallTime(hour, minute);
                    view.updateTimeView();
                }
        );
    }

    @Override
    public void onToTimeClicked() {
        showTimePicker(newTo.getHour(), newTo.getMinute(), (timePicker, hour, minute) -> {
                    newTo = new CallTime(hour, minute);
                    view.updateTimeView();
                }
        );
    }

    private void showTimePicker(int defaultHour, int defaultMinute, TimePickerDialog.OnTimeSetListener listener) {
        TimePickerDialog timepickerdialog = new TimePickerDialog(getActivity(), listener, defaultHour, defaultMinute, true);
        timepickerdialog.show();
    }

    @Override
    public void onAddButtonClicked() {
        DataHelper.startChangeOperation(realm -> {
            //TODO update it
            CallSchedule callSchedule = new CallSchedule(7, newFrom, newTo);
            contact.setCallSchedule(callSchedule);
            realm.copyToRealmOrUpdate(contact);
        });
        getActivity().onBackPressed();
    }

    @Override
    public void onCancelButtonClicked() {
        getActivity().onBackPressed();
    }

    @Override
    public CallTime getTimeFrom() {
        return newFrom;
    }

    @Override
    public CallTime getTimeTo() {
        return newTo;
    }
}
