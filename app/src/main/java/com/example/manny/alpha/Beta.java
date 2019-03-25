package com.example.manny.alpha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Beta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frontpage);

        Button button = findViewById(R.id.startbut);
         button.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view) {
                 openBeta();
             }
         });

        Button button1 = findViewById(R.id.highscorebut);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openHs();
            }
        });

        Button button3 = findViewById(R.id.abdevbut);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                opendevinfo();
            }
        });
    }
    public void openBeta(){
        Intent intent=new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void openHs(){
        Intent intent=new Intent (this, highscore.class);
        startActivity(intent);
    }

    public void opendevinfo(){
        Intent intent=new Intent (this, abdev.class);
        startActivity(intent);
    }

}
