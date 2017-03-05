package com.example.ardakazanci.isimvenumaraerisimiintent;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    static final int REQUEST_SELECT_PHONE_NUMBER = 1453;
    Button btn;
    Uri contactUri; // MIME tipi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getContentView();
        setClickForView();

    }


    private void getContentView() {

        btn = (Button) findViewById(R.id.button);


    }

    private void setClickForView() {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                selectContact();


            }
        });

    }


    private void selectContact(){

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if(intent.resolveActivity(getPackageManager()) !=null ){

            startActivityForResult(intent,REQUEST_SELECT_PHONE_NUMBER);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_SELECT_PHONE_NUMBER && resultCode == RESULT_OK) {

            contactUri = data.getData();
            String[] fields = new String[]{

                    ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};

            Cursor cursor = getContentResolver().query(contactUri, fields, null, null, null);
            cursor.moveToFirst();

            int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            String name = cursor.getString(nameIndex);
            Log.i("name",name);
            String number = cursor.getString(numberIndex);
            Log.i("number",""+number);

        }


    }

}

