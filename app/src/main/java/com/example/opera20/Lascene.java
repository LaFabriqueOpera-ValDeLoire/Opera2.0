package com.example.opera20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class Lascene extends AppCompatActivity {

    private TextView m_text_leschanteurssolistes;
    private TextView m_text_lechœur;
    private TextView m_text_lesdanseurs;
    private TextView m_text_lesfanfares;
    private TextView m_text_autres;
    private ImageView m_view_backtohomepage;

    private TextView m_text_openingWordPress;
    private WebView webview;
    AlertDialog.Builder builder=null;
    int m_intPageCharge = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lascene);
        m_text_openingWordPress=findViewById(R.id.textViewOpeningWordPress);
        m_text_openingWordPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                m_text_leschanteurssolistes.setAlpha(0);
                m_text_lechœur.setAlpha(0);
                m_text_lesdanseurs.setAlpha(0);
                m_text_lesfanfares.setAlpha(0);
                m_text_autres.setAlpha(0);
                webview.setAlpha(1);
                webview.setWebViewClient(new Lascene.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://orchestre-inattendu.fr/test-1/");

            }
        });
        webview=findViewById(R.id.webview);
        m_view_backtohomepage=findViewById(R.id.backtohomepage);
        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m_intPageCharge == 0){
                    Intent HomePage = new Intent(Lascene.this, HomePage.class);
                    startActivity(HomePage);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                    Lascene.this.finish();
                }
                if(m_intPageCharge == 1){
                    webview.setAlpha(0);
                    m_text_leschanteurssolistes.setAlpha(1);
                    m_text_lechœur.setAlpha(1);
                    m_text_lesdanseurs.setAlpha(1);
                    m_text_lesfanfares.setAlpha(1);
                    m_text_autres.setAlpha(1);
                    m_intPageCharge = 0;
                }
            }
        });

        m_text_leschanteurssolistes=findViewById(R.id.leschanteurssolistes);
        m_text_leschanteurssolistes.animate().alpha(1f).setDuration(500);

        m_text_lechœur=findViewById(R.id.lechœur);
        m_text_lechœur.animate().alpha(1f).setDuration(800);

        m_text_lesdanseurs=findViewById(R.id.lesdanseurs);
        m_text_lesdanseurs.animate().alpha(1f).setDuration(1100);

        m_text_lesfanfares=findViewById(R.id.lesfanfares);
        m_text_lesfanfares.animate().alpha(1f).setDuration(1400);

        m_text_autres=findViewById(R.id.autres);
        m_text_autres.animate().alpha(1f).setDuration(1700);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(m_intPageCharge==0){
                Intent HomePage = new Intent(Lascene.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                Lascene.this.finish();
            }
            if(m_intPageCharge==1){
                webview.setAlpha(0);
                m_text_leschanteurssolistes.setAlpha(1);
                m_text_lechœur.setAlpha(1);
                m_text_lesdanseurs.setAlpha(1);
                m_text_lesfanfares.setAlpha(1);
                m_text_autres.setAlpha(1);
                m_intPageCharge = 0;
            }

        }
        return false;
    }

    private class MyBrowser extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
