package com.example.myapplication;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.text.DecimalFormat;

public class PriceFragment extends Fragment {

    public PriceFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_price, container, false);

        TextView totalPriceTextView = view.findViewById(R.id.totalPriceTextView);

        double pricePerItemFood = 30.000;
        double pricePerItemDrink = 10.000;

        int foodQuantity = ((CartActivity)getActivity()).foodQuantity;
        int drinkQuantity = ((CartActivity)getActivity()).drinkQuantity;

        double totalAmount = (foodQuantity * pricePerItemFood) + (drinkQuantity * pricePerItemDrink);

        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        String formattedAmount = decimalFormat.format(totalAmount);

        totalPriceTextView.setText("Total Amount: " + formattedAmount);

        return view;
    }
}
