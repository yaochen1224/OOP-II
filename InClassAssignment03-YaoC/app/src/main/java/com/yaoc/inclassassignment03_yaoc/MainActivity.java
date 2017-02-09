package com.yaoc.inclassassignment03_yaoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String text = "";
    TextView boardTextView;
    String boardText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardTextView = (TextView) findViewById(R.id.board);
        boardText = boardTextView.getText().toString();
    }


    public void displayText(String text){
        TextView displayTextView = (TextView) findViewById(R.id.field);
        displayTextView.setText(text);
    }

    public void copy(View view){
        text = boardText;
        displayText(text);
    }

    public void doubleText(View view){
        text = " "+text + " "+text;
        displayText(text);
    }


}
