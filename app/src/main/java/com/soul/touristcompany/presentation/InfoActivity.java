package com.soul.touristcompany.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.soul.touristcompany.R;
import com.soul.touristcompany.domain.Tourist;

public class InfoActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private ImageView imageView;
    private TextView textViewDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textViewDescription = findViewById(R.id.textViewDescriptionInfo);
        textViewTitle = findViewById(R.id.textViewTitleInfo);
        imageView = findViewById(R.id.imageViewInfo);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
     //   String description = getIntent().getStringExtra("description");
     //   int image = getIntent().getIntExtra("image", 0);
        textViewTitle.setText(title);
        Toast.makeText(this, "name : " +title , Toast.LENGTH_SHORT).show();
     //   textViewDescription.setText(description);
      //  imageView.setImageResource(image);
    }
}