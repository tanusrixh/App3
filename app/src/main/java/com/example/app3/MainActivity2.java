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
    private ImageView[] strikes;
    private int guesses=6;
    private int currentBP;
    private int numChars;
    private int numCorr;

    private String[] words;
    private Random randomWord;
    private String currentWord;
    private LinearLayout wordLayout;
    private TextView[] seeLetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Resources res = getResources();
        words = res.getStringArray(R.array.words);
        randomWord = new Random();
        currentWord ="";
        wordLayout = findViewById(R.id.answerDisp);
        instructions = findViewById(R.id.refresher);

        instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewInst = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(viewInst);
            }
        });

        strikes = new ImageView[guesses];
    }

    private void test(View view){
        String newWord = words[randomWord.nextInt(words.length)];
        while(newWord.equals(currentWord)) newWord = words[randomWord.nextInt(words.length)];
        currentWord = newWord;
        seeLetter = new TextView[currentWord.length()];
        wordLayout.removeAllViews();

        for (int i = 0; i < currentWord.length(); i++) {
            seeLetter[i] = new TextView(this);
            seeLetter[i].setText(currentWord.charAt(i));
        }


        System.out.println("hello");
    }




}