package akdvp.com.kpsstarih2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class kpss2015GKGY extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_sayfasi);

        WebView webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        String pdf = "http://dokuman.osym.gov.tr/pdfdokuman/2015/KPSS/2015KPSS_CS28072015.pdf";
        webview.loadUrl("http://docs.google.com/gview?embedded=true&url=" + pdf);
    }
}
