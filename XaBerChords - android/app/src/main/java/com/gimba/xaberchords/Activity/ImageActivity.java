package com.gimba.xaberchords.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.gimba.xaberchords.R;
import com.gimba.xaberchords.app;
import com.squareup.picasso.Picasso;


public class ImageActivity extends AppCompatActivity {
    ImageView imageView;
    TextView nameView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);

        nameView = findViewById(R.id.name);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        nameView.setText(intent.getStringExtra("name"));//получаем через интент навание, полученную через хттп запрос
        String url = intent.getStringExtra("link");//через иненет получаем ссылку, полученную через хттп запрос

        Picasso.get().load(url).into(imageView);//здесь юзается библиотека пикассо, в  одной строчке качаем картинку
        //передаем ей урл и объект в который хотим поместить изображение
    }
}
