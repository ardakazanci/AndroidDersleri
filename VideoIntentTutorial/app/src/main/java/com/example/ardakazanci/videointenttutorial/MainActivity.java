package com.example.ardakazanci.videointenttutorial;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_VIDEO_CAPTURE = 1453;
    VideoView videoView;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getControlView();
        setControlView();

    }

    private void getControlView() { // Nesnenelerimizi Çağırıyoruz.


        videoView = (VideoView) findViewById(R.id.videoView);
        btn = (Button) findViewById(R.id.btn);


    }

    private void setControlView() {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeVideoFromCamera();
            }
        });

    }


    private void takeVideoFromCamera() {

        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE); // Oluşturduğumuz intent nesnesi sisteme kamera uygulamasını başlatması için niyette bulunuyor.
        if (intent.resolveActivity(getPackageManager()) != null) {

            startActivityForResult(intent,REQUEST_VIDEO_CAPTURE);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
                Uri videoUri = data.getData();
                videoView.setVideoURI(videoUri);
            }
        }
    }

