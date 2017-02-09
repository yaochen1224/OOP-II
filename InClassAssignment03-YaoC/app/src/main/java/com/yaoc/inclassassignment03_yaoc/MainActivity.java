package com.yaoc.inclassassignment03_yaoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.yaoc.inclassassignment03_yaoc.R.id.field;

public class MainActivity extends AppCompatActivity {


    String text = "";
    EditText boardTextView;
    TextView fieldTextView;
    int textSize = 12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardTextView = (EditText) findViewById(R.id.board);
        fieldTextView = (TextView) findViewById(R.id.field);
        showToast();
    }

    public void showToast() {
        Toast t = Toast.makeText(this, "This is a Toast Message", Toast.LENGTH_SHORT);
        t.show();
    }

    public void displayText(String text){
        fieldTextView.setText(text);
    }

    public void copy(View view){
        text = boardTextView.getText().toString();
        displayText(text);
    }

    public void doubleText(View view){
        text = " "+text + " "+text;
        displayText(text);
    }

    public void upCase(View view){
        textSize += 2;
        fieldTextView.setTextSize(textSize);
    }

    public void lowerCase(View view){
        textSize -= 2;
        fieldTextView.setTextSize(textSize);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("Board Text",boardTextView.getText().toString());
        outState.putString("Field Text", text);
        outState.putInt("Field Text Size",textSize);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            String str = savedInstanceState.getString("Board Text");
            text = savedInstanceState.getString("Field Text");
            textSize = savedInstanceState.getInt("Field Text Size");
            boardTextView.setText(str);
            fieldTextView.setText(text);
            fieldTextView.setTextSize(textSize);
        }
    }



}
