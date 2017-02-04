package com.example.ardakazanci.createanintentobject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button buttonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewController();
        viewClickController();

    }

    private void viewController() {


        buttonObject = (Button) findViewById(R.id.create_an_intent_object);


    }


    private void viewClickController() {


        buttonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(); // New Intent Create bla bla bla ;

                Toast.makeText(getApplicationContext(), "Create an intent object ", Toast.LENGTH_LONG).show();


            }
        });

    }

}
