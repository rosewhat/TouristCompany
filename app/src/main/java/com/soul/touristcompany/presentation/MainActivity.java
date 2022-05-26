    package com.soul.touristcompany.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.soul.touristcompany.R;
import com.soul.touristcompany.data.RegisterActivity;
import com.soul.touristcompany.domain.Info;
import com.soul.touristcompany.domain.Tourist;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView imageView;
    private ArrayList<Tourist> tourists;
    private ArrayList<Info> infos;
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

        infos = new ArrayList<>();

        imageViewLike = findViewById(R.id.imageViewLike);
        recyclerView = findViewById(R.id.recyclerView);
       // imageView = findViewById(R.id.imageView);

        tourists = new ArrayList<>();
        tourists.add(new Tourist(R.drawable.home_first, "Созвездие", "Уже пятнадцать лет наша компания создает речные круизы по России"));
        tourists.add(new Tourist(R.drawable.home_second, "СК Москвич", "Столичная компания «Москвич» была образована в 2015 году и с этого момента осуществляет прогулки на теплоходах по Москве-реке"));
        tourists.add(new Tourist(R.drawable.fourth_home, "Туроператор МАЙС", "Туристическая компания МАЙС – туроператор по внутреннему туризму и въездному туризму."));
        tourists.add(new Tourist(R.drawable.home_fourth, "ANEX Tour Russia", "Список открытых направлений постоянно увеличивается, и сегодня наши туристы могут отправиться в любую из 51 страны "));
        tourists.add(new Tourist(R.drawable.tez, "ТЕЗ ТУР", "Международный туристический оператор TEZ TOUR является одной из международных компаний"));




        adapter = new TouristAdapter(this, tourists);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



        if (mAuth.getCurrentUser() != null) {
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