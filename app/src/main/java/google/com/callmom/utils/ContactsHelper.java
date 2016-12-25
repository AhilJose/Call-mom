package google.com.callmom.utils;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.HashMap;

import google.com.callmom.model.Contact;

/**
 * Created by Sergey on 25.12.2016.
 */

public class ContactsHelper {

    public static final String READ_CONTACT_PERMISSION = Manifest.permission.READ_CONTACTS;

    public static ArrayList<Contact> getTelephonNumber(Activity activity) {
        ContentResolver cr = activity.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

        HashMap<String, Contact> contactFriendHashSet = new HashMap<>();

        handleContactResult(cr, cur, contactFriendHashSet);
        ArrayList<Contact> contactList = new ArrayList<>();
        contactList.addAll(contactFriendHashSet.values());
        return contactList;

    }

    private static void handleContactResult(ContentResolver cr, Cursor cur, HashMap<String, Contact> contactFriendHashSet) {
        if (cur != null && cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String uri = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));

                if (cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id},
                            null);
                    fillContactsSet(pCur, contactFriendHashSet, uri, name);
                }
            }
            cur.close();
        }
    }

    private static void fillContactsSet(Cursor pCur, HashMap<String, Contact> contactFriendHashSet, String uri, String name) {
        while (pCur.moveToNext()) {
            String phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Contact containedContact = contactFriendHashSet.get(phoneNo);
            if (containedContact != null) {
                if (containedContact.getAvatarUri() == null && uri != null) {
                    containedContact.setAvatarUri(uri);
                    //Change name if avatar added because it is better
                    // to user show same connect name and avatar for contact
                    if (name != null) {
                        containedContact.setName(name);
                    }
                }

                if (containedContact.getName() == null && name != null) {
                    containedContact.setName(name);
                    //Change uri of avatar if avatar added because it is better
                    // to user show same connect name and avatar for contact
                    if (uri != null) {
                        containedContact.setAvatarUri(uri);
                    }
                }
            } else {
                contactFriendHashSet.put(phoneNo, new Contact(name, phoneNo, uri));
            }
        }
        pCur.close();
    }
}