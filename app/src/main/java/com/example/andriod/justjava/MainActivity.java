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
import android.view.View;
import android.widget.CheckBox;
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

        CheckBox Add_Wipped_Cream = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hasWhippedCream = Add_Wipped_Cream.isChecked();
        CheckBox Add_chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean haschocolate = Add_chocolate.isChecked();
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream, haschocolate);

        displayMessage(priceMessage);

    }

    /**
     * This method is to calculatePrice.
     * a
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
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean haschocolate) {

        String orderSummary = "Name: mohammed" + "\nQuantity: " + quantity;
        orderSummary += "\nNeed Whipped Cream: " + hasWhippedCream;
        orderSummary += "\nNeed Chocolate: " + haschocolate;
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
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView ordersummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        ordersummaryTextView.setText(message);
    }

}