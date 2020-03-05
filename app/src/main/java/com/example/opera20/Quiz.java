package com.example.opera20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    private TextView textview;
    private ImageView m_view_backtohomepage;
    private Button button_answer1;
    private Button button_answer2;
    private Button button_answer3;
    private Button button_answer4;

    int m_score;

    private AlphaAnimation buttonAnimationClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        textview = (TextView) findViewById(R.id.question_text);
        m_view_backtohomepage=findViewById(R.id.mbacktohomepage);
        button_answer1 = (Button) findViewById(R.id.answer1);
        button_answer2 = (Button) findViewById(R.id.answer2);
        button_answer3 = (Button) findViewById(R.id.answer3);
        button_answer4 = (Button) findViewById(R.id.answer4);

        m_view_backtohomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage = new Intent(Quiz.this, HomePage.class);
                startActivity(HomePage);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                Quiz.this.finish();
            }
        });

        parseXML();
    }

    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = getAssets().open("questions_quiz_opera.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);
            processParsing(parser);
        } catch (XmlPullParserException e) {
        } catch (IOException e) {
        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        ArrayList<Question_quiz> questions_quiz = new ArrayList<>();
        int eventType=parser.getEventType();
        Question_quiz currentQuestion=null;

        //Toast.makeText(this, "test", Toast.LENGTH_LONG).show();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String eltName = null;
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();
                    if("question".equals(eltName)){
                        currentQuestion = new Question_quiz();
                        questions_quiz.add(currentQuestion);
                    } else if(currentQuestion!=null){
                        if("nom".equals(eltName)){
                            currentQuestion.name=parser.nextText();
                        } else if("cas1".equals(eltName)){
                            currentQuestion.cas1=parser.nextText();
                        } else if("cas2".equals(eltName)){
                            currentQuestion.cas2=parser.nextText();
                        } else if("cas3".equals(eltName)){
                            currentQuestion.cas3=parser.nextText();
                        } else if("cas4".equals(eltName)){
                            currentQuestion.cas4=parser.nextText();
                        } else if("solution".equals(eltName)){
                            currentQuestion.solution=parser.nextText();
                        }
                    }
                    break;
            }
            eventType=parser.next();
        }
        choix_aleatoire_questions(questions_quiz);
    }

    private void choix_aleatoire_questions(ArrayList<Question_quiz> questions_quiz) {
        int tailleListeQuestions = questions_quiz.size();
        Random r = new Random();
        int valeur = 0 + r.nextInt(tailleListeQuestions - 0);

        final Question_quiz question = questions_quiz.get(valeur);

        textview.setText(question.name);
        button_answer1.setText(question.cas1);
        button_answer2.setText(question.cas2);
        button_answer3.setText(question.cas3);
        button_answer4.setText(question.cas4);

        //final int red = Color.parseColor("#B00E27");
        //final int green = Color.parseColor("#46B108");

        button_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question.cas1 == question.solution){
                    button_answer1.setBackgroundResource(R.drawable.custom_button_quiz_succes);
                    v.startAnimation(buttonAnimationClick);
                    Intent NewActivity = new Intent(Quiz.this, Quiz.class);
                    NewActivity.putExtra("score", m_score);
                    startActivity(NewActivity);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    Quiz.this.finish();
                }else{
                    v.startAnimation(buttonAnimationClick);
                    button_answer1.setBackgroundResource(R.drawable.custom_button_quiz_echec);
                }
            }
        });

        button_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question.cas2 == question.solution){
                    button_answer2.setBackgroundResource(R.drawable.custom_button_quiz_succes);
                    v.startAnimation(buttonAnimationClick);
                    Intent NewActivity = new Intent(Quiz.this, Quiz.class);
                    startActivity(NewActivity);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    Quiz.this.finish();
                }else{
                    v.startAnimation(buttonAnimationClick);
                    button_answer2.setBackgroundResource(R.drawable.custom_button_quiz_echec);
                }
            }
        });

        button_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question.cas3 == question.solution){
                    button_answer3.setBackgroundResource(R.drawable.custom_button_quiz_succes);
                    v.startAnimation(buttonAnimationClick);
                    Intent NewActivity = new Intent(Quiz.this, Quiz.class);
                    startActivity(NewActivity);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    Quiz.this.finish();
                }else{
                    v.startAnimation(buttonAnimationClick);
                    button_answer3.setBackgroundResource(R.drawable.custom_button_quiz_echec);
                }
            }
        });

        button_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question.cas4 == question.solution){
                    button_answer4.setBackgroundResource(R.drawable.custom_button_quiz_succes);
                    v.startAnimation(buttonAnimationClick);
                    Intent NewActivity = new Intent(Quiz.this, Quiz.class);
                    startActivity(NewActivity);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    Quiz.this.finish();
                }else{
                    v.startAnimation(buttonAnimationClick);
                    button_answer4.setBackgroundResource(R.drawable.custom_button_quiz_echec);
                }
            }
        });
//        StringBuilder builder = new StringBuilder();
////
////        for(Question_quiz question : questions_quiz){
////            builder.append(question.name).append("\n");
////        }
////
////        textview.setText(builder.toString());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent HomePage = new Intent(Quiz.this, HomePage.class);
            startActivity(HomePage);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            Quiz.this.finish();
        }
        return false;
    }

}
