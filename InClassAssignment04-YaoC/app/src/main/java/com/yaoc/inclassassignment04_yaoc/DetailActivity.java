package com.yaoc.inclassassignment04_yaoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent detailIntent = getIntent();
        String name = detailIntent.getStringExtra("name");
        String gender = detailIntent.getStringExtra("gender");
        String emotion = detailIntent.getStringExtra("emotion");
        Log.d("DetailActivity : ", name + " " + gender + " " + emotion);

        TextView nameView = (TextView) findViewById(R.id.nameView);
        nameView.setText(name);

        generateAvatar(gender, emotion);
    }

    public void generateAvatar(String gender, String emotion) {
        ImageView avatar = (ImageView) findViewById(R.id.imageView);
        TextView comment = (TextView) findViewById(R.id.comment);
        if (gender.equals("male")) {
            if (emotion.equals("happy")) {
                avatar.setImageResource(R.drawable.malehappy);
                comment.setText("You are a happy male!!!");
            } else if (emotion.equals("sad")) {
                avatar.setImageResource(R.drawable.malesad);
                comment.setText("You are a sad male!!!");
            } else {
                avatar.setImageResource(R.drawable.maleangry);
                comment.setText("You are an angry male!!!");
            }
        }else if (gender.equals("female")){
            if (emotion.equals("happy")) {
                avatar.setImageResource(R.drawable.femalehappy);
                comment.setText("You are a happy female!!!");
            }  else if (emotion.equals("sad")) {
                avatar.setImageResource(R.drawable.femalesad);
                comment.setText("You are a sad female!!!");
            } else {
                avatar.setImageResource(R.drawable.femaleangry);
                comment.setText("You are an angry female!!!");
            }
        }
    }


}
