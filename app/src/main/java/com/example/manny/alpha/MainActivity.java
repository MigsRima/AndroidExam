package com.example.manny.alpha;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView countdownText;
    private Button countdownButton ;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 60000;
    private boolean timerRunning;
    int a = 0;
    int b = 0;
    int c = 0;
    int sc = 1;
    private EditText ansedit;
    private Button disablebutton;
    Random ran = new Random();
    public static final String EXTRA_NUMBER = "com.example.application.example.EXTRA_NUMBER";

    public void checker(int x, int y, int z) {
        TextView set3 = findViewById(R.id.space3);
        EditText set4= findViewById(R.id.ans);
        //int iw =Integer.parseInt(set4.getText().toString());
        String sw = set4.getText().toString();
        //Toast.makeText(MainActivity.this,"Correct", Toast.LENGTH_LONG).show();
        if(sw.trim().length()==0){
            Toast.makeText(MainActivity.this,"Wrong", Toast.LENGTH_LONG).show();
        }else{
            if(z==(x+y)){
                int w = Integer.parseInt(set3.getText().toString());
                w++;
                set3.setText(Integer.toString(w));
            }
        }
        set4.setText("");
    }


    public void pass (View view) {
        startTimer();
        EditText inp = findViewById(R.id.ans);
        c = Integer.parseInt(inp.getText().toString());
        checker(a, b, c);
        a = ran.nextInt(50);
        b = ran.nextInt(50);
        TextView set1 = findViewById(R.id.text1);
        set1.setText(Integer.toString(a));
        TextView set2 = findViewById(R.id.text2);
        set2.setText(Integer.toString(b));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beta);
        ansedit = findViewById(R.id.ans);
        disablebutton = findViewById(R.id.countdown_button);
        countdownText = findViewById(R.id.countdown_text);
        ansedit.addTextChangedListener(edit);
        countdownButton = findViewById(R.id.countdown_button);
                startTimer();
        }

        private TextWatcher edit = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String values = ansedit.getText().toString().trim();
                disablebutton.setEnabled(!values.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        public void startStop(){
            if (timerRunning){
                stopTimer();
            } else {
                startTimer();
            }
        }
    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                setter();
                openHs();
            }
        }.start();
        timerRunning = true;
    }

    public void updateTimer(){
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "";
        timeLeftText = "";
        if (seconds < 10) timeLeftText +="0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);
    }
    public void openHs(){
        Intent intent=new Intent (this, highscore.class);
        TextView sco = findViewById(R.id.space3);
        sc = Integer.parseInt(sco.getText().toString());
        intent.putExtra(EXTRA_NUMBER,sc);
        startActivity(intent);

    }

    public void setter(){
        TextView sco2 = findViewById(R.id.space3);
        String sc2 = sco2.getText().toString();
        Score_Tracking yo = new Score_Tracking();
        yo.setHScore(sc2);
    }
    public void stopTimer(){
           startTimer();
    }
}