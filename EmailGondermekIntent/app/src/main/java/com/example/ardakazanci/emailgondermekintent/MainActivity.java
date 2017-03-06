package com.example.ardakazanci.emailgondermekintent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnEmail;
    private ImageView imageView;
    private Uri attachment;
    static final int REQUEST_IMAGE_GET = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Tıklama olayını tutan metot - View nesnelerini cast eden metot.

        getControlView();
        setClickForView();


    }


    public void getControlView() {

        btnEmail = (Button) findViewById(R.id.btnEmail);
        imageView = (ImageView) findViewById(R.id.imageView);

    }

    public void setClickForView() {

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectImage();

            }
        });


        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                composeEmail(new String[]{"androidkaynak@gmail.com"}, "Android Eğitimi", "Android ile Email Göndermek", attachment);


            }
        });

    }


    public void selectImage() {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        if (intent.resolveActivity(getPackageManager()) != null) {

            startActivityForResult(intent, REQUEST_IMAGE_GET);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {

            Bitmap bitmap = data.getParcelableExtra("data");
            attachment = data.getData();
            imageView.setImageURI(attachment);

        }

    }

    public void composeEmail(String[] addresses, String subject, String emailBody, Uri attachment) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailBody);
        intent.putExtra(Intent.EXTRA_STREAM, attachment);

        if (intent.resolveActivity(getPackageManager()) != null) {

            startActivity(intent);

        }

    }


}



