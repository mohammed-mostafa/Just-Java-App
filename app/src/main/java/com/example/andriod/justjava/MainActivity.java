/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.andriod.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox Add_Wipped_Cream = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hasWhippedCream = Add_Wipped_Cream.isChecked();
        CheckBox Add_chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean haschocolate = Add_chocolate.isChecked();
        EditText simpleEditText = (EditText) findViewById(R.id.client_name);
        String AddClientName = simpleEditText.getText().toString();
        Log.v("MainActivity", "The Name Is:" + AddClientName);
        int price = calculatePrice(hasWhippedCream, haschocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, haschocolate, AddClientName);
        displayMessage(priceMessage);

    }


    /**
     * This method is to calculatePrice.
     *
     * @ return the total price
     */
    public int calculatePrice(boolean hasWhippedCream, boolean haschocolate) {
        int basePrice = 5;
        // add 1$ for whipped cream
        if (hasWhippedCream) {
            basePrice += 1;
        }
        // add 2$ for chocolate
        if (haschocolate) {
            basePrice += 2;
        }

        return (quantity * basePrice);
    }


    /**
     * This method is to create order summary.
     *
     * @ return the order summary
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean haschocolate, String AddClientName) {

        String orderSummary = "Name: " + AddClientName + "\nQuantity: " + quantity;
        orderSummary += "\nNeed Whipped Cream: " + hasWhippedCream;
        orderSummary += "\nNeed Chocolate: " + haschocolate;
        orderSummary += "\nTotal $: " + price + " \nThank you";

        return orderSummary;
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
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


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView ordersummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        ordersummaryTextView.setText(message);
    }

}