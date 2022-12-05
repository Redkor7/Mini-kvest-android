package com.example.mini_kvest_android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView health, thirsty, humanity, storyTell;

    public static Character manager;

    public static boolean isEnd = false;
    ImageView imageView;

    Button button, button2;

    public int i = 0;

    int red = Color.parseColor("#9370DB");

    public static Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        health = findViewById(R.id.textViewHp);
        thirsty = findViewById(R.id.textViewTh);
        humanity = findViewById(R.id.textViewHu);
        storyTell = findViewById(R.id.textViewStory);
        imageView = findViewById(R.id.imageView);
        button2 = findViewById(R.id.button2);
        button2.setEnabled(false);

        manager = new Character();
        story = new Story();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEnd != true && i != 4) {
                    button.setText("Продолжить");
                    button.setEnabled(false);
                    Start();
                    i++;
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager = new Character();
                story = new Story();
                i = 0;
                isEnd = false;
                button.setText("Начать");
                button.setEnabled(true);
                imageView.setImageResource(View.NOT_FOCUSABLE);
                health.setText("Здоровье: 0");
                thirsty.setText("\tЖажда: 0" + "%");
                humanity.setText("\tЧеловечность: 0" + "%");
                storyTell.setText("");
                button2.setEnabled(false);

            }
        });
    }


    public void Start() {

        imageView.setImageResource(R.drawable.islnd);

        health.setText("Здоровье:" + manager.H);
        thirsty.setText("\tЖажда:" + manager.T + "%");
        humanity.setText("\tЧеловечность:" + manager.Hu + "%");

        storyTell.setText(story.situations[i].text);

        for (int k = 0; k < story.situations[i].direction.length; k++) {
            Button b = new Button(this);
            Space s = new Space(this);
            s.setMinimumWidth(10);
            b.setText(Integer.toString(k + 1));
            final int buttonId = k;
            b.setBackgroundColor(red);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    health.setText("Здоровье:" + (manager.H += story.situations[i - 1].direction[buttonId].dH));
                    thirsty.setText("\tЖажда:" + (manager.T += story.situations[i - 1].direction[buttonId].dT) + "%");
                    humanity.setText("\tЧеловечность:" + (manager.Hu += story.situations[i - 1].direction[buttonId].dHu) + "%");
                    storyTell.setText(story.situations[i - 1].direction[buttonId].text);
                    ((LinearLayout) findViewById(R.id.layout)).removeAllViews();

                    if (manager.H <= 0 || i == 4) {
                        isEnd = true;
                        button.setText("Конец");
                        button2.setEnabled(true);
                    }
                    button.setEnabled(true);

                }
            });
            ((LinearLayout) findViewById(R.id.layout)).addView(b);
            ((LinearLayout) findViewById(R.id.layout)).addView(s);
        }
    }
}

