package com.example.ardakazanci.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControlView();

    }

    private void getControlView(){

        buttonObject = (Button) findViewById(R.id.start_other_activity_button);


    }

    private void setClickForView(){


        buttonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this,OtherActivity.class);
                startActivity(intent);


            }
        });


    }



}
