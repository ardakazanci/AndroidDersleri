package akdvp.com.kpsstarih2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class kpss2016GKGY extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_sayfasi);

        WebView webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        String pdf = "http://dokuman.osym.gov.tr/pdfdokuman/2016/KPSS/2016KPSSGenelYetenekGenelKultur.pdf";
        webview.loadUrl("http://docs.google.com/gview?embedded=true&url=" + pdf);
    }
}
