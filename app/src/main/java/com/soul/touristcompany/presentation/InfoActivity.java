package com.soul.touristcompany.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.soul.touristcompany.R;
import com.soul.touristcompany.domain.Tourist;

public class InfoActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private ImageView imageView;
    private TextView textViewDescription;
    private TextView textViewStreet;


    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textViewDescription = findViewById(R.id.textViewDescriptionInfo);
        textViewTitle = findViewById(R.id.textViewTitleInfo);
        textViewStreet = findViewById(R.id.textViewStreet);

        imageView = findViewById(R.id.imageViewInfo);

        Intent intent = getIntent();

        title = getIntent().getStringExtra("title");
        String description = intent.getStringExtra("description");
        String street = intent.getStringExtra("street");
        int image = getIntent().getIntExtra("image", 0);
        textViewTitle.setText(title);
        textViewDescription.setText(description);
        textViewStreet.setText(street);
        textViewDescription.setText(description);
        imageView.setImageResource(image);


    }

    public void sendMessage(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, title);
        Intent chose = Intent.createChooser(intent, "Выберите приложение");
        startActivity(chose);
    }
}