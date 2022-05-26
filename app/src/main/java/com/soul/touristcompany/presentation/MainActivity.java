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
        imageView = findViewById(R.id.imageView);

        tourists = new ArrayList<>();
        tourists.add(new Tourist(R.drawable.first_logo, "Coral Travel", "Крупный представитель на отечественной туристической индустрии."));
        tourists.add(new Tourist(R.drawable.second_logo, "ООО КАРЕЛ ТУР", "Бронирование и продажа авиа и жд билетов, туры выходного дня, экзотический и пляжный отдых, комбинированные туры."));
        tourists.add(new Tourist(R.drawable.third_logo, "ТРИА-ТУР»", "Крупный представитель на отечественной туристической индустрии."));
        tourists.add(new Tourist(R.drawable.fourth_logo, "Анекс тур", "Туры, авиабилеты."));
        tourists.add(new Tourist(R.drawable.fifth_logo, "ООО Нео Тур", "Туры в Японию, Проездные JR Pass, билеты в музеи и на мероприятия в Японии ."));

        // заполнение info

        infos.add(new Info("Alean Family Resort & Spa Doville", "Первый и единственный отель категории 5* на Пионерском проспекте в Анапе предлагает VIP-отдых для взрослых и детей по системе «Все Включено».",
                "Адрес: г. Анапа, Пионерский проспект, 14", R.drawable.g));
        infos.add(new Info("LES Art Resort", "Подмосковный отель категории 4*, расположен в лесном массиве. Высокий уровень обслуживания и СПА-услуги привлекают гостей круглый год.", "Адрес: Московская обл., Рузский р-он, СП Дороховское", R.drawable.g));
        // infos.add()


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