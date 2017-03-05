package com.example.ardakazanci.smsgondermeintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getContentView();
        setClickContentView();


    }


    private void getContentView(){

        btn = (Button) findViewById(R.id.button);


    }

    private void setClickContentView(){

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendSmsMessage("Merhaba deneme amaçlı bir sms gönderimi gerçekleşecektir","05555655665");

            }
        });

    }


    public void sendSmsMessage(String message,String tel){

        Intent intent = new Intent(Intent.ACTION_SENDTO);


        intent.setData(Uri.parse("smsto:"+tel));


        // intent’e veri olarak ne ekleyeceğiz, onu söylememiz gerekmekte. Bunun için de putExtra metodunu kullanıyoruz.

        intent.putExtra("sms_body",message);

        if(intent.resolveActivity(getPackageManager()) != null){

            startActivity(intent);

        }



    }



}
