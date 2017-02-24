package com.yaoc.inclassassignment05_yaoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        ArrayList<Food> previousChoices = (ArrayList<Food>) intent.getSerializableExtra("Food Objects");
        String choices = "";
        for(Food choice: previousChoices){
            choices += choice.toString();
        }

        TextView board = (TextView)findViewById(R.id.displayBoard);
        board.setText(choices);

    }
}
