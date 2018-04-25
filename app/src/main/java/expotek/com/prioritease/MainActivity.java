package expotek.com.prioritease;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.SectionContext;

import java.util.ArrayList;
import java.util.List;

import expotek.com.prioritease.constants.Constants;
import expotek.com.prioritease.views.BucketButtonSpec;
import expotek.com.prioritease.views.FloatingButtonSpec;
import expotek.com.prioritease.views.MainLayout;

public class MainActivity extends AppCompatActivity implements BucketButtonSpec.OnButtonClickListener { //, FloatingButtonSpec.OnButtonClickListenerFloatingButton {

    private List<Bucket> bucketList = new ArrayList<Bucket>();
    private OnContactsRefresh onContactsRefresh;

    private boolean contactsNeedToBeRefreshed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ComponentContext c = new ComponentContext(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission to Contacts not granted", Toast.LENGTH_LONG).show();

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    Constants.MY_PERMISSIONS_REQUEST_READ_CONTACTS);
//            this.onCreate(null); TODO likely take this out
//            onContactsRefresh.onContactsRefresh(, bucketList, this);

        } else {
            populateContactsBucket();
        }

        final LithoView lithoView = LithoView.create(
                this /* context */,
                MainLayout.create(c).title("SET YOUR PRIORITEASE").bucketList(bucketList)
//                        .floatingButtonListener(this)
                        .listener(this).build());

        setContentView(lithoView);

    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        Log.d("MainActivity", ".onResume");
        if (contactsNeedToBeRefreshed){
            populateContactsBucket();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onButtonClick() {
        Toast.makeText(this, "This litho button works!", Toast.LENGTH_LONG).show();
    }

//    @Override
//    public void onFloatingButtonClick() {
//        Toast.makeText(this, "AND! This litho button works!", Toast.LENGTH_LONG).show();
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case Constants.MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    populateContactsBucket();
                } else {

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    private void populateContactsBucket(){
        List<String> listOfContacts = ContactsController.getContactList(this);
        for (String contactName : listOfContacts) {
            bucketList.add(new Bucket(contactName));
        }
        contactsNeedToBeRefreshed=false;
    }

    public interface OnContactsRefresh {
//        void onContactsRefresh(SectionContext c, List<Bucket> bucketList, BucketButtonSpec.OnButtonClickListener listener );
    }
}
