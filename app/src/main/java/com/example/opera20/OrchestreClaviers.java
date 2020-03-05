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

public class OrchestreClaviers extends AppCompatActivity {

    private TextView m_play_celesta;
    private TextView m_info_celesta;
    private TextView m_play_piano;
    private TextView m_info_piano;


    private TextView m_view_backtohomepage;

    MediaPlayer player;

    private WebView webview;
    AlertDialog.Builder builder=null;

    int m_intPageCharge = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orchestre_claviers);

        webview=findViewById(R.id.webview);
        m_view_backtohomepage=findViewById(R.id.backtohomepage);
        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage = new Intent(OrchestreClaviers.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                OrchestreClaviers.this.finish();
            }
        });

        m_play_celesta=findViewById(R.id.play_celesta);
        m_play_celesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreClaviers.this, R.raw.celesta);
                player.start();
            }
        });
        m_info_celesta=findViewById(R.id.info_celesta);
        m_info_celesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestreClaviers.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/C%C3%A9lesta");

            }
        });

        m_play_piano =findViewById(R.id.play_piano);
        m_play_piano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreClaviers.this, R.raw.piano);
                player.start();
            }
        });
        m_info_piano=findViewById(R.id.info_piano);
        m_info_piano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestreClaviers.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Piano");

            }
        });


        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m_intPageCharge == 0){
                    Intent HomePage = new Intent(OrchestreClaviers.this, HomePage.class);
                    startActivity(HomePage);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                    OrchestreClaviers.this.finish();
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
                Intent HomePage = new Intent(OrchestreClaviers.this, Lorchestre.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                OrchestreClaviers.this.finish();
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
