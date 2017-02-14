package com.yaoc.takehomeassignmentlesson02_part1;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 2;

    public void submitOrder(View view) {
        EditText buyerName = (EditText)findViewById((R.id.buyer_name));
        String name = buyerName.getText().toString();
        CheckBox checkTopping = (CheckBox)findViewById(R.id.whipped_cream);
        boolean hasCheckedTopping = checkTopping.isChecked();
        CheckBox checkChoco = (CheckBox)findViewById(R.id.Chocolate);
        boolean hasCheckedChoco = checkChoco.isChecked();
        int price = quantity * 5;
        if (hasCheckedChoco) price+=2;
        if (hasCheckedTopping) price+=1;
        String message = name + '\n'+ '\n'+"Total: $"+ price + '\n'+"Add whipped cream?"+" "+ hasCheckedTopping+ '\n'+"Add chocolate?"+" "+ hasCheckedChoco+ '\n'+"thank you";



        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,"Order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }



    public void increment(View view) {
        if (quantity>=10){
            Toast.makeText(getApplicationContext(),"cannot exceed 10", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);

    }

    public void decrement(View view) {
            if (quantity<=0){
                Toast.makeText(getApplicationContext(),"cannot less than 0", Toast.LENGTH_SHORT).show();
                return;
            }
            quantity = quantity - 1;
            display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

//    /**
//     * This method displays the given price on the screen.
//     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }
//
//    private void displayMessage(String message) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(message);
//    }
//
//    public void composeEmail(String[] addresses, String subject) {
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
//        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
//    }

}