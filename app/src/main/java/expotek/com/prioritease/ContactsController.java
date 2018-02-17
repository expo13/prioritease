package expotek.com.PrioriTease;

import android.annotation.SuppressLint;
import android.os.Build;
import android.provider.ContactsContract;

public class ContactsController {

    @SuppressLint("InlinedApi")
    private final static String[] FROM_COLUMNS = {
            Build.VERSION.SDK_INT
                    >= Build.VERSION_CODES.HONEYCOMB ?
                    ContactsContract.Contacts.DISPLAY_NAME_PRIMARY :
                    ContactsContract.Contacts.DISPLAY_NAME
    };

}
