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

public class OrchestreCordes extends AppCompatActivity {

    private TextView m_play_violon;
    private TextView m_info_violon;
    private TextView m_play_harpe;
    private TextView m_info_harpe;
    private TextView m_play_alto;
    private TextView m_info_alto;
    private TextView m_play_violoncelle;
    private TextView m_info_violoncelle;
    private TextView m_play_contrebasse;
    private TextView m_info_contrebasse;

    private TextView m_view_backtohomepage;

    MediaPlayer player;

    private WebView webview;
    AlertDialog.Builder builder=null;

    int m_intPageCharge = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orchestre_cordes);

        webview=findViewById(R.id.webview);
        m_view_backtohomepage=findViewById(R.id.backtohomepage);
        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage = new Intent(OrchestreCordes.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                OrchestreCordes.this.finish();
            }
        });

        m_play_violon=findViewById(R.id.play_violon);
        m_play_violon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreCordes.this, R.raw.violon);
                player.start();
            }
        });
        m_info_violon=findViewById(R.id.info_violon);
        m_info_violon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestreCordes.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Violon");

            }
        });

        m_play_alto =findViewById(R.id.play_alto);
        m_play_alto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreCordes.this, R.raw.alto);
                player.start();
            }
        });
        m_info_alto=findViewById(R.id.info_alto);
        m_info_alto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestreCordes.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Alto_(instrument_%C3%A0_cordes)");

            }
        });

        m_play_harpe=findViewById(R.id.play_harpe);
        m_play_harpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreCordes.this, R.raw.harpe);
                player.start();
            }
        });
        m_info_harpe=findViewById(R.id.info_harpe);
        m_info_harpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestreCordes.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Harpe");

            }
        });

        m_play_violoncelle=findViewById(R.id.play_violoncelle);
        m_play_violoncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreCordes.this, R.raw.violoncelle);
                player.start();
            }
        });
        m_info_violoncelle=findViewById(R.id.info_violoncelle);
        m_info_violoncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestreCordes.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Violoncelle");

            }
        });

        m_play_contrebasse=findViewById(R.id.play_contrebasse);
        m_play_contrebasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestreCordes.this, R.raw.contrebasse);
                player.start();
            }
        });
        m_info_contrebasse=findViewById(R.id.info_contrebasse);
        m_info_contrebasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestreCordes.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Contrebasse");

            }
        });


        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m_intPageCharge == 0){
                    Intent HomePage = new Intent(OrchestreCordes.this, HomePage.class);
                    startActivity(HomePage);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                    OrchestreCordes.this.finish();
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
                Intent HomePage = new Intent(OrchestreCordes.this, Lorchestre.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                OrchestreCordes.this.finish();
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
