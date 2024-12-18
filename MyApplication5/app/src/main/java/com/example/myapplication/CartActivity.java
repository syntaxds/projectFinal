package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

    int foodQuantity = 0;
    int drinkQuantity = 0;

    private TextView quantityTextViewFood;
    private TextView quantityTextViewDrink;
    private TextView emptyCartMessage;
    private View productItemFood;
    private View productItemDrink;
    private Button showPriceFragmentButton;

    private static final String SHARED_PREFS = "CartPrefs";
    private static final String FOOD_QUANTITY_KEY = "foodQuantity";
    private static final String DRINK_QUANTITY_KEY = "drinkQuantity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        quantityTextViewFood = findViewById(R.id.foodQuantity);
        quantityTextViewDrink = findViewById(R.id.drinkQuantity);
        emptyCartMessage = findViewById(R.id.emptyCartMessage);
        productItemFood = findViewById(R.id.productItemFood);
        productItemDrink = findViewById(R.id.productItemDrink);
        showPriceFragmentButton = findViewById(R.id.btnShowPriceFragment);

        loadQuantitiesFromPreferences();

        updateQuantityDisplay();

        showPriceFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the PayActivity when the Pay button is clicked
                Intent intent = new Intent(CartActivity.this, PayActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateQuantityDisplay() {
        quantityTextViewFood.setText(String.valueOf(foodQuantity));
        quantityTextViewDrink.setText(String.valueOf(drinkQuantity));

        if (foodQuantity > 0 || drinkQuantity > 0) {
            emptyCartMessage.setVisibility(View.GONE);
        } else {
            emptyCartMessage.setVisibility(View.VISIBLE);
        }

        productItemFood.setVisibility(foodQuantity > 0 ? View.VISIBLE : View.GONE);
        productItemDrink.setVisibility(drinkQuantity > 0 ? View.VISIBLE : View.GONE);
    }

    private void loadQuantitiesFromPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        foodQuantity = sharedPreferences.getInt(FOOD_QUANTITY_KEY, 0);
        drinkQuantity = sharedPreferences.getInt(DRINK_QUANTITY_KEY, 0);
    }

    private void saveQuantitiesToPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(FOOD_QUANTITY_KEY, foodQuantity);
        editor.putInt(DRINK_QUANTITY_KEY, drinkQuantity);
        editor.apply();
    }
}
