package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Bundle;
import android .content.Intent;
public class MainActivity extends AppCompatActivity {

    private final int splash = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(MainActivity.this,second.class);
                startActivity(intent);
                finish();
            }
        },splash);
    }
}

