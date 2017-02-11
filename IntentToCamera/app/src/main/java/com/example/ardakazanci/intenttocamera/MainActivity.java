package com.example.ardakazanci.intenttocamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    static final int IMAGE_CAPTURE = 1453;
    // Kamera ile resim çekilden sonra , kamera uygulaması bize bir intent gönderecektir. Hangi intent nesnesine cevap verdiğini belirlemek için kullanıldı.
    Button btn;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControlView();
        setClickForView();


    }


    private void getControlView() {

        btn = (Button) findViewById(R.id.btn);
        imageView = (ImageView) findViewById(R.id.imageView);

    }

    private void setClickForView() {

        btn.setOnClickListener(new View.OnClickListener() { // Olay dinleyicisi - Butona tıklanma olayı.
            @Override
            public void onClick(View v) {
                takeImage(); // Butona tıklanınca takeImage metotu etkinleşir.
            }
        });


    }

    private void takeImage() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // Kameradan resim almak için

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            startActivityForResult(takePictureIntent, IMAGE_CAPTURE); // Bu metod hem kamera uygulamasını başlatacak , hemde kamera uygulamasından intent alacak.

        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) { // Kamera uygulamasından gelen resmi almak için onActivirt result kullanılır.
            // Kısaca kamera uygulaması başlar ve resim çekildikten sonra bu metoda gönderilir. ( Gelen intent )

        if (resultCode == RESULT_OK) { // Kamera uygulaması düzgün çalışıp çalışmıyor mu ?

            if (requestCode == IMAGE_CAPTURE) { // Gönderilen intent hangi intent nesnesine cevap vermiş kontrol amaçlıdır.
                        // Eğer IMAGE_CAPTURE olarak değer dönerse kamera uygulaması bizim intent nesnemize cevap vermiş olacaktır.

                Bundle extras = data.getExtras(); // Resim extra verisi içinde
                Bitmap imageBitmap = (Bitmap) extras.get("data"); // Bitmap formatında alınır. Gelen resim verisine erişmek için data string ifadesi kullanılır.
                    // Bu data bir key yani anahtardır.
                imageView.setImageBitmap(imageBitmap); // gelen resim imageView ' e uygulanır.

            }

        }
    }

}

