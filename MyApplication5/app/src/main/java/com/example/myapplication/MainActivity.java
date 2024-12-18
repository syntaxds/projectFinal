package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import kotlin.collections.ArrayDeque;

public class MainActivity extends AppCompatActivity {
    private RecyclerView imageRecycler;
    private CarouselAdapter carouselAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageRecycler = findViewById(R.id.recyclerView);
        imageRecycler.setHasFixedSize(true);
        imageRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<Carousel> carouselList = new ArrayList<>();
        carouselList.add(new Carousel(R.drawable.pizzaa));
        carouselList.add(new Carousel(R.drawable.pizzab));
        carouselList.add(new Carousel(R.drawable.pizzac));
        carouselAdapter = new CarouselAdapter(carouselList);
        imageRecycler.setAdapter(carouselAdapter);




    }

    public void goToCartPage(View view) {
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        startActivity(intent);
    }

    public void goToOrderPage(View view) {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        startActivity(intent);
    }

    public void goToHome(View view) {
        Toast.makeText(this, "You are already on the Home page", Toast.LENGTH_SHORT).show();
    }

    public void goToAccountPage(View view) {
        Intent intent = new Intent(MainActivity.this, AccountPageActivity.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        FirebaseAuth.getInstance().signOut(); // Log out dari Firebase
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Tutup MainActivity
    }
}
