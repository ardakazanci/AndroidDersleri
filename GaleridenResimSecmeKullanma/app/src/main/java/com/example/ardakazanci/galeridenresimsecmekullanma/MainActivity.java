package com.example.ardakazanci.galeridenresimsecmekullanma;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button selectImageButton;
    ImageView imageView;
    Uri imageUri; // Intent'ten dönecek değerin türü
    static final int SELECT_IMAGE = 13; // Niyetin bizim uygulamamıze cevap vermesini sağlamak için bu sabiti kullandık.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getControlView();
        setClickForView();

    }


    private void getControlView() {

        selectImageButton = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);

    }

    private void setClickForView() {


        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectImage();

            }
        });


    }

    public void selectImage() {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT); // Kullanıcının bir çok içerik çeşidini uygulama içine almasını sağlar.
        intent.setType("image/*"); // Kullanıcı bir çok içerik çeşidini değilde sadece image dosyalarını uygulama içine almasını sağlar.
        if (intent.resolveActivity(getPackageManager()) != null) {

            startActivityForResult(intent, SELECT_IMAGE); // Kullanıcı galeriden resim seçtikten sonra bu seçim uri'de saklanır ve intent oluşur.

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == SELECT_IMAGE && resultCode == RESULT_OK) { // Galerinin çalışması && bizim uygulamamıze cevap vermesi kontrolü
            imageUri = data.getData(); // intent ' ten dönen değer bizim URİ değişkenimize atanıyor. ( Eşleşme olursa )
            imageView.setImageURI(imageUri);

        }

    }
}
