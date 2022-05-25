package com.soul.touristcompany.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.soul.touristcompany.R;
import com.soul.touristcompany.data.RegisterActivity;
import com.soul.touristcompany.domain.Tourist;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView imageView;
    private ArrayList<Tourist> tourists = new ArrayList<>();
    private TouristAdapter adapter;
    private ImageView imageViewLike;

    private FirebaseFirestore db;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        imageViewLike = findViewById(R.id.imageViewLike);
        recyclerView = findViewById(R.id.recyclerView);
        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Курсовая работа ИКБО-25-20", Toast.LENGTH_SHORT).show();
            }
        });

        tourists.add(new Tourist(R.drawable.g, "Coral Travel", "Крупный представитель на отечественной туристической индустрии."));
        tourists.add(new Tourist(R.drawable.g, "Coral Travel", "Крупный представитель на отечественной туристической индустрии."));
        tourists.add(new Tourist(R.drawable.ic_launcher_foreground, "Coral Travel", "Крупный представитель на отечественной туристической индустрии."));
        tourists.add(new Tourist(R.drawable.ic_launcher_foreground, "Coral Travel", "Крупный представитель на отечественной туристической индустрии."));
        tourists.add(new Tourist(R.drawable.ic_launcher_foreground, "Coral Travel", "Крупный представитель на отечественной туристической индустрии."));


        adapter = new TouristAdapter(tourists);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        if (mAuth.getCurrentUser() != null) {
            Toast.makeText(this, "Необходимо зарегистрироваться", Toast.LENGTH_SHORT).show();
        } else {
            signOut();
        }

    }

    private void signOut() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void addLike(View view) {
        Toast.makeText(this, "Добавлено в избранное", Toast.LENGTH_SHORT).show();
    }
}