package com.example.opera20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class OrchestreVentBois extends AppCompatActivity {

    private TextView m_play_flute;
    private TextView m_info_flute;
    private TextView m_play_clarinette;
    private TextView m_info_clarinette;
    private TextView m_play_hautbois;
    private TextView m_info_hautbois;
    private TextView m_play_bassons;
    private TextView m_info_bassons;

    private TextView m_view_backtohomepage;

    MediaPlayer player;

    private WebView webview;
    AlertDialog.Builder builder=null;

    int m_intPageCharge = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orchestre_vent_bois);

        webview=findViewById(R.id.webview);
        m_view_backtohomepage=findViewById(R.id.backtohomepage);
        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage = new Intent(OrchestreVentBois.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                OrchestreVentBois.this.finish();
            }
        });

        m_play_flute=findViewById(R.id.play_flute);
        m_play_flute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreVentBois.this, R.raw.flute);
                player.start();
            }
        });
        m_info_flute=findViewById(R.id.info_flute);
        m_info_flute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Fl%C3%BBte");

            }
        });

        m_play_clarinette=findViewById(R.id.play_clarinette);
        m_play_clarinette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreVentBois.this, R.raw.clarinette);
                player.start();
            }
        });
        m_info_clarinette=findViewById(R.id.info_clarinette);
        m_info_clarinette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Clarinette");

            }
        });

        m_play_hautbois=findViewById(R.id.play_hautbois);
        m_play_hautbois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreVentBois.this, R.raw.hautbois);
                player.start();
            }
        });
        m_info_hautbois=findViewById(R.id.info_hautbois);
        m_info_hautbois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Hautbois");

            }
        });

        m_play_bassons=findViewById(R.id.play_bassons);
        m_play_bassons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreVentBois.this, R.raw.basson);
                player.start();
            }
        });
        m_info_bassons=findViewById(R.id.info_bassons);
        m_info_bassons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Basson");

            }
        });

        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m_intPageCharge == 0){
                    Intent HomePage = new Intent(OrchestreVentBois.this, HomePage.class);
                    startActivity(HomePage);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                    OrchestreVentBois.this.finish();
                }
                if(m_intPageCharge == 1){
                    webview.setAlpha(0);
                    m_intPageCharge = 0;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        stopMusic();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopMusic();
    }


    public void stopMusic(){
        if(player!=null){
            player.release();
            player=null;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(m_intPageCharge==0){
                Intent HomePage = new Intent(OrchestreVentBois.this, Lorchestre.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                OrchestreVentBois.this.finish();
            }
            if(m_intPageCharge==1){
                webview.setAlpha(0);
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
