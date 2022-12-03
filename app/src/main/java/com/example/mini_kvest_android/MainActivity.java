package com.example.mini_kvest_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView health, thirsty, humanity, storyTell;

    public static Character manager;

    public static boolean isEnd = false;

    public static int variant;
    public static Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button1 = findViewById(R.id.button1);
//        button2 = findViewById(R.id.button2);
//        button3 = findViewById(R.id.button3);
//        button4 = findViewById(R.id.button4);
        health = findViewById(R.id.textViewHp);
        thirsty = findViewById(R.id.textViewTh);
        humanity = findViewById(R.id.textViewHu);
        storyTell = findViewById(R.id.textViewStory);

        manager = new Character();
        story = new Story();
        Start();
    }

    public void Start() {

        health.setText("Здоровье:" + manager.H);
        thirsty.setText("\tЖажда:" + manager.T + "%");
        humanity.setText("\tЧеловечность:" + manager.Hu + "%");

        for (int j = 0; j < 4; j++) {

            if (isEnd == true)
                break;

            storyTell.setText(story.situations[j].text);

            //  variant = 2;

            for (int k = 0; k < story.situations[j].direction.length; k++) {
                Button b = new Button(this);
                b.setText(Integer.toString(k + 1));
                final int buttonId = k;
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        health.setText("Здоровье:" + (manager.H += story.situations[j].direction[buttonId].dH));
                        thirsty.setText("\tЖажда:" + (manager.T += story.situations[j].direction[buttonId].dT) + "%");
                        humanity.setText("\tЧеловечность:" + (manager.Hu += story.situations[j].direction[buttonId].dHu) + "%");
                        storyTell.setText(story.situations[j].direction[buttonId].text);
                    }
                });


//
//                health.setText("Здоровье:" + (manager.H += story.situations[i].direction[1].dH));
//                thirsty.setText("\tЖажда:" + (manager.T += story.situations[i].direction[1].dT) + "%");
//                humanity.setText("\tЧеловечность:" + (manager.Hu += story.situations[i].direction[1].dHu) + "%");
//                storyTell.setText(story.situations[i].direction[0].text);
//
//                health.setText("Здоровье:" + (manager.H += story.situations[i].direction[2].dH));
//                thirsty.setText("\tЖажда:" + (manager.T += story.situations[i].direction[2].dT) + "%");
//                humanity.setText("\tЧеловечность:" + (manager.Hu += story.situations[i].direction[2].dHu) + "%");
//                storyTell.setText(story.situations[i].direction[2].text);
//
//
//                health.setText("Здоровье:" + (manager.H += story.situations[i].direction[3].dH));
//                thirsty.setText("\tЖажда:" + (manager.T += story.situations[i].direction[3].dT) + "%");
//                humanity.setText("\tЧеловечность:" + (manager.Hu += story.situations[i].direction[3].dHu) + "%");
//                storyTell.setText(story.situations[i].direction[3].text);

                //     manager.H += story.situations[i].direction[variant - 1].dH;
                //     manager.T += story.situations[i].direction[variant - 1].dT;
                //   manager.Hu += story.situations[i].direction[variant - 1].dHu;
                //   System.out.println("=====\nЗдоровье:" + manager.H + "\tЖажда:" + manager.T + "%" + "\tЧеловечность:" + manager.Hu + "%" + "\n=====");
                //   System.out.println(story.situations[i].direction[variant - 1].text);
                if (manager.H <= 0) {
                    storyTell.setText("Вы погибли. Конец.");
                    isEnd = true;
                }
            }
        }
    }
}

