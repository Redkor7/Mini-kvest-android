package com.example.mini_kvest_android;

public class Situation {
    Situation[] direction;
    String text;
    int dH,dT,dHu, variants;
    public Situation (String text, int variants, int dh,int dt,int dhu) {
        this.text=text;
        this.variants = variants;
        dH=dh;
        dT=dt;
        dHu=dhu;
        direction=new Situation[variants];
    }
}