package com.example.ardakazanci.alarmtutorial;

import android.content.Intent;
import android.icu.util.Calendar;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int [] days = new int[]{Calendar.FRIDAY,Calendar.MONDAY};
        createAlarm("Alarm Deneme",2,5,days,true,false);


    }

    public void createAlarm(String message, int hour, int minutes, int[] days, boolean vibrate, boolean skipui) {


        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM); // Alarm uygulamasına ait intent başlangıcı

        intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);
        intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        intent.putExtra(AlarmClock.EXTRA_DAYS, days);
        intent.putExtra(AlarmClock.EXTRA_VIBRATE, vibrate);
        intent.putExtra(AlarmClock.EXTRA_SKIP_UI, skipui); // Alarm sayfasıın gösterilmesi sağlanıyor.


        if (intent.resolveActivity(getPackageManager()) != null) { // resolveActivity cihazımızda bu intent işlemini gerçekleştirecek uygulama olup olmadığını kontrol eder.


            startActivity(intent); // istek eğer boş değilse aktivite başlar.


        }


    }



}
