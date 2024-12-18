package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    private int foodQuantity = 0;
    private int drinkQuantity = 0;

    private TextView foodQuantityTextView;
    private TextView drinkQuantityTextView;
    private ImageButton minusFoodButton;
    private ImageButton plusFoodButton;
    private ImageButton minusDrinkButton;
    private ImageButton plusDrinkButton;

    private static final String SHARED_PREFS = "CartPrefs";
    private static final String FOOD_QUANTITY_KEY = "foodQuantity";
    private static final String DRINK_QUANTITY_KEY = "drinkQuantity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        foodQuantityTextView = findViewById(R.id.foodQuantity);
        minusFoodButton = findViewById(R.id.buttonMinusFood);
        plusFoodButton = findViewById(R.id.buttonPlusFood);

        drinkQuantityTextView = findViewById(R.id.drinkQuantity);
        minusDrinkButton = findViewById(R.id.buttonMinusDrink);
        plusDrinkButton = findViewById(R.id.buttonPlusDrink);

        loadQuantitiesFromPreferences();

        updateQuantityDisplay();

        minusFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foodQuantity > 0) {
                    foodQuantity--;
                    updateQuantityDisplay();
                    saveQuantitiesToPreferences();
                }
            }
        });

        plusFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodQuantity++;
                updateQuantityDisplay();
                saveQuantitiesToPreferences();
            }
        });

        minusDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drinkQuantity > 0) {
                    drinkQuantity--;
                    updateQuantityDisplay();
                    saveQuantitiesToPreferences();
                }
            }
        });

        plusDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drinkQuantity++;
                updateQuantityDisplay();
                saveQuantitiesToPreferences();
            }
        });
    }

    private void updateQuantityDisplay() {
        foodQuantityTextView.setText(String.valueOf(foodQuantity));
        drinkQuantityTextView.setText(String.valueOf(drinkQuantity));
    }

    private void loadQuantitiesFromPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        foodQuantity = sharedPreferences.getInt(FOOD_QUANTITY_KEY, 1);
        drinkQuantity = sharedPreferences.getInt(DRINK_QUANTITY_KEY, 1);
    }

    private void saveQuantitiesToPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(FOOD_QUANTITY_KEY, foodQuantity);
        editor.putInt(DRINK_QUANTITY_KEY, drinkQuantity);
        editor.apply();
    }
}
