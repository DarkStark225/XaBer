package com.gimba.xaberchords.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gimba.xaberchords.POJOs.ChordModel;
import com.gimba.xaberchords.R;
import com.gimba.xaberchords.app;
import com.gimba.xaberchords.network.ChordsAPI;

import java.io.IOException;
import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button findButton;
    EditText findText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findButton = findViewById(R.id.button);
        findText = findViewById(R.id.editText);



        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String findString = findText.getText().toString();

                app.getChordApi().create(ChordsAPI.class).getChord(findString).
                        enqueue(new Callback<ChordModel>() {
                            @Override
                            public void onResponse(Call<ChordModel> call, Response<ChordModel> response) {
                                //responce.body() - это ответ по сети, туда кладется объект класса ChordModel
                                //дальше просто пользуемся методами определенными в этом классе
                                String TempLink = response.body().getPicture();
                                String name = response.body().getName();

                                //создаем интент для перехода на новую активити
                                //передаем в активити данные полученные по сети
                                if (name!=null && TempLink!=null) {
                                    Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                                    intent.putExtra("name", name);
                                    intent.putExtra("link", TempLink);
                                    startActivity(intent);
                                }
                                else {
                                    Toast toast = Toast.makeText(getApplicationContext(),
                                            "Картинка не найдена!", Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER, 0, 0);
                                    toast.show();
                                }
                            }


                            @Override
                            public void onFailure(Call<ChordModel> call, Throwable t) {
                                Log.d("ok","but we don't have working backend ");
                            }
                        });

            }
        });


    }
}
