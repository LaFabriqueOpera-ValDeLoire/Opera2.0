package com.example.opera20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class Lorchestre extends AppCompatActivity {

    private TextView m_text_cordes;
    private TextView m_text_ventbois;
    private TextView m_text_cuivres;
    private TextView m_text_claviers;
    private TextView m_text_percussions;
    private ImageView m_view_backtohomepage;

    private AlphaAnimation buttonAnimationClick = new AlphaAnimation(1F, 0.8F);//pour animer le bouton lorsque l'on clique dessus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lorchestre);

        m_view_backtohomepage=findViewById(R.id.backtohomepage);
        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage = new Intent(Lorchestre.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                Lorchestre.this.finish();
            }
        });

        m_text_cordes=findViewById(R.id.cordes);
        m_text_cordes.animate().alpha(1f).setDuration(1000);
        m_text_cordes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Cordes = new Intent(Lorchestre.this, OrchestreCordes.class);
                startActivity(Cordes);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                Lorchestre.this.finish();
            }
        });

        m_text_ventbois=findViewById(R.id.ventbois);
        m_text_ventbois.animate().alpha(1f).setDuration(1000);
        m_text_ventbois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent VentBois = new Intent(Lorchestre.this, OrchestreVentBois.class);
                startActivity(VentBois);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                Lorchestre.this.finish();
            }
        });

        m_text_cuivres=findViewById(R.id.cuivres);
        m_text_cuivres.animate().alpha(1f).setDuration(1000);
        m_text_cuivres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Cuivres = new Intent(Lorchestre.this, OrchestreCuivres.class);
                startActivity(Cuivres);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                Lorchestre.this.finish();
            }
        });

        m_text_claviers=findViewById(R.id.claviers);
        m_text_claviers.animate().alpha(1f).setDuration(1000);
        m_text_claviers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Claviers = new Intent(Lorchestre.this, OrchestreClaviers.class);
                startActivity(Claviers);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                Lorchestre.this.finish();
            }
        });

        m_text_percussions=findViewById(R.id.percussions);
        m_text_percussions.animate().alpha(1f).setDuration(1000);
        m_text_percussions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Percussions = new Intent(Lorchestre.this, OrchestrePercussions.class);
                startActivity(Percussions);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                Lorchestre.this.finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent HomePage = new Intent(Lorchestre.this, HomePage.class);
            startActivity(HomePage);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            Lorchestre.this.finish();
        }
        return false;
    }
}
