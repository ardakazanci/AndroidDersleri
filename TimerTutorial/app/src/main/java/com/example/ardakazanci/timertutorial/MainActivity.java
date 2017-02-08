package com.example.ardakazanci.timertutorial;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startTimer("Yarış başlıyor",5,false);

    }

    public void startTimer(String message, int seconds, boolean skipui) {

        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);

        intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);
        intent.putExtra(AlarmClock.EXTRA_LENGTH, seconds);
        intent.putExtra(AlarmClock.EXTRA_SKIP_UI, skipui);

        if (intent.resolveActivity(getPackageManager()) != null) {

            // getPackageMenager ile şuanda yüklü ulan api üzerinde ki donanım hakkında bilgi almamızı sağlıyor.

            startActivity(intent);


        }
    }

}


