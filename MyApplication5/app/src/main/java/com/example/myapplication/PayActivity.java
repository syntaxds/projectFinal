package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;


import androidx.appcompat.app.AppCompatActivity;

public class PayActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        // Attach click listeners to the buttons
        findViewById(R.id.btnCash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSuccessActivity();
            }
        });

        findViewById(R.id.btnDebitCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSuccessActivity();
            }
        });

        findViewById(R.id.btnPizzaPay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSuccessActivity();
            }
        });
    }

    // Navigate to SuccessActivity
    private void navigateToSuccessActivity() {
        Intent intent = new Intent(PayActivity.this, SuccessActivity.class);
        startActivity(intent);
    }
}
