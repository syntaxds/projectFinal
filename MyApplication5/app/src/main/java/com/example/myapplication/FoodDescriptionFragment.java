package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class FoodDescriptionFragment extends DialogFragment {

    private static final String ARG_DESCRIPTION = "description";

    public static FoodDescriptionFragment newInstance(String description) {
        FoodDescriptionFragment fragment = new FoodDescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_description, container, false);

        TextView descriptionText = view.findViewById(R.id.descriptionText);
        ImageButton closeButton = view.findViewById(R.id.closeButton);

        if (getArguments() != null) {
            String description = getArguments().getString(ARG_DESCRIPTION);
            descriptionText.setText(description);
        }

        closeButton.setOnClickListener(v -> dismiss());

        return view;
    }

    @Override
    public int getTheme() {

        return 0;
    }
}
