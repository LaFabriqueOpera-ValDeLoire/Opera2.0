package com.example.opera20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class PageAccueil extends AppCompatActivity {

    /*private Button m_button_entrer;
    private Button m_button_special_event;*/

    private AlphaAnimation buttonAnimationClick = new AlphaAnimation(1F, 0.8F);//pour animer le bouton lorsque l'on clique dessus;

    //VideoView m_videoview;
    private ImageView m_image_filtre;
    TextView opera;
    Button qrcode;
    int m_waitVariable=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_accueil);

        //Gestion de la vidéo d'ouverture pour faire un effet ouverture rideau;
        /*m_videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ouverture_rideau_v2);
        m_videoview.setVideoURI(uri);
        m_videoview.start();
        m_waitVariable=1;//on utilise cette variable car on veut dans un 1er temps afficher uniquement la vidéo puis après les boutons;*/

        opera=findViewById(R.id.opera);
        opera.animate().alpha(1f).setDuration(500);


        qrcode=findViewById(R.id.qrcode);

        m_image_filtre=findViewById(R.id.filtre);
        m_image_filtre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent filtre = new Intent(PageAccueil.this, FaceFilterActivity.class);
                startActivity(filtre);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                PageAccueil.this.finish();
            }
        });



        opera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent HomePage = new Intent(PageAccueil.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                PageAccueil.this.finish();
            }

        });

        qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator=new IntentIntegrator(PageAccueil.this);
                intentIntegrator.initiateScan();
            }
        });

       /* m_button_entrer=(Button) findViewById(R.id.buttonEntrer);
        m_button_special_event=(Button) findViewById(R.id.buttonSpecialEvent);//findview sert à faire la jonction entre le graphisme et le code;*/

        /*m_button_entrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent HomePage = new Intent(PageAccueil.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);//transition entre les fenêtres;
                PageAccueil.this.finish();
            }
        });*/

       /* m_button_special_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
            }
        });*/
        //ApparitionDesBoutons(m_waitVariable);
    }

    /*void ApparitionDesBoutons(int waitVariable){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(waitVariable==1){
                    m_videoview.animate().alpha(0f).setDuration(2000);
                    m_videoview.setVisibility(View.INVISIBLE);
                    //m_button_entrer.setVisibility(View.VISIBLE);
                    //m_button_special_event.setVisibility(View.VISIBLE);
                    opera.animate().alpha(1f).setDuration(2000);
                    m_background.animate().alpha(1f).setDuration(2000);

                    //m_videoview.animate().alpha(0f).setDuration(2000);
                    //m_videoview.setVisibility(View.INVISIBLE);

                }
            }
        }, 4000 );//time in milisecond;
    }*/


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

            PageAccueil.this.finish();
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Receive the analyse result.
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "scan annulé", Toast.LENGTH_LONG).show();
            } else {
                //Toast.makeText(this, "scan contenu:" + result.getContents(), Toast.LENGTH_LONG).show();
                if(result.getContents().equals("1"))
                {
                    Intent intent1= new Intent(PageAccueil.this,Lorchestre.class);
                    startActivity(intent1);
                    PageAccueil.this.finish();
                }

                if(result.getContents().equals("2"))
                {
                    Intent intent1= new Intent(PageAccueil.this,Latechnique.class);
                    startActivity(intent1);
                    PageAccueil.this.finish();
                }

                if(result.getContents().equals("3"))
                {
                    Intent intent1= new Intent(PageAccueil.this,Lascene.class);
                    startActivity(intent1);
                    PageAccueil.this.finish();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }



}
