package com.example.mini_kvest_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4;
    TextView health, thirsty, humanity, storyTell;

    public static Character manager;

    public static boolean isEnd = false;

    public static int variant;
    public static Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        health = findViewById(R.id.textViewHp);
        thirsty = findViewById(R.id.textViewTh);
        humanity = findViewById(R.id.textViewHu);
        storyTell = findViewById(R.id.textViewStory);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Start();
            }
        });

    }

   public void Start() {

        manager = new Character();
        story = new Story();
        int i = 0;

        health.setText("Здоровье:" + manager.H );
        thirsty.setText("\tЖажда:" + manager.T + "%" );
        humanity.setText("\tЧеловечность:" + manager.Hu + "%");

    //    System.out.println("=====\nЗдоровье:" + manager.H + "\tЖажда:" + manager.T + "%" + "\tЧеловечность:" + manager.Hu + "%" + "\n=====");

        for (int j = 0; j < 4; j++) {
            if (isEnd == true)
                break;

            storyTell.setText(story.situations[i].text);
            button1.setText("1");
            button2.setText("2");
            button3.setText("3");
            button4.setText("4");

       //     System.out.println(story.situations[i].text);
              //  variant = 2;
            int finalI = 1;
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       health.setText("Здоровье:" + (manager.H += story.situations[finalI].direction[0].dH));
                       thirsty.setText("\tЖажда:" + (manager.T += story.situations[finalI].direction[0].dT) + "%");
                       humanity.setText("\tЧеловечность:" + (manager.Hu += story.situations[finalI].direction[0].dHu) + "%");
                       storyTell.setText(story.situations[finalI].direction[0].text);

                    }
                });


            button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        health.setText("Здоровье:" + (manager.H += story.situations[finalI].direction[1].dH));
                        thirsty.setText("\tЖажда:" + (manager.T += story.situations[finalI].direction[1].dT) + "%");
                        humanity.setText("\tЧеловечность:" + (manager.Hu += story.situations[finalI].direction[1].dHu) + "%");
                        storyTell.setText(story.situations[finalI].direction[0].text);
                    }
                });

                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        health.setText("Здоровье:" + (manager.H += story.situations[finalI].direction[2].dH));
                        thirsty.setText("\tЖажда:" + (manager.T += story.situations[finalI].direction[2].dT) + "%");
                        humanity.setText("\tЧеловечность:" + (manager.Hu += story.situations[finalI].direction[2].dHu) + "%");
                        storyTell.setText(story.situations[finalI].direction[2].text);
                    }
                });

                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        health.setText("Здоровье:" + (manager.H += story.situations[finalI].direction[3].dH));
                        thirsty.setText("\tЖажда:" + (manager.T += story.situations[finalI].direction[3].dT) + "%");
                        humanity.setText("\tЧеловечность:" + (manager.Hu += story.situations[finalI].direction[3].dHu) + "%");
                        storyTell.setText(story.situations[finalI].direction[3].text);
                    }
                });
           //     manager.H += story.situations[i].direction[variant - 1].dH;
          //     manager.T += story.situations[i].direction[variant - 1].dT;
             //   manager.Hu += story.situations[i].direction[variant - 1].dHu;
             //   System.out.println("=====\nЗдоровье:" + manager.H + "\tЖажда:" + manager.T + "%" + "\tЧеловечность:" + manager.Hu + "%" + "\n=====");
             //   System.out.println(story.situations[i].direction[variant - 1].text);
                if (manager.H <= 0) {
                   storyTell.setText("Вы погибли. Конец.");
                    isEnd = true;
                }
                i++;
            }
        }
}
