package com.example.opera20;

import androidx.appcompat.app.AppCompatActivity;

import android.companion.AssociationRequest;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {



    private TextView m_text_lascene;
    private TextView m_text_coulisses1;
    private TextView m_text_quiz;
    private TextView m_text_billetterie;
    private TextView m_text_actualite;
    private TextView m_text_association;
    private TextView m_text_partenaires;
    private TextView m_text_orchetre;
    private TextView m_text_precedentesproduction;
    private TextView m_text_latechnique;
    private ImageView m_image_backtopageaccueil;

    private AlphaAnimation buttonAnimationClick = new AlphaAnimation(1F, 0.8F);//pour animer le bouton lorsque l'on clique dessus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        m_image_backtopageaccueil=findViewById(R.id.backtopageaccueil);


        m_text_latechnique=findViewById(R.id.textviewlatechnique);
        m_text_latechnique.animate().alpha(1f).setDuration(1000);

        m_text_lascene=findViewById(R.id.textviewlascene);
        m_text_lascene.animate().alpha(1f).setDuration(1500);

        m_text_coulisses1= findViewById(R.id.textviewcoulisses1);
        m_text_coulisses1.animate().alpha(1f).setDuration(1500);

        m_text_quiz=findViewById(R.id.textviewQuiz);
        m_text_quiz.animate().alpha(1f).setDuration(1500);


        m_text_billetterie=findViewById(R.id.textviewbilletterie);
        m_text_billetterie.animate().alpha(1f).setDuration(2000);

        m_text_actualite=findViewById(R.id.textviewactualite);
        m_text_actualite.animate().alpha(1f).setDuration(2000);

        m_text_orchetre=findViewById(R.id.textvieworchetre);
        m_text_orchetre.animate().alpha(1f).setDuration(2000);



        m_text_association=findViewById(R.id.textviewassociation);
        m_text_association.animate().alpha(1f).setDuration(2500);

        m_text_partenaires=findViewById(R.id.textviewpartenaires);
        m_text_partenaires.animate().alpha(1f).setDuration(2500);


        m_text_precedentesproduction=findViewById(R.id.textviewprecedentesproduction);
        m_text_precedentesproduction.animate().alpha(1f).setDuration(2500);




        m_text_lascene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Lascene = new Intent(HomePage.this, Lascene.class);
                startActivity(Lascene);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                HomePage.this.finish();
            }
        });
        m_text_coulisses1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Lescoulisses = new Intent(HomePage.this, Lescoulisses.class);
                startActivity(Lescoulisses);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                HomePage.this.finish();
            }
        });
        m_text_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Lescoulisses = new Intent(HomePage.this, Quiz.class);
                startActivity(Lescoulisses);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                HomePage.this.finish();
            }
        });

        m_text_billetterie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Billetterie = new Intent(HomePage.this, Billetterie.class);
                startActivity(Billetterie);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                HomePage.this.finish();
            }
        });
        m_text_actualite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent ActuOpera = new Intent(HomePage.this, ActuOpera.class);
                startActivity(ActuOpera);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                HomePage.this.finish();
            }
        });

        m_text_association.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Association = new Intent(HomePage.this, Lassociation.class);
                startActivity(Association);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                HomePage.this.finish();
            }
        });

        m_text_partenaires.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Partenaires = new Intent(HomePage.this, NosPartenaires.class);
                startActivity(Partenaires);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                HomePage.this.finish();
            }
        });

        m_text_orchetre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Lorchestre = new Intent(HomePage.this, Lorchestre.class);
                startActivity(Lorchestre);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                HomePage.this.finish();
            }
        });

        m_text_precedentesproduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Lesprecedentsproductions = new Intent(HomePage.this, Lesprecedentesproductions.class);
                startActivity(Lesprecedentsproductions);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                HomePage.this.finish();
            }
        });

        m_text_latechnique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Latechnique = new Intent(HomePage.this, Latechnique.class);
                startActivity(Latechnique);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                HomePage.this.finish();
            }
        });

        m_image_backtopageaccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Latechnique = new Intent(HomePage.this, PageAccueil.class);
                startActivity(Latechnique);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                HomePage.this.finish();
            }
        });





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

    //To destroy the activity if the user clicks on the back button;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent HomePage = new Intent(com.example.opera20.HomePage.this, PageAccueil.class);
            startActivity(HomePage);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            com.example.opera20.HomePage.this.finish();
        }
        return false;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
