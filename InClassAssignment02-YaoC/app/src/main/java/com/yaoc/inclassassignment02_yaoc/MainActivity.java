package com.yaoc.inclassassignment02_yaoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    double result = 0;
    double a = 0;

    String operator = "";


    private void display(double number) {
        TextView quantityTextView = (TextView) findViewById(R.id.number_text_view);
        quantityTextView.setText("" + number);
    }

    /*When press each number button, pull the value of the button*/
    public void onClickNumber(View view) {
        Button button = (Button)view;
        String numberStr = button.getText().toString();
        result = Double.valueOf(numberStr);
        display(result);
    }

//    public void one(View view){
//        result = 1;
//        display(1);
//    }


    public void onClickOperator(View view){
        Button button = (Button)view;
        operator = button.getText().toString();
        a = result;
        result = 0;
    }
//    public void plus(View view){
//        operator = "+";
//        a = result;
//        result = 0;
//        display(a);
//    }



    public void reset(View view){
        a=0;
        result = 0;
        operator = "";
        display(result);
    }


    public void equal(View view){
        if (operator.equals("+")) result += a;
        if (operator.equals("-")) result -= a;
        if (operator.equals("*")) result *= a;
        if (operator.equals("/")) result /= a;
        display(result);

    }
}
