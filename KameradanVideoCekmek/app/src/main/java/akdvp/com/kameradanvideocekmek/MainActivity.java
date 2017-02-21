package akdvp.com.kameradanvideocekmek;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_VIDEO_CAPTURE = 1453; // Kamera uygulamasının hangi intent nesnesine cevap vereceğini belirlemek için bir sabit tanımladık.

    VideoView videoView;

    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControlView();
        setControlView();


    }

    private void getControlView() {
        // findViewById -> Görünümü bulmamızı sağlıyor. Cast işlemiyle o görünüme ait özellikleri kullanabiliyoruz.
        videoView = (VideoView) findViewById(R.id.videoView);
        btn = (Button) findViewById(R.id.btn);

    }


    private void setControlView() {


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                takeVideopCaptureStart();

            }
        });


    }


    private void takeVideopCaptureStart() {

        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {

            startActivityForResult(intent, REQUEST_VIDEO_CAPTURE); // Kamera Uygulamasından bir intent nesnesi almamızı sağlayacak


        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_VIDEO_CAPTURE) {

                Uri videoUri = data.getData();
                Log.i("Video Uri", "" + videoUri);
                videoView.setVideoURI(videoUri);
                videoView.start();

            }


        }

    }
}
