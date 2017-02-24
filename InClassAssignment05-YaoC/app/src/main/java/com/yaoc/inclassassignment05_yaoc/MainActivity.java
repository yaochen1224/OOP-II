package com.yaoc.inclassassignment05_yaoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String whatYouAte;
    double price;
    String emotion ="";
    boolean wasSpicy;
    boolean wasHealthy;
    boolean wasOnDiet;
    ArrayList<Food> previousChoices = new ArrayList<>();

    public void emotionClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.deliciou:
                if(checked)
                    emotion = "delicious";
                break;
            case R.id.notBad:
                if(checked)
                    emotion = "not bad";
                break;
            case R.id.bad:
                if(checked)
                    emotion = "terrible";
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.spicy:
                wasSpicy = checked;
                break;
            case R.id.healthy:
                wasHealthy = checked;
                break;
            case R.id.onDiet:
                wasOnDiet = checked;
                break;
        }
    }

    public void add(View view) {
        whatYouAte = ((EditText)findViewById(R.id.what_you_ate)).getText().toString();
        ((EditText)findViewById(R.id.what_you_ate)).setText("");

        try {
            price = Double.parseDouble(((EditText) findViewById(R.id.price)).getText().toString());
            ((EditText) findViewById(R.id.price)).setText("");
        } catch (Exception e) {
        }

        ((RadioButton) findViewById(R.id.deliciou)).setChecked(false);
        ((RadioButton) findViewById(R.id.notBad)).setChecked(false);
        ((RadioButton) findViewById(R.id.bad)).setChecked(false);

        ((CheckBox) findViewById(R.id.spicy)).setChecked(false);
        ((CheckBox) findViewById(R.id.healthy)).setChecked(false);
        ((CheckBox) findViewById(R.id.onDiet)).setChecked(false);

        previousChoices.add(new Food(whatYouAte,price,emotion,wasSpicy,wasHealthy,wasOnDiet));
        Toast.makeText(getApplicationContext(), "You have successfully added your choice!", Toast.LENGTH_SHORT).show();
    }

    public void display(View view){
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra("Food Objects", previousChoices);
        startActivity(intent);

    }

}
