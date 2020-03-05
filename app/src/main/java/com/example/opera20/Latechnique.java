package com.example.opera20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class Latechnique extends AppCompatActivity {

    private TextView m_text_lumiere;
    private TextView m_text_son;
    private TextView m_text_machinistes;
    private ImageView m_view_backtohomepage;


    private AlphaAnimation buttonAnimationClick = new AlphaAnimation(1F, 0.8F);//pour animer le bouton lorsque l'on clique dessus;

    private TextView m_text_openingWordPress;
    private WebView webview;
    AlertDialog.Builder builder=null;
    int m_intPageCharge = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latechnique);

        m_text_openingWordPress=findViewById(R.id.textViewOpeningWordPress);
        m_text_openingWordPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_intPageCharge = 1;
                m_text_lumiere.setAlpha(0);
                m_text_son.setAlpha(0);
                m_text_machinistes.setAlpha(0);
                webview.setAlpha(1);
                webview.setWebViewClient(new Latechnique.MyBrowser());
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
                    Intent HomePage = new Intent(Latechnique.this, HomePage.class);
                    startActivity(HomePage);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                    Latechnique.this.finish();
                }
                if(m_intPageCharge == 1){
                    webview.setAlpha(0);
                    m_text_lumiere.setAlpha(1);
                    m_text_son.setAlpha(1);
                    m_text_machinistes.setAlpha(1);
                    m_intPageCharge = 0;
                }
            }
        });

        m_text_lumiere=findViewById(R.id.lumiere);
        m_text_lumiere.animate().alpha(1f).setDuration(500);


        m_text_son=findViewById(R.id.son);
        m_text_son.animate().alpha(1f).setDuration(800);

        m_text_machinistes=findViewById(R.id.machinistes);
        m_text_machinistes.animate().alpha(1f).setDuration(1100);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(m_intPageCharge==0){
                Intent HomePage = new Intent(Latechnique.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                Latechnique.this.finish();
            }
            if(m_intPageCharge==1){
                webview.setAlpha(0);
                m_text_lumiere.setAlpha(1);
                m_text_son.setAlpha(1);
                m_text_machinistes.setAlpha(1);
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
