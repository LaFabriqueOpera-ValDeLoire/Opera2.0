package com.example.opera20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class OrchestrePercussions extends AppCompatActivity {

    private TextView m_play_timbale;
    private TextView m_info_timbale;
    private TextView m_play_xylophone;
    private TextView m_info_xylophone;
    private TextView m_play_caisse;
    private TextView m_info_caisse;


    private TextView m_view_backtohomepage;

    MediaPlayer player;

    private WebView webview;
    AlertDialog.Builder builder=null;

    int m_intPageCharge = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orchestre_percussions);

        webview=findViewById(R.id.webview);
        m_view_backtohomepage=findViewById(R.id.backtohomepage);
        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage = new Intent(OrchestrePercussions.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                OrchestrePercussions.this.finish();
            }
        });

        m_play_timbale=findViewById(R.id.play_timbale);
        m_play_timbale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestrePercussions.this, R.raw.timbale);
                player.start();
            }
        });
        m_info_timbale=findViewById(R.id.info_timbale);
        m_info_timbale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestrePercussions.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Timbales_(musique_classique)");

            }
        });

        m_play_xylophone =findViewById(R.id.play_xylophone);
        m_play_xylophone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestrePercussions.this, R.raw.xylophone);
                player.start();
            }
        });
        m_info_xylophone=findViewById(R.id.info_xylophone);
        m_info_xylophone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestrePercussions.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Xylophone");

            }
        });

        m_play_caisse =findViewById(R.id.play_caisse);
        m_play_caisse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player=null;
                player= MediaPlayer.create(OrchestrePercussions.this, R.raw.grosse_caisse);
                player.start();
            }
        });
        m_info_caisse=findViewById(R.id.info_caisse);
        m_info_caisse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                webview.setAlpha(1);
                webview.setWebViewClient(new OrchestrePercussions.MyBrowser());
                WebSettings webSettings=webview.getSettings();
                webview.requestFocus();
                webSettings.setLightTouchEnabled(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setGeolocationEnabled(true);
                webview.setSoundEffectsEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webview.loadUrl("https://fr.wikipedia.org/wiki/Grosse_caisse");

            }
        });


        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m_intPageCharge == 0){
                    Intent HomePage = new Intent(OrchestrePercussions.this, HomePage.class);
                    startActivity(HomePage);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                    OrchestrePercussions.this.finish();
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
                Intent HomePage = new Intent(OrchestrePercussions.this, Lorchestre.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                OrchestrePercussions.this.finish();
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
