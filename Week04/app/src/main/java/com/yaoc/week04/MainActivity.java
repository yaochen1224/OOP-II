package com.yaoc.week04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launch(View view) {
        Intent intent = new Intent(this,Main2Activity.class);
        EditText userName = (EditText)findViewById(R.id.editText);
        intent.putExtra("userName",userName.getText().toString());
        startActivity(intent);
    }
}
