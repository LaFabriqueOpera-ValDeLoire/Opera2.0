package com.example.opera20;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Lesprecedentesproductions extends AppCompatActivity {

    private TextView m_carmen;
    private TextView m_aida;
    private TextView m_flute_enchantee;
    private TextView m_backtohomepage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesprecedentesproductions);

        /*webView=findViewById(R.id.webvideo);
        webView.setWebViewClient(new MyBrowser());
        webView.getSettings().setJavaScriptEnabled(true);
        WebSettings webSettings=webView.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);*/


        /*videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.animate().alpha(0f);
            }
        });*/

        m_backtohomepage=findViewById(R.id.backtohomepage);
        m_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage = new Intent(Lesprecedentesproductions.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                Lesprecedentesproductions.this.finish();
            }
        });

        m_carmen=findViewById(R.id.carmen);
        m_carmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Carmen = new Intent(Lesprecedentesproductions.this, Carmen.class);
                startActivity(Carmen);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                Lesprecedentesproductions.this.finish();
            }
        });

        m_aida=findViewById(R.id.aida);
        m_aida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Aida = new Intent(Lesprecedentesproductions.this, Aida.class);
                startActivity(Aida);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                Lesprecedentesproductions.this.finish();
            }
        });

        m_flute_enchantee=findViewById(R.id.fluteEnchantee);
        m_flute_enchantee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent FluteEnchantee = new Intent(Lesprecedentesproductions.this, FluteEnchantee.class);
                startActivity(FluteEnchantee);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                Lesprecedentesproductions.this.finish();
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent HomePage = new Intent(Lesprecedentesproductions.this, HomePage.class);
            startActivity(HomePage);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            Lesprecedentesproductions.this.finish();
        }
        return false;
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
