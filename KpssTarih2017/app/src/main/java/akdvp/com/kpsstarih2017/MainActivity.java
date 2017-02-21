package akdvp.com.kpsstarih2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button kpss2016 ;
    Button kpss2015 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getControlView();
        setControlViewStart();



    }

    private void getControlView(){


            kpss2016 = (Button) findViewById(R.id.kpss2016);
            kpss2015 = (Button) findViewById(R.id.kpss2015);

    }

    private void setControlViewStart(){


            kpss2016.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this,kpss2016GKGY.class);
                    startActivity(intent);

                }
            });

           kpss2015.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   Intent intent = new Intent(MainActivity.this,kpss2016GKGY.class);
                   startActivity(intent);

               }
           });

    }


}
