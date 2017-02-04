package com.example.ardakazanci.explicitintent;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.view.View.Y;

public class MainActivity extends AppCompatActivity {

    Button buttonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControlView();
        setClickForView();

    }

    private void getControlView() {

        buttonObject = (Button) findViewById(R.id.start_other_activity_button);


    }

    private void setClickForView() {


        buttonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



//                Practice 1
//
//                Intent intent = new Intent(); // Yeni bir intent nesnesi
//                ComponentName componentName = new ComponentName(MainActivity.this,OtherActivity.class);
//                intent.setComponent(componentName);
//                startActivity(intent);


//                Practice 2

//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this,OtherActivity.class);
//                startActivity(intent);
//
//                Practice 3

//                Intent intent = new Intent();
//                intent.setClassName("com.example.ardakazanci.explicitintent","com.example.ardakazanci.OtherActivity"); // İlkinde package name ikincisinde class name
//                startActivity(intent);

                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent);


            }
        });


    }


}
