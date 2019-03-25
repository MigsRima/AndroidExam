package com.example.manny.alpha;

import android.widget.Button;
import android.widget.EditText;

public class Score_Tracking {
    int score;
    static int hscore=0;

    Score_Tracking(){
        int x = getHScore();
    }

    public int getScore(){
        return score;
    }

    public void setScore(int s){
        score = s;
    }

    public void setHScore(String hs){
        int blah = Integer.parseInt(hs);
        if(blah>hscore) {
        hscore = blah;
        }
    }

    public int getHScore(){
        //new Score_Tracking().setScore();
        return hscore;
    }

    //@Override



}
