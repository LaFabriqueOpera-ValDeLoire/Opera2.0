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
import android.widget.TextView;

public class OrchestreCuivres extends AppCompatActivity {

    private TextView m_play_cors;
    private TextView m_info_cors;
    private TextView m_play_trompette;
    private TextView m_info_trompette;
    private TextView m_play_trombonne;
    private TextView m_info_trombonne;
    private TextView m_play_tuba;
    private TextView m_info_tuba;

    private TextView m_view_backtohomepage;

    MediaPlayer player;


    private WebView webview;
    AlertDialog.Builder builder=null;

    int m_intPageCharge = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orchestre_cuivres);

        webview=findViewById(R.id.webview);
        m_view_backtohomepage=findViewById(R.id.backtohomepage);
        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage = new Intent(OrchestreCuivres.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                OrchestreCuivres.this.finish();
            }
        });

        m_play_cors=findViewById(R.id.play_cors);
        m_play_cors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreCuivres.this, R.raw.cors);
                player.start();
            }
        });
        m_info_cors=findViewById(R.id.info_cors);
        m_info_cors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestreCuivres.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Cor_(musique)");

            }
        });

        m_play_trompette=findViewById(R.id.play_trompette);
        m_play_trompette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreCuivres.this, R.raw.trompette);
                player.start();
            }
        });
        m_info_trompette=findViewById(R.id.info_trompette);
        m_info_trompette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestreCuivres.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Trompette");

            }
        });

        m_play_trombonne=findViewById(R.id.play_trombonne);
        m_play_trombonne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreCuivres.this, R.raw.trombone);
                player.start();
            }
        });
        m_info_trombonne=findViewById(R.id.info_trombonne);
        m_info_trombonne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestreCuivres.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Trombone_(instrument)");

            }
        });

        m_play_tuba=findViewById(R.id.play_tuba);
        m_play_tuba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreCuivres.this, R.raw.tuba);
                player.start();
            }
        });
        m_info_tuba=findViewById(R.id.info_tuba);
        m_info_tuba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestreCuivres.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Tuba_(instrument)");

            }
        });

        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m_intPageCharge == 0){
                    Intent HomePage = new Intent(OrchestreCuivres.this, HomePage.class);
                    startActivity(HomePage);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                    OrchestreCuivres.this.finish();
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
                Intent HomePage = new Intent(OrchestreCuivres.this, Lorchestre.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                OrchestreCuivres.this.finish();
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
