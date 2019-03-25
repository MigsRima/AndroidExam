package com.example.manny.alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class highscore extends AppCompatActivity {

    MainActivity score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        setScore();
        setScore2();
    }
    public void openBeta(View view){
        Intent intt=new Intent (this, Beta.class);
        startActivity(intt);
    }

    public void setScore(){
        Intent intent = getIntent();
        int number = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);
        int hnum = new Score_Tracking().getHScore();

        TextView textView1 = findViewById(R.id.offscore);
        textView1.setText(""+number);
        TextView tv2 = findViewById(R.id.higscore);
        tv2.setText(""+hnum);
    }

    public void setScore2(){
        Score_Tracking score = new Score_Tracking();
        TextView textView1 = findViewById(R.id.higscore);
        TextView textView2 = findViewById(R.id.offscore);
        int a = Integer.parseInt(textView2.getText().toString());
        int b = Integer.parseInt(textView1.getText().toString());
        if(a>b){
            b=a;
        }
        b = new Score_Tracking().getHScore();
        textView1.setText(""+b);
    }

   public void onBackPressed(){
       Toast.makeText(highscore.this, null, Toast.LENGTH_LONG);
   }
}
