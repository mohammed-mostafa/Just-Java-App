/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.andriod.justjava;


import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);

        displayMessage(priceMessage);

    }

    /**
     * This method is to calculatePrice.
     *
     * @ return the total price
     */
    public int calculatePrice() {
        return quantity * 5;
    }

    /**
     * This method is to create order summary.
     *
     * @ return the order summary
     */
    private String createOrderSummary(int price) {
        String orderSummary = "Name: mohammed" + "\nQuantity: " + quantity;
        orderSummary += "\nTotal $: " + price + " \nThank you";
        return orderSummary;
    }

    /**
     * This method is called when the order + is clicked.
     */
    public void increment(View view) {

        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the order - is clicked.
     */
    public void decrement(View view) {
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
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}