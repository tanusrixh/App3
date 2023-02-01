package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.core.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    Button instructions;

    //body part images
    private ImageView[] bodyParts;
    private int numParts=6;
    private int currPart;
    private int numChars;
    private int numCorr;

    private String[] words;
    private Random rand;
    private String currWord;
    private LinearLayout wordLayout;
    private TextView[] charViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Resources res = getResources();
        words = res.getStringArray(R.array.words);
        rand = new Random();
        currWord ="";
        wordLayout = findViewById(R.id.answerDisp);
        instructions = findViewById(R.id.refresher);

        instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewInst = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(viewInst);
            }
        });

        bodyParts = new ImageView[numParts];
    }

    private void test(View view){
        String newWord = words[rand.nextInt(words.length)];
        while(newWord.equals(currWord)) newWord = words[rand.nextInt(words.length)];
        currWord = newWord;
        charViews = new TextView[currWord.length()];
        wordLayout.removeAllViews();

        for (int c = 0; c < currWord.length(); c++) {
            charViews[c] = new TextView(this);
            charViews[c].setText(""+currWord.charAt(c));
        }


        System.out.println("hello");
    }




}