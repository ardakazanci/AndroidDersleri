package com.example.ardakazanci.implicitintenttutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setClickForView();

    }


    private void setClickForView() {

        startButton = (Button) findViewById(R.id.yeniActivity);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent("com.example.ardakazanci.implicitintenttutorial.OtherActivity");
                startActivity(intent);
            }
        });

    }
}
