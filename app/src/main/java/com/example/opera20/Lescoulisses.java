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

public class Lescoulisses extends AppCompatActivity {


    private TextView m_text_costumes;
    private TextView m_text_maquillages;
    private TextView m_text_coiffures;
    private TextView m_text_realisationdudecor;
    private ImageView m_view_backtohomepage;

    private TextView m_text_openingWordPress;
    private WebView webview;
    AlertDialog.Builder builder=null;
    int m_intPageCharge = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lescoulisses);

        m_text_openingWordPress=findViewById(R.id.textViewOpeningWordPress);
        m_text_openingWordPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                m_text_coiffures.setAlpha(0);
                m_text_costumes.setAlpha(0);
                m_text_maquillages.setAlpha(0);
                m_text_realisationdudecor.setAlpha(0);
                webview.setAlpha(1);
                webview.setWebViewClient(new Lescoulisses.MyBrowser());
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
                    Intent HomePage = new Intent(Lescoulisses.this, HomePage.class);
                    startActivity(HomePage);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                    Lescoulisses.this.finish();
                }
                if(m_intPageCharge == 1){
                    webview.setAlpha(0);
                    m_text_coiffures.setAlpha(1);
                    m_text_costumes.setAlpha(1);
                    m_text_maquillages.setAlpha(1);
                    m_text_realisationdudecor.setAlpha(1);
                    m_intPageCharge = 0;
                }
            }
        });

        m_text_costumes=findViewById(R.id.costumes);
        m_text_costumes.animate().alpha(1f).setDuration(500);

        m_text_maquillages=findViewById(R.id.maquillages);
        m_text_maquillages.animate().alpha(1f).setDuration(800);

        m_text_coiffures=findViewById(R.id.coiffures);
        m_text_coiffures.animate().alpha(1f).setDuration(1100);

        m_text_realisationdudecor=findViewById(R.id.realisationdudecor);
        m_text_realisationdudecor.animate().alpha(1f).setDuration(1400);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(m_intPageCharge==0){
                Intent HomePage = new Intent(Lescoulisses.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                Lescoulisses.this.finish();
            }
            if(m_intPageCharge==1){
                webview.setAlpha(0);
                m_text_coiffures.setAlpha(1);
                m_text_costumes.setAlpha(1);
                m_text_maquillages.setAlpha(1);
                m_text_realisationdudecor.setAlpha(1);
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

